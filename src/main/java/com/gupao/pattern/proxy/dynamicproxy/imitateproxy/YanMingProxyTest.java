package com.gupao.pattern.proxy.dynamicproxy.imitateproxy;

import com.gupao.pattern.proxy.dynamicproxy.meipo.Customer;
import com.gupao.pattern.proxy.staticproxy.Person;

/**
 * Created by Yan on 2019/3/13.
 */
public class YanMingProxyTest {
    public static void main(String[] args) {
        Person person=(Person) new YanMingMeiPo().getInstance(new Customer()  );
        System.out.println(person.getClass());
        person.findLove();
    }
}
