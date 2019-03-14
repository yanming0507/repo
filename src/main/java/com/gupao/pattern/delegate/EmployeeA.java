package com.gupao.pattern.delegate;

/**
 * Created by Yan on 2019/3/14.
 * 加密，相当于战争中的后续部队。
 */
public class EmployeeA implements Employee {
    @Override
    public void doSomeThing(String command) {
        System.out.println("员工A开始执行。。"+command+" 任务");
    }
}
