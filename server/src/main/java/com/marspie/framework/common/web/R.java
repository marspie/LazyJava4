package com.marspie.framework.common.web;

import com.marspie.framework.common.web.enums.ResultCode;

/**
 * @author alex.yao
 * @version 1.0.0
 * @create 2018-01-10 15:30
 **/
public class R<T> {

    private int code;
    private String msg;
    private T data;

    public R() {
    }

    public R(ResultCode resultCode, T data) {
        this(resultCode);
        this.data = data;
    }

    public R(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public static R success(Object data) {
        return new R(ResultCode.SUCCESS, data);
    }

    public static R warn(ResultCode resultCode, String msg) {
        R<Object> result = new R<Object>(resultCode);
        result.setMsg(msg);
        return result;
    }

    public static R warn(ResultCode resultCode) {
        return new R(resultCode);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
