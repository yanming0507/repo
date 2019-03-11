package com.gupao.pattern.singleton.hungrysingleton;

/**
 * Created by Yan on 2019/3/11.
 * 类加载时就会创建对象实例，线程安全，但是若该实例未使用，则会浪费内存。
 * 有点：没有任何加锁操作（类锁，实例锁）
 * 缺点：在类加载时就进行了初始化实例，可能会造成内存浪费。
 */
public class HungrySingleton {
    private static final HungrySingleton hungrySingleton=new HungrySingleton();
    /*
    private static final HungrySingleton hungrySingleton;
     static{
        hungrySingleton= new HungrySingleton();
     }
    */
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
