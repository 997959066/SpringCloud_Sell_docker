package com.imooc.product.exception;

import com.imooc.product.enums.ResultEnums;

/**
 * @ClassName ProductException
 * @Description TODO
 * @Author 99795
 * @DaTe 2019/5/3 18:56
 * @Version 1.0
 **/
public class ProductException extends RuntimeException {
    private  Integer code;
    public  ProductException(Integer code,String message){
        super(message);
        this.code=code;
    }
    public ProductException(ResultEnums resultEnums){
        super(resultEnums.getMessage());
        this.code=resultEnums.getCode();
    }
}
