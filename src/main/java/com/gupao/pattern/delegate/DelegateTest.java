package com.gupao.pattern.delegate;

/**
 * Created by Yan on 2019/3/14.
 */
public class DelegateTest {
    public static void main(String[] args) {
        new Boss(new TeamLeader()).work("加密");
    }
}
