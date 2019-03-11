package com.gupao.pattern.singleton.lazysingleton.simplelazy;

/**
 * Created by Yan on 2019/3/11.
 * 懒汉式单例模式，会出现线程安全问题
 * 优点：延迟初始化，不会有资源浪费问题
 * 缺点：有线程安全问题
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {//多线程情况下线程判断会出问题，可能两个线程判断实例是否为null时，都成功进入if代码块，
            lazySingleton = new LazySingleton();//多个线程同时进入后，会有多个线程都执行new操作，这时实例会被重新覆盖或者两个线程使用的时不同的实例对象，这时就会出现不正常的程序逻辑
        }
        return lazySingleton;
    }
}
