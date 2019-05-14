package com.imooc.order.VO;

import lombok.Data;

/**
 * @ClassName ResultVO
 * @Description 请求返回最外层对象
 * @Author 99795
 * @DaTe 2019/5/3 11:46
 * @Version 1.0
 **/
@Data
public class ResultVO<T> {
    private Integer code;

    private  String msg;

    private T date;
}
