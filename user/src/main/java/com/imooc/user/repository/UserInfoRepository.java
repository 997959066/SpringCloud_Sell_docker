package com.imooc.user.repository;

import com.imooc.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UserInfoRepository$
 * @Description TODO
 * @Author ZSH9440$
 * @Date 2019/5/20$ 15:53$
 * @Version 1.1
 **/
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {

    UserInfo findByOpenid(String openid);
}
