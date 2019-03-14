package com.gupao.pattern.proxy.staticproxy.v2;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yan on 2019/3/12.
 */
public class OrderServiceStaticProxy implements IOrderService {
    private IOrderService orderService;
    public OrderServiceStaticProxy(IOrderService orderService){
        this.orderService=orderService;
    }
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    @Override
    public void createOrder(Order order) {
        before();
        long time=order.getCreateTime();
        Integer dbRouter=Integer.valueOf(sdf.format(new Date()));
        DynamicDataSourceEntry.set(dbRouter);
        System.out.println("动态分配的数据源为="+ DynamicDataSourceEntry.get());
        orderService.createOrder(order);
        DynamicDataSourceEntry.restore();
        after();
    }

    private void after() {
        System.out.println("proxy after");
    }

    private void before() {
        System.out.println("proxy before");
    }

    public static void main(String[] args) {
        Order order=new Order();
        order.setCreateTime(new Date().getTime());
        IOrderService orderService=new OrderServiceStaticProxy(new OrderService());
        orderService.createOrder(order);
    }
}
