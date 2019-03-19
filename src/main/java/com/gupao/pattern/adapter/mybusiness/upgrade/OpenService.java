package com.gupao.pattern.adapter.mybusiness.upgrade;

/**
 * Created by Yan on 2019/3/19.
 */
public class OpenService {
    public ResultMsg openDaMai(String mac,String sn){
        System.out.println("开通大麦服务");
        return new ResultMsg("开通大麦服务成功",200,new Member("macmacmac","snsnsn","eeee"));
    }
    public ResultMsg openThird(String mac,String sn){
        return null;
    }
}
