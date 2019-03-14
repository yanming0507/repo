package com.gupao.pattern.prototype.deep;

import java.io.Serializable;

/**
 * Created by Yan on 2019/3/12.
 */
public class Wheel extends Goods implements Serializable {
    public float h;
    public float d;

    public float getH() {
        return h;
    }

    public void setH(float h) {
        this.h = h;
    }

    public float getD() {
        return d;
    }

    public void setD(float d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "color='" + color + '\'' +
                ", price=" + price +
                ", h=" + h +
                ", createTime=" + createTime +
                ", d=" + d +
                '}';
    }
}
