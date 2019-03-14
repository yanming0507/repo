package com.gupao.pattern.delegate;

/**
 * Created by Yan on 2019/3/14.
 * 框架搭建，相当于战争中的先锋部队
 */
public class EmployeeB implements Employee {
    @Override
    public void doSomeThing(String command) {
        System.out.println("员工B开始执行任务。。"+command+" .....");
    }
}
