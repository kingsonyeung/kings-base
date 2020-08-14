package com.kings.base.api.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kings.base.infrastructure.exception.ExceptionCodeEnum;
import com.kings.base.infrastructure.vo.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yangjingsheng
 * @description 类描述
 * @date 2020/8/14 16:04
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write(new ObjectMapper().writeValueAsString(ResponseVO.error(ExceptionCodeEnum.ACCESS_DENY)));
    }
}
