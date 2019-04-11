package com.gupao.spring.mini.servlet.v1;

import com.gupao.spring.mini.annotation.GPAutowired;
import com.gupao.spring.mini.annotation.GPController;
import com.gupao.spring.mini.annotation.GPRequestMapping;
import com.gupao.spring.mini.annotation.GPService;

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
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Yan on 2019/4/10.
 */
public class GPDispatcherServlet extends HttpServlet {
    private Map<String, Object> IOCMapping = new ConcurrentHashMap<String, Object>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("500 exception" + Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath, "").replaceAll("/+", "/");
        if (!this.IOCMapping.containsKey(url)) {
            resp.getWriter().write("404 not found");
            return;
        }
        Method method = (Method) IOCMapping.get(url);
        Map<String, String[]> params = req.getParameterMap();
        method.invoke(this.IOCMapping
                .get(method.getDeclaringClass().getName()),new Object[]{req,resp,params.get("name")[0]});

    }

    /**
     * 初始化上下文，初始化url和method的映射关系
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        InputStream is = null;
        try {
            Properties configContext = new Properties();
            is = this.getClass().getClassLoader().getResourceAsStream(config.getInitParameter("contextConfigLocation"));
            configContext.load(is);
            String scanPackage = configContext.getProperty("scanPackage");
            doScanPackage(scanPackage);
            for (String className : IOCMapping.keySet()) {
                if (!className.contains(".")) {
                    continue;
                }
                Class clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(GPController.class)) {
                    Object o = clazz.newInstance();
                    IOCMapping.put(className, o);
                    System.out.println("ioc 放入 className=" + className + " ,class=" + o);
                    String baseUrl = "";
                    if (clazz.isAnnotationPresent(GPRequestMapping.class)) {
                        GPRequestMapping mapping = (GPRequestMapping) clazz.getAnnotation(GPRequestMapping.class);
                        baseUrl = mapping.value();
                    }
                    Method[] methods = clazz.getMethods();
                    for (Method method : methods) {
                        if (!method.isAnnotationPresent(GPRequestMapping.class)) {
                            continue;
                        } else {
                            GPRequestMapping mapping = method.getAnnotation(GPRequestMapping.class);
                            String url = (baseUrl + "/" + mapping.value()).replaceAll("/+", "/");
                            IOCMapping.put(url, method);
                            System.out.println("ioc 放入 url=" + url + " ,method=" + method);
                        }
                    }
                } else if (clazz.isAnnotationPresent(GPService.class)) {
                    GPService gpService = (GPService) clazz.getAnnotation(GPService.class);
                    String serviceName = gpService.value();
                    if ("".equals(serviceName)) {
                        serviceName = clazz.getName();
                    }
                    Object instance = clazz.newInstance();
                    IOCMapping.put(serviceName, instance);
                    for (Class<?> i : clazz.getInterfaces()) {
                        IOCMapping.put(i.getName(), instance);
                    }
                } else {
                    continue;
                }
            }
            for (Object object : IOCMapping.values()) {
                if (object == null) {
                    continue;
                }
                Class clazz = object.getClass();
                if (clazz.isAnnotationPresent(GPController.class)) {
                    Field[] fields = clazz.getDeclaredFields();
                    for (Field field : fields) {
                        if (!field.isAnnotationPresent(GPAutowired.class)) {
                            continue;
                        }
                        GPAutowired autowired = field.getAnnotation(GPAutowired.class);
                        String filedValue = autowired.value();
                        if ("".equals(filedValue)) {
                            filedValue = field.getType().getName();
                        }
                        field.setAccessible(true);
                        try {
                            field.set(IOCMapping.get(clazz.getName()), IOCMapping.get(filedValue));
                            System.out.println("controller =" + IOCMapping.get(clazz.getName() + " 属性=" + IOCMapping.get(filedValue)));
                        } catch (Exception e
                                ) {
                            e.printStackTrace();
                        }

                    }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 扫描指定包
     *
     * @param scanPackage
     */
    private synchronized void doScanPackage(String scanPackage) {
        URL url = this.getClass().getClassLoader()
                .getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            if (file.isDirectory()) {
                doScanPackage(scanPackage + "." + file.getName());
            } else {
                if (!file.getName().endsWith("class")) {
                    continue;
                }
                String className = scanPackage + "." + file.getName().replace(".class", "");
                IOCMapping.put(className, className);
            }

        }

    }
}
