package com.gupao.pattern.proxy.staticproxy.v1;

/**
 * Created by Yan on 2019/3/12.
 */
public class Order {
    private Object orderInfo;
    private int id;
    private long createTime;

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
