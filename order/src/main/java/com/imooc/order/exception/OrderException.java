package com.imooc.order.exception;

import com.imooc.order.enums.ResultEnums;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @ClassName OrderException
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 16:32
 * @Version 1.0
 **/
public class OrderException extends RuntimeException{
    private  Integer code;
    public  OrderException(Integer code,String message){
    super(message);
    this.code=code;
    }
    public OrderException(ResultEnums resultEnums){
        super(resultEnums.getMessage());
        this.code=resultEnums.getCode();
    }
}
