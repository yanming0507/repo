package com.gupao.pattern.observer.gper;

/**
 * Created by Yan on 2019/3/20.
 * 被观察者
 */
public class GPer extends java.util.Observable{
    public  String name="咕泡生态圈";
    private static GPer gPer=null;
    private GPer(){}

    public static GPer getGPer(){
        if(gPer==null){
            synchronized (GPer.class){
                if(gPer==null){
                    gPer=new GPer();
                }
            }
        }
        return gPer;
    }

    public void publicQuestion(Question question){
        System.out.println( question.getUserName()+"提交了question" +" 内容为"+question.getContent()+" 在"+this.name+"社区");
        setChanged();//设置被观察者已经被修改了
        notifyObservers(question);//通知所有观察者，被观察的对象已经更改，循环调用观察者实现的update方法
    }
}
