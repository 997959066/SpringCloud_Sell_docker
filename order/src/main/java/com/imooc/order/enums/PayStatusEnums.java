package com.imooc.order.enums;

import lombok.Getter;

/**
 * @ClassName PayStatusEnums
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 15:29
 * @Version 1.0
 **/
@Getter
public enum PayStatusEnums {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功");
    private  Integer code;

    private  String mssage;

    PayStatusEnums(Integer code ,String mssage){
        this.code=code;
        this.mssage=mssage;
    }

}
