package com.gupao.pattern.singleton.innerclassexecutionlogic;

/**
 * Created by Yan on 2019/3/12.
 * 外部类包含非静态内部类时：
     1、只操作外部类，执行逻辑：
         外部类静态代码块执行。。。
         外部类普通代码块执行。。。
         外部类构造方法实例化对象。。。
    2、操作内部类，执行逻辑：
          外部类静态代码块执行。。。
         外部类普通代码块执行。。。
         外部类构造方法实例化对象。。。
         内部类的普通代码块
         内部类构造方法实例化对象。。。。
 */
public class InnerClassExecutionLogicDemo {
    private static String outerName = "yanMing";
    private int outerNumber;

    public InnerClassExecutionLogicDemo(int outerNumber) {
        System.out.println("外部类构造方法实例化对象。。。");
        this.outerNumber = outerNumber;
    }

    static {
        System.out.println("外部类静态代码块执行。。。");
    }
    {
        System.out.println("外部类普通代码块执行。。。");
    }

    public static String getOuterName() {
        return outerName;
    }

    public static void setOuterName(String outerName) {
        InnerClassExecutionLogicDemo.outerName = outerName;
    }

    public int getOuterNumber() {
        return outerNumber;
    }

    public void setOuterNumber(int outerNumber) {
        this.outerNumber = outerNumber;
    }

    class InnerClass {
        //        private static int name; //由于该类为非静态内部类，所以无法拥有静态属性
        public InnerClass() {
            System.out.println("内部类构造方法实例化对象。。。。");
            ;
        }

        //        static{} //由于该类属于非静态内部类，所以无法拥有静态代码块
        {
            System.out.println("内部类的普通代码块");
        }
    }

    public static void main(String[] args) {
        InnerClassExecutionLogicDemo outter=new InnerClassExecutionLogicDemo(666);
//        InnerClassExecutionLogicDemo.InnerClass innerClass=outter.new InnerClass();
        /*
        外部类静态代码块执行。。。
        外部类构造方法实例化对象。。。
        内部类的普通代码块
        内部类构造方法实例化对象。。。。
        */
    }
}
