package com.kings.base.api.security;

import com.kings.base.business.user.UserInfoService;
import com.kings.base.domain.user.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yangjingsheng
 * @description 用户登录认证信息
 * @date 2020/8/14 15:09
 */
@Service
public class UserBaseServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userInfoService.findByMobile(username);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        // 用户权限列表，根据用户拥有的权限标识与如 @PreAuthorize("hasAuthority('sys:menu:view')") 标注的接口对比，决定是否可以调用接口
        Set<String> permissions = userInfoService.findPermissions(user.getUserId());
        List<GrantedAuthority> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());
        return new UserBase(username, user.getPassword(), grantedAuthorities);
    }
}
