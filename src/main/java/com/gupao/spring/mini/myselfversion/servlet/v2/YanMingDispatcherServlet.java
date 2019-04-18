package com.gupao.spring.mini.myselfversion.servlet.v2;

import com.gupao.spring.mini.myselfversion.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Yan on 2019/4/11.
 */
public class YanMingDispatcherServlet extends HttpServlet {
    //     保存application.properties文件的内容
    private Properties contextConfig = new Properties();
    //    保存所有的类名称
    private List<String> classNames = new ArrayList<String>();
    //    ioc容器
    private Map<String, Object> ioc = new HashMap<String, Object>();
    //    用于保存url和Method的关系
    private Map<String, Method> handlerMapping = new HashMap<String, Method>();
    private static Map<String, Object> IOCMapping = new ConcurrentHashMap<String, Object>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath, "").replaceAll("/+", "/");
        if (!this.handlerMapping.containsKey(url)) {
            resp.getWriter().write("404 not found ");
        }
        Method method =   this.handlerMapping.get(url);
        //TODO 优化点：参数数组不能写死
        if (method != null) {
//            从request中获取参数列表
            Map<String, String[]> params = req.getParameterMap();
//            各个参数的类型
            Class<?>[] parameterTypes = method.getParameterTypes();
            Object[] paramValues = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                Class parameterType = parameterTypes[i];
                if (parameterType == HttpServletResponse.class) {
                    paramValues[i] = resp;
                    continue;
                } else if (parameterType == HttpServletRequest.class) {
                    paramValues[i] = req;
                    continue;
                } else if (String.class == parameterType) {
                    //TODO 这里还存在问题
                    YanMingParam yanMingParam = (YanMingParam) parameterType.getAnnotation(YanMingParam.class);
                    if (params.containsKey(yanMingParam.value())) {
                        for (Map.Entry<String, String[]> param : params.entrySet()) {
                            String value = Arrays.toString(param.getValue())
                                    .replaceAll("\\[|\\]", "")
                                    .replaceAll("\\s", ",");
                            paramValues[i] = value;
                        }
                    }
                }
            }
            String beanName = toLowerFirstCase(method.getDeclaringClass().getName());
            method.invoke(ioc.get(beanName), paramValues);
        }
    }

    private String toLowerFirstCase(String name) {
        char[] chars = name.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        //1、加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));
        System.out.println("加载配置文件完成");
        //扫描相关包
        doScanner(contextConfig.getProperty("scanPackage"));
        System.out.println("扫描包完成");
        // 初始化扫描到的类，并将它们放入到ioc容器之中
        doInstance();
        System.out.println("初始化实例完成");
        //4、完成依赖注入
        doAutowired();
        System.out.println("依赖注入完成");
        //5.初始化initHandlerMapping
        initHandlerMapping();
        System.out.println("初始化url和method之间的对应关系完成");
        System.out.println("YanMing Spring framework is init");
    }

    private void initHandlerMapping() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(YanMingController.class)) {
                continue;
            }
            YanMingRequestMapping requestMapping = (YanMingRequestMapping) clazz.getAnnotation(YanMingRequestMapping.class);
            String baseUrl = requestMapping.value();
            for (Method method : clazz.getDeclaredMethods()
                    ) {
                YanMingRequestMapping methodRequestMapping = method.getAnnotation(YanMingRequestMapping.class);
                String url = ("/" + baseUrl + "/" + methodRequestMapping.value()).replaceAll("/+", "/");
                handlerMapping.put(url, method);
                System.out.println("Mapped :" + url + "," + method);
            }
        }
    }

    private void doAutowired() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(YanMingAutowired.class)) {
                    YanMingAutowired autowired = field.getAnnotation(YanMingAutowired.class);
                    String beanName = "";
                    if (null != autowired) {
                        beanName = autowired.value().trim();
                    }
                    if ("".equals(beanName)) {
                        beanName = field.getType().getName();
                    }
                    field.setAccessible(true);
                    try {
                        field.set(entry.getValue(), ioc.get(beanName));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }

    private void doInstance() {
        if (classNames.isEmpty()) {
            return;
        }
        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(YanMingController.class)) {

                    Object instance = clazz.newInstance();
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    ioc.put(beanName, instance);
                } else if (clazz.isAnnotationPresent(YanMingService.class)) {
                    YanMingService yanMingService = clazz.getAnnotation(YanMingService.class);
                    String beanName = yanMingService.value();
                    if ("".equals(beanName.trim())) {
                        beanName = toLowerFirstCase(clazz.getSimpleName());
                    }
                    Object instance = clazz.newInstance();
                    ioc.put(beanName, instance);
                    for (Class<?> aClass : clazz.getInterfaces()) {
                        if (ioc.containsKey(aClass)) {
                            throw new Exception("The “" + className + "” is exists!!");
                        }
                        ioc.put(aClass.getName(), instance);
                    }
                } else {
                    continue;
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //扫描相关的类
    private void doScanner(String scanPackage) {
//        scanPackage=com.gupao.spring.mini.myselfversion
//        转换为文件路径，实际上就是把.修改为/
        URL url = this.getClass().getClassLoader()
                .getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            }
            if (!file.getName().endsWith(".class")) {
                continue;
            }
            String className = scanPackage +"."+ file.getName().replaceAll(".class", "");
            classNames.add(className);
            System.out.println("扫包时候，放入类 " + className);
        }

    }

    private void doLoadConfig(String contextConfigLocation) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            this.contextConfig.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void registerBeans() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        for (String file : IOCMapping.keySet()) {
            if (!file.contains(".")) {
                continue;
            }
//            Class clazz = file.getClass();
            Class clazz = Class.forName(file);
            //如果类是controller
            if (clazz.isAnnotationPresent(YanMingController.class)) {
                Object instance = clazz.newInstance();
                IOCMapping.put(clazz.getName(), instance);
                System.out.println(" class " + clazz.getName() + " 实例= " + instance);
                //url地址映射
                if (clazz.isAnnotationPresent(YanMingRequestMapping.class)) {
                    YanMingRequestMapping yanMingRequestMapping = (YanMingRequestMapping) clazz.getAnnotation(YanMingRequestMapping.class);
                    String baseUrl = yanMingRequestMapping.value();
                    for (Method method : clazz.getDeclaredMethods()) {
                        method.setAccessible(true);
                        if (!method.isAnnotationPresent(YanMingRequestMapping.class)) {
                            continue;
                        } else {
                            String url = (baseUrl + "/" + method.getAnnotation(YanMingRequestMapping.class).value()).replaceAll("/+", "/");
                            IOCMapping.put(url, method);
                            System.out.println("url=" + url + " method=" + method);
                        }
                    }
                }

            }
            //如果类是service
            else if (clazz.isAnnotationPresent(YanMingService.class)) {
                YanMingService yanMingService = (YanMingService) clazz.getAnnotation(YanMingService.class);
                String serviceName = yanMingService.value();
                if ("".equals(serviceName)) {
                    serviceName = clazz.getName();
                }
                Object instance = clazz.newInstance();
                IOCMapping.put(serviceName, instance);
                System.out.println("service=" + serviceName + " instance=" + instance);
                for (Class<?> c : clazz.getInterfaces()) {
                    IOCMapping.put(c.getName(), instance);
                    System.out.println(" service =" + c.getName() + " 实例 =" + instance);
                }

            } else {
                continue;
            }
        }
    }

    private void scanPackage(String scanPackage) {
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File fileDir = new File(url.getFile());
        for (File file : fileDir.listFiles()) {
            // 若文件夹，继续递归调用
            if (file.isDirectory()) {
                scanPackage(scanPackage + "." + file.getName());
            } else {
                //  文件则把对应的类名称放入ioc容器中
                if (!file.getName().endsWith("class")) {
                    continue;
                }
                String className = scanPackage + "." + file.getName().replace(".class", "");
                IOCMapping.put(className, className);
                System.out.println("扫包时候，放入类 " + className);
            }
        }
    }
}
