package com.gupao.spring.mini.myselfversion.servlet.v3;

import com.gupao.spring.mini.myselfversion.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yan on 2019/4/11.
 */
public class YanMingDispatcherServlet extends HttpServlet {
    //用于保存application.properties配置文件信息
    private Properties contextConfig = new Properties();
    //    保存所有类名称
    private List<String> classNames = new ArrayList<String>();
    //IOC容器，用于保存
    private Map<String, Object> ioc = new HashMap<String, Object>();
    //    用于保存url和method之间的映射关系
    private List<Handler> handlerMapping = new ArrayList<Handler>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 Exception detail "+Arrays.toString(e.getStackTrace()));
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        Handler handler = getHandler(req);
        if (handler == null) {
            resp.getWriter().write("404 not found");
            return;
        }
//        获取参数类型数组
        Class<?> paramTypes[] = handler.getParamTypes();
        Object values[] = new Object[paramTypes.length];
        Map<String, String[]> params = req.getParameterMap();
//        设置url对应的参数值数组
        for (Map.Entry<String, String[]> entry : params.entrySet()) {
            String value = Arrays.toString(entry.getValue()).replaceAll("\\[|\\]", "").replaceAll("\\s", "");
            if (!handler.paramIndexMapping.containsKey(entry.getKey())) {
                continue;
            }
            int index = handler.paramIndexMapping.get(entry.getKey());
            values[index]=convert(paramTypes[index],value);
        }
        if(handler.paramIndexMapping.containsKey(HttpServletRequest.class.getName())){
            int index=handler.paramIndexMapping.get(HttpServletRequest.class.getName());
            values[index]=req;
        }
        if(handler.paramIndexMapping.containsKey(HttpServletResponse.class.getName())){
            int index=handler.paramIndexMapping.get(HttpServletResponse.class.getName());
            values[index]= resp;
        }



//        反射调用对应controller的method（传入对应的参数值）

        Object result=handler.getMethod().invoke(handler.getController(), values);
        if(null==result || result instanceof Void){
            return;
        }
        resp.getWriter().write(result.toString());


    }

    private Object convert(Class<?> paramType, String value) {
        if(Integer.class==paramType){
            return Integer.valueOf(value);
        }else if(Double.class==paramType){
            return Double.valueOf(value);
        }
        return value;
    }

    private Handler getHandler(HttpServletRequest req) {
        if (handlerMapping.isEmpty()) {
            return null;
        }
        String url = req.getRequestURI();
        String baseUrl = req.getContextPath();
        url = url.replaceAll(baseUrl, "").replaceAll("/+", "/");
        for (Handler handler : handlerMapping) {
            Matcher matcher = handler.getPattern().matcher(url);
            if (!matcher.matches()) {
                continue;
            }
            return handler;
        }
        return null;
    }

    /**
     * 初始化阶段
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
//         1、加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));
//2、扫描相关的类
        doScanner(contextConfig.getProperty("scanPackage"));
//        3、初始化扫描到的类，并放入ioc容器之中
        doInstance();
//        4、完成依赖注入
        doAutowired();
//        5、初始化handlerMapping
        initHandlerMapping();
    }

    private void initHandlerMapping() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            if (clazz.isAnnotationPresent(YanMingController.class)) {
                YanMingRequestMapping baseUrlMapping = clazz.getAnnotation(YanMingRequestMapping.class);
                String baseUrl = baseUrlMapping.value();
                for (Method method : clazz.getDeclaredMethods()) {
                    YanMingRequestMapping methodMapping = method.getAnnotation(YanMingRequestMapping.class);
                    String url = ("/" + baseUrl + "/" + methodMapping.value()).replaceAll("/+", "/");
                    Pattern pattern = Pattern.compile(url);
                    handlerMapping.add(new Handler(pattern, entry.getValue(), method));
                }


            }
        }


    }

    private void doAutowired() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> stringObjectEntry : ioc.entrySet()) {
            if (stringObjectEntry.getValue().getClass().isAnnotationPresent(YanMingController.class)) {
                Object controllerBean = stringObjectEntry.getValue();
                Field[] fields = controllerBean.getClass().getDeclaredFields();//再次是这里出现了问题
                for (Field field : fields) {
                    if (field.isAnnotationPresent(YanMingAutowired.class)) {
                        Class<?> clazzType = field.getType();
                        field.setAccessible(true);
                        try {
                            field.set(ioc.get(controllerBean.getClass().getName()), ioc.get(clazzType.getName()));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
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
                /*自己写的太简单，有问题。className为完类名称
                //TODO 需要完善，增加类名称大小写转化功能
                //                    ioc.put(className,instance);*/
                    ioc.put(className, instance);
                } else if (clazz.isAnnotationPresent(YanMingService.class)) {
                    Object yanMingService =  clazz.newInstance();
                    //TODO 这里有问题                        /**/
                    ioc.put(className, yanMingService);
                    for (Class<?> aClass : clazz.getInterfaces()) {
                        String interfaceName = aClass.getName();
                        ioc.put(interfaceName, yanMingService);
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
            }
        }

    }

    private void doScanner(String scanPackage) {
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File filePath = new File(url.getFile());
        for (File file : filePath.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                classNames.add(scanPackage + "." + file.getName().replaceAll(".class", ""));
            }
        }

    }

    private void doLoadConfig(String contextConfigLocation) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            this.contextConfig.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class Handler {
        private Pattern pattern;
        private Method method;
        private Object controller;
        private Class<?>[] paramTypes;

        public Pattern getPattern() {
            return pattern;
        }

        public Method getMethod() {
            return method;
        }

        public Object getController() {
            return controller;
        }

        public Class<?>[] getParamTypes() {
            return paramTypes;
        }

        private Map<String, Integer> paramIndexMapping;

        public Handler(Pattern pattern, Object controller, Method method) {
            this.pattern = pattern;
            this.controller = controller;
            this.method = method;
            paramTypes = method.getParameterTypes();
            paramIndexMapping = new HashMap<String, Integer>();
            putParamIndexMapping(method);

        }

        private void putParamIndexMapping(Method method) {
            Annotation[][] annotations = method.getParameterAnnotations();
            for (int i = 0; i < annotations.length; i++) {
                for (Annotation annotation : annotations[i]) {
                    if (annotation instanceof YanMingParam) {
                        String name = ((YanMingParam) annotation).value().trim();
                        if (!"".equals(name)) {
                            paramIndexMapping.put(name, i);
                        }
                    }
                }

            }
            for (int i = 0; i < paramTypes.length; i++) {
                Class<?> paramType = paramTypes[i];
                if (HttpServletRequest.class == paramType || HttpServletResponse.class == paramType) {
                    paramIndexMapping.put(paramType.getName(), i);
                }
            }


        }

    }
}
