package com.kings.base.api.controller.user;

import com.github.pagehelper.Page;
import com.kings.base.business.user.UserInfoService;
import com.kings.base.domain.user.entity.UserInfo;
import com.kings.base.infrastructure.vo.PageParam;
import com.kings.base.infrastructure.vo.RequestVO;
import com.kings.base.infrastructure.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangjingsheng
 * @description 类描述
 * @date 2020/8/14 15:31
 */
@RestController
@RequestMapping(value = "/user")
@Api(description = "USER")
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    @PreAuthorize("hasAuthority('/user/list')")
    @GetMapping(value = "/findAll")
    @ApiOperation(value = "用户列表")
    public ResponseVO findAll(@RequestBody @Validated RequestVO requestVO) {
        PageParam pageParam = new PageParam(1, 15);
        Page<UserInfo> page = userInfoService.listByPage(pageParam);
        return ResponseVO.success(page);
    }

    @PostMapping(value = "/findByMobile")
    @ApiOperation(value = "根据手机查找用户")
    public ResponseVO findByMobile(@RequestBody @Validated RequestVO<UserInfo> requestVO) {
        UserInfo userInfo = userInfoService.findByMobile(requestVO.getPayload().getMobile());
        return ResponseVO.success(userInfo);
    }
}
