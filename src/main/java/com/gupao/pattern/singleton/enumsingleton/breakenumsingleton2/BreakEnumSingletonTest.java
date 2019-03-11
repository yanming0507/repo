package com.gupao.pattern.singleton.enumsingleton.breakenumsingleton2;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Yan on 2019/3/11.
 */
public class BreakEnumSingletonTest {
    public static void main(String[] args) {
        Class clazz= EnumSingleton.class;
        try {
            Constructor constructor=clazz.getDeclaredConstructor();//此处发生异常，底层进行判断是否包含对应的构造方法，因为对应的字节码中没有无参构造，抛出异常
            Object o=constructor.newInstance();
            System.out.println(o);
            /*
            java.lang.NoSuchMethodException: com.gupao.pattern.singleton.enumsingleton.breakenumsingleton2.EnumSingleton.<init>()
	at java.lang.Class.getConstructor0(Class.java:3082)
	at java.lang.Class.getDeclaredConstructor(Class.java:2178)
	at com.gupao.pattern.singleton.enumsingleton.breakenumsingleton2.BreakEnumSingletonTest.main(BreakEnumSingletonTest.java:14)
            */
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
