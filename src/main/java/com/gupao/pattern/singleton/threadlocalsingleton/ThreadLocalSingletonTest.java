package com.gupao.pattern.singleton.threadlocalsingleton;

/**
 * Created by Yan on 2019/3/11.
 */
public class ThreadLocalSingletonTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"===="+ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName()+"===="+ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName()+"===="+ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName()+"===="+ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName()+"===="+ThreadLocalSingleton.getInstance());
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"===="+ThreadLocalSingleton.getInstance());
                }
            }
        });
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"===="+ThreadLocalSingleton.getInstance());
                }
            }
        });
        thread.start();
        thread1.start();

    }

}
