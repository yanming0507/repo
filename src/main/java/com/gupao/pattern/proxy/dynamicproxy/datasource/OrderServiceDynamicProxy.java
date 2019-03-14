package com.gupao.pattern.proxy.dynamicproxy.datasource;

import com.gupao.pattern.proxy.staticproxy.v2.DynamicDataSourceEntry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yan on 2019/3/12.
 */
public class OrderServiceDynamicProxy implements InvocationHandler {
    private Object target;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();

        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object obj = method.invoke(this.target, args);
        after();
        return obj;
    }

    private void after() {
        System.out.println("proxy after ");
    }

    private void before(Object target) {
        System.out.println("proxy before");
        try {
            long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
            Integer dbRouter = Integer.valueOf(simpleDateFormat.format(new Date(time)));
            System.out.println("动态数据源DB_" + dbRouter);
            DynamicDataSourceEntry.set(dbRouter);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
