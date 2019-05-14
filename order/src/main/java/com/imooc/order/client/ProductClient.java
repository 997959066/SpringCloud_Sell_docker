package com.imooc.order.client;

import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @ClassName ProductClient
 * @Description TODO 调用商品项目接口定义
 * @Author 99795
 * @DaTe 2019/5/3 18:09
 * @Version 1.0
 **/
@FeignClient(name = "product")  //对应调用端
public interface ProductClient {

    @PostMapping("/product/listForOrder")  //完整地址
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    /*
     * @Author 99795
     * @Description //TODO 口库存调用
     * @Date 11:40 2019/5/4
     * @Param [cartDTOList]
     * @return void
     **/
    @PostMapping("/product/decreaseStock")
    public void decreaseStock(@RequestBody  List<CartDTO> cartDTOList);

}
