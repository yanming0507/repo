package com.gupao.pattern.prototype.shallow;

import java.util.List;

/**
 * Created by Yan on 2019/3/12.
 */
public class Original implements Prototype {
    private String name;
    private int number;
    private List<String> friends;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Original{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", friends=" + friends +
                '}';
    }

    @Override
    public Original clone() {
        Original original=new Original();
        original.setFriends(this.getFriends());
        original.setName(this.getName());
        original.setNumber(this.getNumber());
        return original;
    }
}
