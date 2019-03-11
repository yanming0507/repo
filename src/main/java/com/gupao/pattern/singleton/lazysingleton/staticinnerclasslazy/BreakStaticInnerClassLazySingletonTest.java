package com.gupao.pattern.singleton.lazysingleton.staticinnerclasslazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Yan on 2019/3/11.
 */
public class BreakStaticInnerClassLazySingletonTest {
    public static void main(String[] args) {
        try {
            //获取类
            Class clazz = StaticInnerClassLazySingleton.class;
            //获取无参构造
            Constructor constructors = clazz.getDeclaredConstructor(null);
            constructors.setAccessible(true);
            Object o = constructors.newInstance(null);
            Object o1 = constructors.newInstance(null);
            System.out.println(o);
            System.out.println(o1);
            System.out.println(o == o1);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        System.out.println("main end ");
    }
}
