package com.gupao.pattern.proxy.dynamicproxy.datasource;

import com.gupao.pattern.proxy.staticproxy.v2.IOrderService;
import com.gupao.pattern.proxy.staticproxy.v2.Order;
import com.gupao.pattern.proxy.staticproxy.v2.OrderService;

/**
 * Created by Yan on 2019/3/12.
 */
public class DynamicSourceTest {
    public static void main(String[] args) {
        IOrderService orderService=(IOrderService) new OrderServiceDynamicProxy().getInstance(new OrderService());
        orderService.createOrder(new Order());
    }
}
