package com.kings.base.infrastructure.exception;

import lombok.Data;

/**
 * 系统业务异常，一般与ExceptionCodeEnum配套使用
 * Created on 2019/11/18.
 */
@Data
public class BizException extends Exception {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 响应结果描述
     */
    private String message;

    public BizException(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public BizException(ExceptionCodeEnum exceptionCodeEnum) {
        super();
        this.code = exceptionCodeEnum.getCode();
        this.message = exceptionCodeEnum.getMsg();
    }

    public BizException(Integer code, String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public BizException(ExceptionCodeEnum exceptionCodeEnum, Throwable cause) {
        super(cause);
        this.code = exceptionCodeEnum.getCode();
        this.message = exceptionCodeEnum.getMsg();
    }
}
