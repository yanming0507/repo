package com.gupao.pattern.prototype.deep;

import java.util.Date;

/**
 * Created by Yan on 2019/3/12.
 * 浅复制会导致新老实例共用属性中的引用类型，修改会影响彼此
 * 深度复制会生成一个新的引用类型的属性，但是新的引用类型的对象一些属性会变更为默认值
 */
public class DeepCloneTest {

    public static void main(String[] args) {
        Chair chair=new Chair();
        Wheel wheel=new Wheel();
        wheel.color="green";
        wheel.price=10;
        wheel.d=10;
        wheel.h=20;
        wheel.createTime=new Date();
        chair.wheel= wheel;
        chair.color="green";
        chair.price=100;
        System.out.println("原始对象 "+chair);
        try {
            Chair cloneChair=(Chair) chair.clone();
            System.out.println(" 深度复制对象 "+cloneChair);
            System.out.println(" 深度复制之后 对比 "+(cloneChair.wheel==chair.wheel));

            Chair shallowClone=(Chair) chair.shallowClone(chair);
            System.out.println(" 浅复制对象 "+shallowClone);
            System.out.println(" 浅复制之后 对比 "+(shallowClone.wheel==chair.wheel));
            /*
            原始对象 Chair{color='green', price=100, createTime=Tue Mar 12 16:09:20 CST 2019, wheel=Wheel{color='green', price=10, h=20.0, createTime=Tue Mar 12 16:09:20 CST 2019, d=10.0}}
             深度复制对象 Chair{color='null', price=0, createTime=Tue Mar 12 16:09:20 CST 2019, wheel=Wheel{color='null', price=0, h=20.0, createTime=null, d=10.0}}
             深度复制之后 对比 false
             浅复制对象 Chair{color='green', price=100, createTime=Tue Mar 12 16:09:20 CST 2019, wheel=Wheel{color='green', price=10, h=20.0, createTime=Tue Mar 12 16:09:20 CST 2019, d=10.0}}
             浅复制之后 对比 true
            */
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
