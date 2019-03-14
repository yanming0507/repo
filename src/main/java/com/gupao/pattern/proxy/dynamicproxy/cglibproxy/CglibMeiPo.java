package com.gupao.pattern.proxy.dynamicproxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Yan on 2019/3/13.
 */
public class CglibMeiPo implements MethodInterceptor {
    public Object getInstance(Class<?>clazz){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object object=methodProxy.invokeSuper(o,objects);
        after();
        return object;
    }

    private void after() {
        System.out.println("cglib 代理之后");
        System.out.println("    觉得合适开始筹办婚事。。");
    }

    private void before() {
        System.out.println("cglib 代理之前");
        System.out.println("    cglib 代理之前 ，对象物色中。。");
    }
}
