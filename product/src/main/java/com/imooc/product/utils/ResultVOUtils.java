package com.imooc.product.utils;

import com.imooc.product.VO.ResultVO;

/**
 * @ClassName ResultVOUtils
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 12:30
 * @Version 1.0
 **/
public class ResultVOUtils {

    public static ResultVO success(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setDate(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
