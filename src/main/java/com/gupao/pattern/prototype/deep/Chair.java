package com.gupao.pattern.prototype.deep;

import java.io.*;
import java.util.Date;

/**
 * Created by Yan on 2019/3/12.
 */
public class Chair extends Goods implements Cloneable, Serializable {
    public Wheel wheel;

    public Chair() {
        this.createTime = new Date();
        this.wheel = new Wheel();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    private Object deepClone() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStream1 = new ObjectOutputStream(outputStream);
            outputStream1.writeObject(this);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream inputStream1 = new ObjectInputStream(inputStream);
            Chair chairClone = (Chair) inputStream1.readObject();
            chairClone.createTime = new Date();
            return chairClone;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object shallowClone(Chair chair) {
        Chair cloneChair = new Chair();
        cloneChair.createTime=new Date();
        cloneChair.wheel=chair.wheel;
        cloneChair.color=chair.color;
        cloneChair.price=chair.price;
        return cloneChair;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "color='" + color + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                ", wheel=" + wheel +
                '}';
    }
}
