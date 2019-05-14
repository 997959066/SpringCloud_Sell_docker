package com.imooc.product.service.impl;

import com.imooc.product.dto.CartDTO;
import com.imooc.product.ProductApplicationTests;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class ProductServiceImplTest extends ProductApplicationTests {
    @Autowired
    private ProductService productService;
    @Test
    public void findUpall() {
        List<ProductInfo> list=productService.findUpall();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findList() {
        List<ProductInfo> list=productService.findList(Arrays.asList("157875196366160022","157875196366160023"));
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void decreaseStock() {
        CartDTO cartDTO=new CartDTO("157875196366160022",2);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }
}