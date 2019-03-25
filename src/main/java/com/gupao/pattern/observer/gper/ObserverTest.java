package com.gupao.pattern.observer.gper;

/**
 * Created by Yan on 2019/3/20.
 */
public class ObserverTest {
    public static void main(String[] args) {
        GPer gPer=GPer.getGPer();
        Question question=new Question("小明","spring中的设计模式有哪些？");
        Teacher teacher=new Teacher("tom");
        gPer.addObserver(teacher);
        gPer.addObserver(new
                Teacher("mac"));
        //提交问题、修改被观察者状态、通知观察者们（被观察者已经修改状态）
        gPer.publicQuestion(question);

    }
}
