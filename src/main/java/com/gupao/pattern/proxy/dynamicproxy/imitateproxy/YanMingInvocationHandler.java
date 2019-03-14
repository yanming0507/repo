package com.gupao.pattern.proxy.dynamicproxy.imitateproxy;

import java.lang.reflect.Method;

/**
 * Created by Yan on 2019/3/13.
 */
public interface YanMingInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
