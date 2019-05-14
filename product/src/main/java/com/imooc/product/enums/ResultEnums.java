package com.imooc.product.enums;

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
    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "商品库存错误");
    private Integer code;

    private String message;

    ResultEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
