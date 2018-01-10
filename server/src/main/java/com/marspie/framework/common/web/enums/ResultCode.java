package com.marspie.framework.common.web.enums;

/**
 * @author alex.yao
 * @version 1.0.0
 * @create 2018-01-10 15:32
 **/
public enum  ResultCode {

    SUCCESS(0, "请求成功"),
    WEAK_NET_WORK(-1, "网络异常，请稍后重试"),
    PASSWORD_ERROR(101, "用户名或密码错误"),
    PARAMETER_ERROR(102, "参数错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}