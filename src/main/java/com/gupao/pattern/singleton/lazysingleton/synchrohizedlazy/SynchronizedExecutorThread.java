package com.gupao.pattern.singleton.lazysingleton.synchrohizedlazy;

/**
 * Created by Yan on 2019/3/11.
 */
public class SynchronizedExecutorThread implements Runnable {
    @Override
    public void run() {
        SynchronizedLazySingleton lazySingleton=SynchronizedLazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+": "+lazySingleton.hashCode());
    }
}
