package com.gupao.pattern.singleton.lazysingleton.synchronizeddoublechecklazy;

/**
 * Created by Yan on 2019/3/11.
 */
public class SynchronizedDoubleCheckExecutorThread implements Runnable {
    @Override
    public void run() {
        SynchronizedDoubleCheckLazySingleton lazySingleton=SynchronizedDoubleCheckLazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+": "+lazySingleton.hashCode());
    }
}
