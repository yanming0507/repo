package com.gupao.pattern.stategy.mvc;

import java.lang.reflect.Method;

/**
 * Created by Yan on 2019/3/14.
 */
public class Handler {
    //用于保存过对应的方法
    private Method method;
    //用于保存对应的实例
    private Object controller;
    //用于保存访问的url地址
    private String url;

    public Handler(Object controller,Method method,  String url) {
        this.method = method;
        this.controller = controller;
        this.url = url;
    }

    public Object getController() {
        return controller;
    }

    public Handler setController(Object controller) {
        this.controller = controller;
        return this;
    }

    public Method getMethod() {
        return method;
    }

    public Handler setMethod(Method method) {
        this.method = method;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Handler setUrl(String url) {
        this.url = url;
        return this;
    }
}
