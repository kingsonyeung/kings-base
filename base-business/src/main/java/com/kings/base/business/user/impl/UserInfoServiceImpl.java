package com.kings.base.business.user.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kings.base.business.user.UserInfoService;
import com.kings.base.domain.user.entity.UserInfo;
import com.kings.base.domain.user.mapper.UserInfoMapper;
import com.kings.base.infrastructure.vo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangjingsheng
 * @description 类描述
 * @date 2020/8/14 15:00
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 根据手机查找用户
     *
     * @param mobile
     * @return
     * @author yangjingsheng
     * @date 2020/8/14 14:59
     */
    @Override
    public UserInfo findByMobile(String mobile) {
        return userInfoMapper.findByMobile(mobile);
    }

    /**
     * 获取用户权限
     *
     * @param userId
     * @return
     * @author yangjingsheng
     * @date 2020/8/14 14:59
     */
    @Override
    public Set<String> findPermissions(String userId) {
        Set<String> permissions = new HashSet<>();
        permissions.add("/user/list");
        permissions.add("/user/edit");
        return permissions;
    }

    /**
     * 列出用户
     *
     * @param pageParam
     * @return
     * @author yangjingsheng
     * @date 2020/8/14 15:35
     */
    @Override
    public Page<UserInfo> listByPage(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        return userInfoMapper.listByPage(null);
    }
}
