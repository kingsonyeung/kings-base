package com.kings.base.api.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author yangjingsheng
 * @description 权限封装
 * @date 2020/8/14 13:59
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}