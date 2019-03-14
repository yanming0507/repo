package com.gupao.pattern.proxy.dynamicproxy.meipo;

import com.gupao.pattern.proxy.staticproxy.Person;

/**
 * Created by Yan on 2019/3/12.
 */
public class Customer implements Person {
    @Override
    public void findLove() {
        System.out.println("我的择偶标准是：");
        System.out.println("    高富帅");
        System.out.println("    白富美");
        System.out.println("    大长腿");
    }
}
