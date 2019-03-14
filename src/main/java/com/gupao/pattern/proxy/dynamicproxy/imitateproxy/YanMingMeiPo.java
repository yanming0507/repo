package com.gupao.pattern.proxy.dynamicproxy.imitateproxy;

import com.gupao.pattern.proxy.staticproxy.Person;

import java.lang.reflect.Method;

/**
 * Created by Yan on 2019/3/13.
 */
public class YanMingMeiPo implements YanMingInvocationHandler {
    private Person target;

    public Object getInstance(Person target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return YanMingProxy.newInstance(new YanMingClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(this.target,args);
        after();
        return null;
    }

    private void after() {
        System.out.println("闫明代理执行之后");
        System.out.println("    代理结束");
    }

    private void before() {
        System.out.println("闫明代理执行之前");
        System.out.println("    开始物色对象");
        System.out.println("    物色中。。。");

    }
}
