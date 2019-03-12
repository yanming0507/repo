package com.gupao.pattern.singleton.innerclassexecutionlogic;

/**
 * Created by Yan on 2019/3/12.
  外部类包含静态内部类的时，调用外部类的属性：
             静态内部类静态代码块执行。。。
             外部类静态代码块
             外部类普通代码块
             外部类构造方法实例化对象。。。
             yanMing

  外部类包含静态内部类的时，调用外部类的静态方法：
         静态内部类静态代码块执行。。。
         外部类静态代码块
         外部类普通代码块
         外部类构造方法实例化对象。。。
         com.gupao.pattern.singleton.innerclassexecutionlogic.StaticInnerClassExecutionLogicDemo@1b6d3586
 外部类包含静态内部类的时，生成外部类实例：
         静态内部类静态代码块执行。。。
         外部类静态代码块
         外部类普通代码块
         外部类构造方法实例化对象。。。
         外部类普通代码块
         外部类构造方法实例化对象。。。
         com.gupao.pattern.singleton.innerclassexecutionlogic.StaticInnerClassExecutionLogicDemo@1b6d3586
 总结：以上三种情况大同小异：
        此时会先执行静态内部类中包含static修饰的属性--》静态代码块会按照从上到下的顺序执行--》但都不会执行静态内部类的普通代码块，
 外部类包含静态内部类的时，直接获取静态内部类的静态属性：
         静态内部类静态代码块执行。。。
         外部类静态代码块
         外部类普通代码块
         外部类构造方法实例化对象。。。
         innerYanMing
        依然不执行静态内部类的普通代码块
 外部类包含静态内部类的时，new一个静态内部类：
         静态内部类静态代码块执行。。。
         外部类静态代码块
         外部类普通代码块
         外部类构造方法实例化对象。。。
         静态内部类普通代码块
         静态内部类实例化。。。。
         com.gupao.pattern.singleton.innerclassexecutionlogic.StaticInnerClassExecutionLogicDemo$InnerClass@1b6d3586
        此时会执行静态内部类的普通代码块，最后执行静态内部类的构造方法，不过此等方式没有任何意义，内部类是为了供外部类使用的。
 */
public class StaticInnerClassExecutionLogicDemo {
    private static String outName="yanMing";
    static {
        System.out.println("外部类静态代码块");
    }
    {
        System.out.println("外部类普通代码块");
    }
    private StaticInnerClassExecutionLogicDemo(){
        System.out.println("外部类构造方法实例化对象。。。");
    }
     public static final StaticInnerClassExecutionLogicDemo getInstance(){
        return InnerClass.STATIC_INNER_CLASS_EXECUTION_LOGIC_DEMO;
    }
    private static class InnerClass{
        static {
            System.out.println("静态内部类静态代码块执行。。。");
        }
        {
            System.out.println("静态内部类普通代码块");
        }
        private static final StaticInnerClassExecutionLogicDemo STATIC_INNER_CLASS_EXECUTION_LOGIC_DEMO=new StaticInnerClassExecutionLogicDemo();
        private static String innerName="innerYanMing";

        InnerClass(){
            System.out.println("静态内部类实例化。。。。");
        }

        /*public static void main(String[] args) {
            System.out.println(StaticInnerClassExecutionLogicDemo.getInstance());
            *//*
            外部类静态代码块
            外部类构造方法实例化对象。。。
            静态内部类静态代码块执行。。。
            com.gupao.pattern.singleton.innerclassexecutionlogic.StaticInnerClassExecutionLogicDemo@1b6d3586
            *//*
        }*/
        public static void main(String[] args) {
            System.out.println( new StaticInnerClassExecutionLogicDemo());
//            System.out.println( StaticInnerClassExecutionLogicDemo.outName);
//            System.out.println(  new StaticInnerClassExecutionLogicDemo.InnerClass());
        }
    }
}
