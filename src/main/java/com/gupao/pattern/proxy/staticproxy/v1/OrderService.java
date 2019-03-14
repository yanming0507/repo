package com.gupao.pattern.proxy.staticproxy.v1;

/**
 * Created by Yan on 2019/3/12.
 */
public class OrderService implements IOrderService {
    private OrderDao orderDao;
    public OrderService(){
        this.orderDao=new OrderDao();
    }
    @Override
    public int insertOrder(Order order) {
        System.out.println("orderService 调用 OrderDao的insertOrder 方法保存订单");
        return  orderDao.insertOrder(order);
    }
}
