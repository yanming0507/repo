package com.gupao.pattern.observer.event;

import java.lang.reflect.Method;

/**
 * Created by Yan on 2019/3/20.
 * 监听器的包装，标准事件源格式的定义
 */
public class Event {
    /*
    * 事件源，由谁发起的*/
    private Object source;
    /*事件触发，要通知谁*/
    private Object target;
    /*事件触发要做什么动作，用于回调*/
    private Method callBack;
    /*事件的名称，触发的是什么样的事件*/
    private String trigger;
    /*事件触发的时间*/
    private long time;

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", callBack=" + callBack +
                ", trigger='" + trigger + '\'' +
                ", time=" + time +
                '}';
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallBack() {
        return callBack;
    }

    public void setCallBack(Method callBack) {
        this.callBack = callBack;
    }

    public String getTrigger() {
        return trigger;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Event(Object target, Method callBack) {
        this.target = target;
        this.callBack = callBack;
    }
}
