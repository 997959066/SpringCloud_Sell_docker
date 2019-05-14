package com.imooc.order.enums;

import lombok.Getter;

/**
 * @ClassName OrderStatus
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 15:24
 * @Version 1.0
 **/
@Getter
public enum OrderStatusEnums {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"取消");
    private  Integer code;

    private  String mssage;

    OrderStatusEnums(Integer code ,String mssage){
        this.code=code;
        this.mssage=mssage;
    }
}
