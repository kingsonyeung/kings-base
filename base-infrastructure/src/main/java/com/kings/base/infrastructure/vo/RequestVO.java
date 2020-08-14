package com.kings.base.infrastructure.vo;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 基本请求报文契约
 * Created on 2019/11/18.
 */
@Data
public class RequestVO<T> implements Serializable {

    /**
     * 请求ID，需确保ID的唯一型
     */
    @NotNull(message = "请求唯一ID不能为空！")
    private String requestId;

    /**
     * 时间戳
     */
    @NotNull(message = "请求时间戳不能为空！")
    private Long requestTime;

    /**
     * 请求报文内容
     */
    @Valid
    private T payload;
}
