package com.gupao.pattern.singleton.threadlocalsingleton;

/**
 * Created by Yan on 2019/3/11.
 */
public class ThreadLocalSingleton {
    private static ThreadLocal<ThreadLocalSingleton> threadLocalSingletonThreadLocal=new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };
    private ThreadLocalSingleton (){}
    public static ThreadLocalSingleton getInstance(){
        return threadLocalSingletonThreadLocal.get();
    }
}
