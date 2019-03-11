package com.gupao.pattern.singleton.lazysingleton.simplelazy;

/**
 * Created by Yan on 2019/3/11.
 */
public class ExecutorThread implements Runnable {
    @Override
    public void run() {
        LazySingleton lazySingleton=LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+": "+lazySingleton.hashCode());
    }
}
