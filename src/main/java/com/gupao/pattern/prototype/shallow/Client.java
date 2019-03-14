package com.gupao.pattern.prototype.shallow;

/**
 * Created by Yan on 2019/3/12.
 */
public class Client {
    Prototype prototype;
    public Client(Prototype prototype){
        this.prototype=prototype;
    }
    public Prototype cloneObject(Prototype prototype){
        return prototype.clone();
    }
}
