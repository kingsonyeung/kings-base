package com.kings.base.business.user;

import com.github.pagehelper.Page;
import com.kings.base.domain.user.entity.UserInfo;
import com.kings.base.infrastructure.vo.PageParam;

import java.util.Set;

/**
 * @author yangjingsheng
 * @description 类描述
 * @date 2020/8/14 14:57
 */
public interface UserInfoService {
    /**
     * 根据手机查找用户
     *
     * @param username
     * @return
     * @author yangjingsheng
     * @date 2020/8/14 14:59
     */
    UserInfo findByMobile(String username);

    /**
     * 获取用户权限
     *
     * @param userId
     * @return
     * @author yangjingsheng
     * @date 2020/8/14 14:59
     */
    Set<String> findPermissions(String userId);

    /**
     * 列出用户
     *
     * @param pageParam
     * @return
     * @author yangjingsheng
     * @date 2020/8/14 15:35
     */
    Page<UserInfo> listByPage(PageParam pageParam);
}
