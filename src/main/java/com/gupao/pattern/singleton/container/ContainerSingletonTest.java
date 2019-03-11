package com.gupao.pattern.singleton.container;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Yan on 2019/3/11.
 */
public class ContainerSingletonTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        Semaphore semaphore = new Semaphore(6);
        CountDownLatch countDownLatch=new CountDownLatch(5);
        for (int i = 0; i < 10; i++) {
            try {
                semaphore.acquire();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        ContainerSingleton containerSingleton = (ContainerSingleton) ContainerSingleton.getObject("com.gupao.pattern.singleton.container.ContainerSingleton");
                        System.out.println(Thread.currentThread().getName()+": "+containerSingleton);
                    }
                });
                countDownLatch.countDown();
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();

    }
}
