package com.imooc.user.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ClassName UserInfo$
 * @Description TODO
 * @Author ZSH9440$
 * @Date 2019/5/20$ 15:38$
 * @Version 1.1
 **/
@Data
@Entity
public class UserInfo {
    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

    private Integer role;

}
