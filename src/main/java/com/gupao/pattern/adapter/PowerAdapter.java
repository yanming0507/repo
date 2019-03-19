package com.gupao.pattern.adapter;

/**
 * Created by Yan on 2019/3/18.
 */
public class PowerAdapter implements DC5 {
    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outPutDC5() {
        int ac200=ac220.outPutAC220();
        int dc5=ac200/44;
        System.out.println("powerAdapter 调用outputDC5 输入"+ac200+" v"+" 输出是 "+dc5+"v" );
        return dc5;
    }
}
