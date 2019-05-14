package com.imooc.product.controller;


import com.imooc.product.dto.CartDTO;
import com.imooc.product.VO.ProductInfoVo;
import com.imooc.product.VO.ProductVO;
import com.imooc.product.VO.ResultVO;
import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.service.CategoryService;
import com.imooc.product.service.ProductService;
import com.imooc.product.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName ProductController
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 11:57
 * @Version 1.0
 **/
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 1.查询所有在架的商品
     * 2.获取type列表
     * 3.查询类目
     * 4.构造数据
     */
    @GetMapping("/list")
    public ResultVO list() {
        //1.查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpall();
        //2.获取type列表
        List<Integer> ca = productInfoList.stream().
                map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        //3.查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(ca);
        //4.构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList
        ) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategroyType(productCategory.getCategoryType());
            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    //copy属性
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVO.setProductInfoVoList(productInfoVoList);
            productVOList.add(productVO);
        }
        return ResultVOUtils.success(productVOList);
    }

    /*
     * @Author 99795
     * @Description //TODO 获取商品列表Order项目用
     * @Date 18:23 2019/5/3
     * @Param [productIdList]
     * @return java.util.List<com.imooc.product.dataobject.ProductInfo>
     **/
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList) {
        return productService.findList(productIdList);
    }

    /*
     * @Author 99795
     * @Description //TODO 口库存调用
     * @Date 11:40 2019/5/4
     * @Param [cartDTOList]
     * @return void
     **/
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList) {
        productService.decreaseStock(cartDTOList);
    }
}
