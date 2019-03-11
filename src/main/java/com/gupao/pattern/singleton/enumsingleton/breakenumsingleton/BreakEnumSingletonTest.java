package com.gupao.pattern.singleton.enumsingleton.breakenumsingleton;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Yan on 2019/3/11.
 */
public class BreakEnumSingletonTest {
    public static void main(String[] args) {
        Class clazz= EnumSingleton.class;
        try {
            Constructor constructor=clazz.getDeclaredConstructor(String.class, int.class);//调用字节码中的构造
            constructor.setAccessible(true);
            Object o= constructor.newInstance(EnumSingleton.SINGLETON,66);
            /*
            constructor.newInstance(EnumSingleton.SINGLETON,66);该方法调用时会判断修饰符是是枚举类型，是枚举则直接抛出异常
            if ((clazz.getModifiers() & Modifier.ENUM) != 0)
            throw new IllegalArgumentException("Cannot reflectively create enum objects");
            */
            /*

            Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
	at java.lang.reflect.Constructor.newInstance(Constructor.java:417)
	at com.gupao.pattern.singleton.enumsingleton.breakenumsingleton.BreakEnumSingletonTest.main(BreakEnumSingletonTest.java:16)
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
