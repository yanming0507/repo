package com.gupao.pattern.observer.event;

/**
 * Created by Yan on 2019/3/20.
 */
public class Mouse extends EventListener {
    public void click(){
        System.out.println("鼠标点击事件触发。。。");
        this.trigger(MouseEventType.ON_CLICK);
    }
    public void down(){
        System.out.println("鼠标点击事件触发。。。");
        this.trigger(MouseEventType.ON_DOWN);
    }
    public void wheel(){
        System.out.println("鼠标滚轮滚动事件触发。。。");
        this.trigger(MouseEventType.ON_WHEEL);
    }
    public void up(){
        System.out.println("鼠标上移事件触发。。。");
        this.trigger(MouseEventType.ON_UP);
    }
    public void doubleClick(){
        System.out.println("鼠标双击事件触发。。。");
        this.trigger(MouseEventType.ON_DOUBLE_LICK);
    }
    public void move(){
        System.out.println("鼠标移动事件触发。。。");
        this.trigger(MouseEventType.ON_MOVE);
    }
}
