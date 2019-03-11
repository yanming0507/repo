package com.gupao.pattern.singleton.lazysingleton.synchrohizedlazy;

/**
 * Created by Yan on 2019/3/11.
 */
public class SynchronizedLazySingletonTest {
    public static void main(String[] args) {
        Thread thread=new Thread(new SynchronizedExecutorThread());
        Thread thread1=new Thread(new SynchronizedExecutorThread());
        thread.start();
        thread1.start();
        System.out.println("main end ");


    }
}
