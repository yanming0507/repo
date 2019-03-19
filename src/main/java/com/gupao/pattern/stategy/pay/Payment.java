package com.gupao.pattern.stategy.pay;

/**
 * Created by Yan on 2019/3/14.
 * 定义上层抽象支付方式
 */
public abstract class Payment {
    public abstract String getName();
    public abstract double queryBalance(String userId);
    public PayState payState(String userId,double price){
        if(queryBalance(userId)<price){
            return new PayState(500,this.getName()+"支付失败，余额不足");
        }else{
            return new PayState(200,this.getName()+"支付成功，扣款"+price);
        }
    }
}
