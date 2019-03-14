package com.gupao.pattern.proxy.staticproxy.v2;

/**
 * Created by Yan on 2019/3/12.
 */
public class OrderDao {
    public int  insertOrder(Order order){
        System.out.println("orderdao insert order success");
        return 1;
    }
}
