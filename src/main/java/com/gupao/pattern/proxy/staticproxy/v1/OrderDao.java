package com.gupao.pattern.proxy.staticproxy.v1;

/**
 * Created by Yan on 2019/3/12.
 */
public class OrderDao {
    public int insertOrder(Order order){
        System.out.println("orderDao insertOrder success");
        return 1;
    }
}
