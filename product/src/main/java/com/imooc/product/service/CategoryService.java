package com.imooc.product.service;

import com.imooc.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @ClassName CategoryService
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 11:37
 * @Version 1.0
 **/
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
