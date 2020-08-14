package com.kings.base.infrastructure.exception;

import com.kings.base.infrastructure.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理类
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 对系统未知的异常进行处理
     * @param response
     * @param ex
     * @return 统一返回“系统异常”的提示
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseVO handleException(HttpServletResponse response, Exception ex) {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        log.error("GlobalExceptionHandler 捕获系统异常: ", ex);
        return ResponseVO.error(ExceptionCodeEnum.SYSTEM_ERROR);
    }

    /**
     * 对参数绑定的异常进行处理
     *
     * @param response
     * @param ex
     * @return 统一返回“参数异常”的提示
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseVO handleException(HttpServletResponse response, MethodArgumentNotValidException ex) {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        log.error("GlobalExceptionHandler 捕获参数异常: ", ex);
        String exMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(ExceptionCodeEnum.ARGUMENT_NOT_VALID_EXCEPTION.getCode());
        responseVO.setMsg(exMessage);
        return responseVO;
    }

    /**
     * 对已知的业务已经进行处理
     * @param response
     * @param ex
     * @return 根据已知的业务异常进行提示返回
     */
    @ExceptionHandler(BizException.class)
    @ResponseBody
    public ResponseVO handleApiGatewayException(HttpServletResponse response, Exception ex) {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        BizException bizException = (BizException) ex;
        return new ResponseVO(bizException.getCode(), bizException.getMessage());
    }
}
