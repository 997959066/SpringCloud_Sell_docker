package com.imooc.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName ProductInfoVo
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 11:52
 * @Version 1.0
 **/
@Data
public class ProductInfoVo {
    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("description")
    private String productDescription;
    @JsonProperty("ico")
    private String productIcon;

}
