package com.gupao.pattern.proxy.staticproxy;

/**
 * Created by Yan on 2019/3/12.
 */
public class Father {
    private Person person;
    public Father(Person person){
        this.person=person;
    }
    public void findLove(){
        System.out.println(" father 开始物色儿媳妇。。。。");
        this.person.findLove();
        System.out.println("家长同意。。。。");
    }
}
