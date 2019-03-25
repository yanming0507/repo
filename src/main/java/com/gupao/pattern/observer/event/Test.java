package com.gupao.pattern.observer.event;

/**
 * Created by Yan on 2019/3/20.
 */
public class Test {
    public static void main(String[] args) {
        MouseEventCallBack callBack=new MouseEventCallBack();
       Mouse mouse=new Mouse();
       mouse.addListener(MouseEventType.ON_CLICK,callBack);
       mouse.click();
    }
}
