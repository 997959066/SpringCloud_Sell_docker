package com.imooc.user.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    BUYER(1,"卖家"),
    SELLER(2,"买家"),;
    private Integer code;
    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
