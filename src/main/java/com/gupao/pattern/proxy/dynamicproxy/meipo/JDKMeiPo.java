package com.gupao.pattern.proxy.dynamicproxy.meipo;

import com.gupao.pattern.proxy.staticproxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Yan on 2019/3/12.
 */
public class JDKMeiPo implements InvocationHandler {
    private Object target;

    public Object getInstance(Person target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target, args);
        after();
        return obj;
    }

    private void after() {
        System.out.println("若适合则办事");
    }

    private void before() {
        System.out.println("我是媒婆");
        System.out.println("帮你找对象");
    }
}
