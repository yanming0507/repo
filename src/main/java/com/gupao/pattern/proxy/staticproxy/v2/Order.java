package com.gupao.pattern.proxy.staticproxy.v2;

/**
 * Created by Yan on 2019/3/12.
 */
public class Order {
    private int id;
    private long createTime;
    private Object orderInfo;

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

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", orderInfo=" + orderInfo +
                '}';
    }
}
