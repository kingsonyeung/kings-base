package com.kings.base.domain.user.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author yangjingsheng
 * @description 类描述
 * @date 2020/8/14 14:44
 */
@Data
@Table(name = "t_user_info")
public class UserInfo {

    @Id
    @NotNull(message = "userId不能为空!")
    private String userId;
    private Long userNum;
    private String userName;
    private String mobile;
    private String password;
}
