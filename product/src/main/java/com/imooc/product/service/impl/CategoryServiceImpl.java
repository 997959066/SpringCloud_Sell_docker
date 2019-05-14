package com.imooc.product.service.impl;

import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.repository.ProductCategoryRepository;
import com.imooc.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CategoryServiceImpl
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 11:38
 * @Version 1.0
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    /*
    * @Author 99795
    * @Description //TODO
    * @Date 11:38 2019/5/3
    * @Param [categoryTypeList]
    * @return java.util.List<com.imooc.product.dataobject.ProductCategory>
    **/
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
