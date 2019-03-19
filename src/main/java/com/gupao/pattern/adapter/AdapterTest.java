package com.gupao.pattern.adapter;

/**
 * Created by Yan on 2019/3/18.
 */
public class AdapterTest {
    public static void main(String[] args) {
        AC220 ac220=new AC220();
        PowerAdapter adapter=new PowerAdapter(ac220);
        adapter.outPutDC5();
    }
}
