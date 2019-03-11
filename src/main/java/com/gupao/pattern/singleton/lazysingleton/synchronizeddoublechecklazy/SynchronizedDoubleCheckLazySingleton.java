package com.gupao.pattern.singleton.lazysingleton.synchronizeddoublechecklazy;

/**
 * Created by Yan on 2019/3/11.
 * 延迟加载。线程安全
 * 优点：实例化延迟，线程安全，锁的范围减低
 * 缺点：使用锁，依然有性能问题
 */
public class SynchronizedDoubleCheckLazySingleton {
    private static SynchronizedDoubleCheckLazySingleton lazySingleton = null;

    private SynchronizedDoubleCheckLazySingleton() {
    }

    public static SynchronizedDoubleCheckLazySingleton getInstance() {
        if (lazySingleton == null) {
            synchronized (SynchronizedDoubleCheckLazySingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new SynchronizedDoubleCheckLazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}
