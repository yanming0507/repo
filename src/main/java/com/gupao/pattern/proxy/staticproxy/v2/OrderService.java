package com.gupao.pattern.proxy.staticproxy.v2;

/**
 * Created by Yan on 2019/3/12.
 */
public class OrderService implements IOrderService {
    private OrderDao orderDao;
    public OrderService(){
        this.orderDao=new OrderDao();
    }
    @Override
    public void createOrder(Order order) {
        System.out.println("orderService 调用OrderDao insertOrder");
        orderDao.insertOrder(order);
    }
}
