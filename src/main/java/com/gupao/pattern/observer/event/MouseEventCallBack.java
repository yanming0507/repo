package com.gupao.pattern.observer.event;

/**
 * Created by Yan on 2019/3/20.
 */
public class MouseEventCallBack {
    public void onClick(Event event){
        System.out.println("=======鼠标单击事件触发---------"+ event);
    }
    public void onDoubleClick(Event event){
        System.out.println("=======鼠标双击事件触发---------"+ event);
    }
}
