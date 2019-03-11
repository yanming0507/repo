package com.gupao.pattern.singleton.lazysingleton.synchronizeddoublechecklazy;

/**
 * Created by Yan on 2019/3/11.
 */
public class SynchronizedDoubleCheckLazySingletonTest {
    public static void main(String[] args) {
        Thread thread=new Thread(new SynchronizedDoubleCheckExecutorThread());
        Thread thread1=new Thread(new SynchronizedDoubleCheckExecutorThread());
        thread.start();
        thread1.start();
        System.out.println("main end ");


    }
}
