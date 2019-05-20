package com.imooc.user.service;

import com.imooc.user.dataobject.UserInfo;

/**
 * @ClassName UserService$
 * @Description TODO
 * @Author ZSH9440$
 * @Date 2019/5/20$ 15:55$
 * @Version 1.1
 **/
public interface UserService {

    /**
     * @Author ZSH9440
     * @Description //TODO
     * @Date 15:56 2019/5/20
     * @param openid
     * @return com.imooc.user.dataobject.UserInfo
     */
    UserInfo findByOpenid(String openid);
}
