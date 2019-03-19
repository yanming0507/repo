package com.gupao.pattern.stategy.pay;

/**
 * Created by Yan on 2019/3/14.
 */
public class Order {
    private String userId;
    private String orderId;
    private double count;

    public Order(String userId, String orderId, double count) {
        this.userId = userId;
        this.orderId = orderId;
        this.count = count;
    }

    public  Payment pay(){
        return PayStrategy.getPayment("");
    }
    public  PayState pay(String payType){
        Payment payment=PayStrategy.getPayment(payType);
        System.out.println("本次交易"+payment.getName());
        System.out.println("本次交易金额 "+count+" 开始扣款");
        return payment.payState(userId,count);
    }
}
