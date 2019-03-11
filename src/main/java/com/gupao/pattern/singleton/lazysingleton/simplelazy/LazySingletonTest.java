package com.gupao.pattern.singleton.lazysingleton.simplelazy;

/**
 * Created by Yan on 2019/3/11.
 */
public class LazySingletonTest {
    public static void main(String[] args) {
        Thread thread=new Thread(new ExecutorThread());
        Thread thread1=new Thread(new ExecutorThread());
        thread.start();
        thread1.start();
        System.out.println("main end ");
        /*
        多线程断点调试结果之多线程出现线程安全问题数据情况，两个线程都调用懒汉式单例，进行实例化。
        main end
        Thread-1: 2114875526
        Thread-0: 1348641961
        */

    }
}
