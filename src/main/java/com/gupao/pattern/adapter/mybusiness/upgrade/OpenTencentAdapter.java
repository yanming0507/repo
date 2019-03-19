package com.gupao.pattern.adapter.mybusiness.upgrade;

/**
 * Created by Yan on 2019/3/19.
 */
public class OpenTencentAdapter implements OpenAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof OpenTencentAdapter;
    }

    @Override
    public ResultMsg open(String mac, String sn, Object adapter) {
        System.out.println("开通腾讯服务。。。");
        return null;
    }
}
