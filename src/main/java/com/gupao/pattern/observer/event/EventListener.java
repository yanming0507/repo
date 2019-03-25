package com.gupao.pattern.observer.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yan on 2019/3/20.
 * 监听器，观察者的桥梁
 */
public class EventListener {
    private Map<String, Event> events = new HashMap<String, Event>();

    public void addListener(String eventType, Object target) {
        try {
            this.addListener(eventType, target, target.getClass().getMethod("on" + toUpperFirstCase(eventType), Event.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addListener(String eventType, Object target, Method method) {
        events.put(eventType, new Event(target, method));
    }
    private void trigger(Event event){
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        if(event.getCallBack()!=null){
            try {
                event.getCallBack().invoke(event.getTarget(),event);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
    protected void trigger(String trigger){
        if(events.get(trigger)!=null){
            trigger(events.get(trigger).setTrigger(trigger));
        }else{
            return;
        }
    }

    private String toUpperFirstCase(String eventType) {
        char[] chars = eventType.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

}
