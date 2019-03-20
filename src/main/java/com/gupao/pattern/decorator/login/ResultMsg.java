package com.gupao.pattern.decorator.login;

/**
 * Created by Yan on 2019/3/18.
 */
public class ResultMsg {
    private String msg;
    private int code;
    private Object data;

    public ResultMsg(String msg, int code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
