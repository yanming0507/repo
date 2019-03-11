package com.gupao.pattern.singleton.lazysingleton.staticinnerclasslazy;

/**
 * Created by Yan on 2019/3/11.
 * 静态内部类单例模式，解决了资源浪费，synchronized的性能问题
 * 同时没有线程安全问题（静态内部类使用final关键字修饰外部实例，自己写的那个案例是有线程安全问题的）
 */
public class StaticInnerClassLazySingleton {
    private StaticInnerClassLazySingleton() {
        if(InnerClass.LAZY_SINGLETON!=null){
            throw  new RuntimeException("单例已经创建不可再次创建");
        }
    }

    /*
    自己写的，这种方式会有线程安全问题，可以同过final的内存语义来避免线程安全问题
    public static StaticInnerClassLazySingleton getInstance(){
     return InnerClass.createInstance();
     }
     private static class InnerClass{
         public static StaticInnerClassLazySingleton createInstance(){
             if(lazySingleton==null){//断点处，多个线程可以同时到达此处，会存在线程安全问题，每个线程都创建了一个实例。完美的违背了单例。
                 lazySingleton=new StaticInnerClassLazySingleton();
             }
             return lazySingleton;
         }
     } */
    public static final StaticInnerClassLazySingleton getInstance() {
        return InnerClass.LAZY_SINGLETON;
    }

    private static class InnerClass {
        //使用final修饰，从jvm层面就避免了线程安全问题。详见java并发编程的艺术第三章3.6 final 于的内存语义（55页）
        private static final StaticInnerClassLazySingleton LAZY_SINGLETON = new StaticInnerClassLazySingleton();
    }

}
