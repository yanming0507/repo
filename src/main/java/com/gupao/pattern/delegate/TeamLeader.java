package com.gupao.pattern.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yan on 2019/3/14.
 * 项目经理相当于第一战场的指挥中心
 */
public class TeamLeader implements Employee {
    private static final String FRAME_CONSTRUCTION = "框架搭建";
    private static final String ENCRYPTION = "加密";
    private static Map<String, Employee> register = new HashMap<String, Employee>();

    static {
        register.put(FRAME_CONSTRUCTION, new EmployeeB());
        register.put(ENCRYPTION, new EmployeeA());
    }

    @Override
    public void doSomeThing(String command) {
        System.out.println("项目经理开始干活，指派工作中。。");
        register.get(command).doSomeThing(command);
        System.out.println("项目经理工作结束，汇报工作结果。。。");
    }
}
