package com.imooc.product.dto;

import lombok.Data;

/**
 * @ClassName CartDTO
 * @Description TODO
 * @Author 99795
 * @DaTe 2019/5/3 18:48
 * @Version 1.0
 **/
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;
    public CartDTO(){}
    public  CartDTO(String productId,Integer productQuantity){
        this.productId=productId;
        this.productQuantity=productQuantity;
    }
}
