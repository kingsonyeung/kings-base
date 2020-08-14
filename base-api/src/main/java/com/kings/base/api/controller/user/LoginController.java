package com.kings.base.api.controller.user;

import com.kings.base.api.security.JwtAuthenticationToken;
import com.kings.base.api.util.SecurityUtils;
import com.kings.base.domain.user.entity.UserInfo;
import com.kings.base.infrastructure.vo.RequestVO;
import com.kings.base.infrastructure.vo.ResponseVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yangjingsheng
 * @description 类描述
 * @date 2020/8/14 11:45
 */
@RestController
@RequestMapping(value = "/user")
@Api(description = "USER")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 登录接口
     */
    @PostMapping(value = "/login")
    public ResponseVO login(@RequestBody RequestVO<UserInfo> requestVO, HttpServletRequest request) {
        String username = requestVO.getPayload().getMobile();
        String password = requestVO.getPayload().getPassword();

        // 系统登录认证
        JwtAuthenticationToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return ResponseVO.success(token);
    }
}
