package com.gupao.pattern.adapter.mybusiness.upgrade;

/**
 * Created by Yan on 2019/3/19.
 */
public interface OpenAdapter {
    boolean support(Object adapter);
    ResultMsg open(String mac,String sn,Object adapter);
}
