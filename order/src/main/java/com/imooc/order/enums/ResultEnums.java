package com.imooc.order.enums;

import lombok.Getter;

/**
 * @ClassName ResultEnums
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 16:36
 * @Version 1.0
 **/
@Getter
public enum ResultEnums {
    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空"),
    ORDER_NOT_EXIST(3, "订单不存在"),
    ORDER_STATUS_ERROR(4, "订单状态错误"),
    ORDER_DETAIL_NOT_EXIST(5, "订单详情不存在"),

            ;
    private  Integer code;

    private String message;
     ResultEnums(Integer code,String message){
    this.code=code;
    this.message=message;
    }

}
