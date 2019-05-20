package com.imooc.user.service.impl;

import com.imooc.user.dataobject.UserInfo;
import com.imooc.user.repository.UserInfoRepository;
import com.imooc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl$
 * @Description TODO
 * @Author ZSH9440$
 * @Date 2019/5/20$ 15:57$
 * @Version 1.1
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * @Author ZSH9440
     * @Description //TODO 通过 openid 查询用户信息
     * @Date 15:57 2019/5/20
     * @param openid
     * @return com.imooc.user.dataobject.UserInfo
     */
    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
