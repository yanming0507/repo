package com.gupao.pattern.adapter.mybusiness.upgrade;

/**
 * Created by Yan on 2019/3/19.
 */
public interface IOpenForThird {
    ResultMsg openIQiYI(String mac,String sn);
    ResultMsg openTencent(String mac,String sn);
    ResultMsg openMongo(String mac,String sn);
    ResultMsg openYouKu(String mac,String sn);
}
