package com.gupao.pattern.observer.gper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Yan on 2019/3/20.
 * 观察者
 */
public class Teacher implements Observer {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {//被观察者修改后会修改自己的状态，若通知了观察者们，则会调用各个观察者的update方法
        GPer gPer = (GPer) o;
        Question question = (Question) arg;
        System.out.println("您好 "+this.name+"\n"
        +"您有来自"+gPer.name+ "提交的问题"+"\n"+
        "提交者是"+question.getUserName()+"\n"+
        "提交的内容是"+ question.getContent());
    }
}
