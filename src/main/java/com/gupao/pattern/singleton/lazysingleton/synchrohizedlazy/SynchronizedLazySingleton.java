package com.gupao.pattern.singleton.lazysingleton.synchrohizedlazy;

/**
 * Created by Yan on 2019/3/11.
 * 优点：延迟实例化，不会造成资源浪费
 * 缺点：有性能问题，不适合高并发的场景
 */
public class SynchronizedLazySingleton {
    private static SynchronizedLazySingleton lazySingleton;
    private SynchronizedLazySingleton(){}
    //在静态方法上加上 synchronized 修饰符,该方法锁是类级别的，在性能要求比较高的场合不适合。
    public static synchronized SynchronizedLazySingleton getInstance(){
        if(lazySingleton==null){
            lazySingleton=new SynchronizedLazySingleton();
        }
        return lazySingleton;
    }
}
