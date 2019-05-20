package com.imooc.user.utils;

import java.util.Random;

/**
 * @ClassName KeyUtils
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 16:12
 * @Version 1.0
 **/
public class KeyUtils {
    /*
    * @Author 99795
    * @Description //TODO  简单生主键
    *                 时间加随机数
    * @Date 16:15 2019/5/3
    * @Param []
    * @return java.lang.String
    **/
    public static synchronized String genUniqueKey(){
        Random random =new Random();
        Integer num=random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(num);
    }
}
