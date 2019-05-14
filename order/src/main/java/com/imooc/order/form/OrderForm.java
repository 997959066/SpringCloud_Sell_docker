package com.imooc.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName OrderForm
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 16:24
 * @Version 1.0
 **/
@Data
public class OrderForm {
    @NotEmpty(message = "姓名不能为空")
    private  String name;
    @NotEmpty(message = "手机号必填")
    private  String phone;
    @NotEmpty(message = "地址必填")
    private  String address;
    @NotEmpty(message = "openid必填")
    private String openid;
    @NotEmpty(message = "购物车不能传控")
    private  String items;
}
