package com.gupao.pattern.singleton.lazysingleton.staticinnerclasslazy;

/**
 * Created by Yan on 2019/3/11.
 */
public class StaticInnerClassExecutorThread implements Runnable {
    @Override
    public void run() {
        StaticInnerClassLazySingleton lazySingleton=StaticInnerClassLazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+": "+lazySingleton.hashCode());
    }
}
