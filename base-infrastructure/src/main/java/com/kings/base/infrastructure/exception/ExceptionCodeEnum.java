package com.kings.base.infrastructure.exception;

/**
 * Created on 2019/11/19.
 */
public enum ExceptionCodeEnum {

    SYSTEM_ERROR(500, "服务器开小差！"),

    ARGUMENT_NOT_VALID_EXCEPTION(501, "参数异常");

    private Integer code;

    private String msg;

    ExceptionCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
