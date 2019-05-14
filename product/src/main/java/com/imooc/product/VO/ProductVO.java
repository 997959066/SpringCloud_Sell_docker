package com.imooc.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName ProductVO
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 11:49
 * @Version 1.0
 **/
@Data
public class ProductVO {
    @JsonProperty("name")
    private  String categoryName;
    @JsonProperty("type")
    private  Integer categroyType;
    @JsonProperty("foods")
    List<ProductInfoVo> productInfoVoList;
}
