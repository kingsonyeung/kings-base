package com.kings.base.infrastructure.vo;

import com.kings.base.infrastructure.exception.ExceptionCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 基本响应报文契约
 * Created on 2019/11/18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO<T> implements Serializable {

    /**
     * 状态码：成功
     */
    public static final int SUCCESS_CODE = 200;

    /**
     * 状态码：异常
     */
    public static final int ERROR_CODE = 500;

    /**
     * 响应结果描述：成功
     */
    public static final String SUCCESS_MSG = "成功！";

    /**
     * 响应结果描述：异常
     */
    public static final String ERROR_MSG = "系统发生异常！";

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 响应结果描述
     */
    private String msg;

    /**
     * 响应内容
     */
    private T data;

    public ResponseVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 创建Response对象
     * 响应状态码：<code>SUCCESS_CODE</code>
     * 响应结果描述：<code>SUCCESS_MSG</code>
     * 响应内容：<code>data</code>
     *
     * @param data
     * @return
     */
    public static ResponseVO success(Object data) {
        return new ResponseVO(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    /**
     * 创建Response对象
     * 响应状态码：<code>ERROR_CODE</code>
     * 响应结果描述：<code>ERROR_MSG</code>
     * 响应内容：<code>data</code>
     *
     * @param data
     * @return
     */
    public static ResponseVO error(Object data) {
        return new ResponseVO(ERROR_CODE, ERROR_MSG, data);
    }

    /**
     * 创建Response对象
     * 响应状态码：<code>ERROR_CODE</code>
     * 响应结果描述：<code>exceptionCodeEnum.getCode()</code>
     * 响应内容：<code>exceptionCodeEnum.getMsg()</code>
     *
     * @param exceptionCodeEnum
     * @return
     */
    public static ResponseVO error(ExceptionCodeEnum exceptionCodeEnum) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(exceptionCodeEnum.getCode());
        responseVO.setMsg(exceptionCodeEnum.getMsg());
        return responseVO;
    }
}
