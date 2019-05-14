package com.imooc.product.service;

import com.imooc.product.dto.CartDTO;
import com.imooc.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {
    /*
     * @Author 99795
     * @Description //TODO 查询所有在架商品列表
     * @Date 18:32 2019/5/3
     * @Param []
     * @return java.util.List<com.imooc.product.dataobject.ProductInfo>
     **/
    List<ProductInfo> findUpall();

    /*
     * @Author 99795
     * @Description //TODO 查询商品列表
     * @Date 18:32 2019/5/3
     * @Param [productIdList]
     * @return java.util.List<com.imooc.product.dataobject.ProductInfo>
     **/
    List<ProductInfo> findList(List<String> productIdList);

    /*
     * @Author 99795
     * @Description //TODO 口库存
     * @Date 18:51 2019/5/3
     * @Param [cartDTOList]
     * @return void
     **/
    void decreaseStock(List<CartDTO> cartDTOList);
}
