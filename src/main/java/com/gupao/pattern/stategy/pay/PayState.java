package com.gupao.pattern.stategy.pay;

/**
 * Created by Yan on 2019/3/14.
 */
public class PayState {
    private String msg;
    private int code;
    private Object data;

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

    public PayState(int code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    @Override
    public String toString() {
        return "PayState{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
