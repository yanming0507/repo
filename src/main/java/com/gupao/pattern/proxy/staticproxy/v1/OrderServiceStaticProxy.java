package com.gupao.pattern.proxy.staticproxy.v1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yan on 2019/3/12.
 */
public class OrderServiceStaticProxy implements IOrderService {
    private IOrderService orderService;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    public OrderServiceStaticProxy(IOrderService iOrderService) {
        this.orderService = iOrderService;

    }

    @Override
    public int insertOrder(Order order) {
        before();
        long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(sdf.format(new Date(time)));
        System.out.println("静态代理分配的动态数据源为 【db_" + dbRouter + "】 ");
        DynamicDataSourceEntry.set(dbRouter);
        orderService.insertOrder(order);
        DynamicDataSourceEntry.restore();
        after();
        return 0;
    }

    private void before() {
        System.out.println(" proxy before");
    }

    private void after() {
        System.out.println("proxy after");
    }

    public static void main(String[] args) {
        try {
            Order order = new Order();
            order.setCreateTime(new Date().getTime());
            IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
            orderService.insertOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
