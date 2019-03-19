package com.gupao.pattern.adapter.mybusiness.upgrade;

/**
 * Created by Yan on 2019/3/18.
 */
public class Member {
    private String mac;
    private String sn;
    private String info;

    public Member(String mac, String sn, String info) {
        this.mac = mac;
        this.sn = sn;
        this.info = info;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
