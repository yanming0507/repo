package com.gupao.spring.mini.myselfversion.servlet.v1;

import com.gupao.spring.mini.myselfversion.annotation.YanMingAutowired;
import com.gupao.spring.mini.myselfversion.annotation.YanMingController;
import com.gupao.spring.mini.myselfversion.annotation.YanMingRequestMapping;
import com.gupao.spring.mini.myselfversion.annotation.YanMingService;

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
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Yan on 2019/4/11.
 */
public class YanMingDispatcherServlet extends HttpServlet {
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
        String contextPath=req.getContextPath();
        url=url.replace(contextPath,"").replaceAll("/+","/");
        if(!IOCMapping.containsKey(url)){
            resp.getWriter().write("404 not found ");
        }
        Method method= (Method) IOCMapping.get(url);

        if(method!=null){
            Map<String ,String []>params=req.getParameterMap();
        method.invoke(IOCMapping.get(method.getDeclaringClass().getName()),new Object[]{req,resp,params.get("name")[0]});
        }
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        //1、定位配置文件
        InputStream inputStream = null;
        Properties properties = new Properties();
        inputStream = this.getClass().getClassLoader().getResourceAsStream(config.getInitParameter("contextConfigLocation"));
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String scanPackage = properties.getProperty("scanPackage");
        //2、加载配置文件
        scanPackage(scanPackage);
        //3、注册（注入ioc容器中）
        try {
            registerBeans();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //4、属性依赖注入
        dIBeans();

    }

    private void dIBeans() {
        for (String className : IOCMapping.keySet()) {
            try {
                if(className.contains(".")){
                Class clazz = Class.forName(className);
                for (Field field : clazz.getDeclaredFields()) {
                    if (!field.isAnnotationPresent(YanMingAutowired.class)) {
                        continue;
                    }
                    YanMingAutowired autowired = field.getAnnotation(YanMingAutowired.class);
                    String filedName = autowired.value();
                    if ("".equals(filedName)) {
                        filedName = field.getType().getName();
                    }
                    field.setAccessible(true);
                    field.set(IOCMapping.get(clazz.getName()), IOCMapping.get(filedName));
                    System.out.println(" controller=" + clazz.getName() + " field =" + filedName);
                }}
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
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
