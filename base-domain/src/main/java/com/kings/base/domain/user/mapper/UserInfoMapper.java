package com.kings.base.domain.user.mapper;

import com.github.pagehelper.Page;
import com.kings.base.domain.user.entity.UserInfo;
import com.kings.base.infrastructure.mapper.BasicMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author yangjingsheng
 * @description 用户mapper
 * @date 2020/8/14 14:47
 */
public interface UserInfoMapper extends BasicMapper<UserInfo> {

    /**
     * 获取用户数据
     *
     * @param paramMap
     * @return
     * @author yangjingsheng
     * @date 2020/8/14 14:55
     */
    Page<UserInfo> listByPage(Map<String, Object> paramMap);

    /**
     * 根据手机获取用户信息
     *
     * @param mobile
     * @return
     * @author yangjingsheng
     * @date 2020/8/14 14:55
     */
    UserInfo findByMobile(@Param("mobile") String mobile);
}