package com.gupao.pattern.prototype.shallow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yan on 2019/3/12.
 * 浅拷贝：
 * clone出的新对象，修改基本类型、String类型属性不影响原始对象对应的属性
 * 但是：修改list类型的属性时，会影响原始对象的对应的属性
 */
public class CloneTest {
    public static void main(String[] args) {
        Original original=new Original();
        List<String> list=new ArrayList<String>();
        list.add("xiMing");
        list.add("xi");
        list.add("xiHo");
        original.setNumber(222);
        original.setName("yanMing");
        original.setFriends(list);
        System.out.println("原始对象 "+original);

        Client client=new Client(original);
        Original prototypeClone=(Original)client.cloneObject(client.prototype);
        prototypeClone.getFriends().add("mingming");//此处修改影响原始对象的引用属性，浅拷贝的危害之处，clone对象和原始对象共享引用对象
        prototypeClone.setNumber(199);//此处不影响原始对象的属性值
        prototypeClone.setName("cloneYanMing");//此处没有修改原始对象对应的属性值
        System.out.println("原始对象 "+original);
        System.out.println("clone之后的对象"+prototypeClone);
        System.out.println("clone之后的对象 friends "+prototypeClone.getFriends());
        System.out.println("原始对象的friends "+original.getFriends());
        System.out.println("原始对象的friends 对比clone对象的friends="+(original.getFriends()==prototypeClone.getFriends()));

    }
}
