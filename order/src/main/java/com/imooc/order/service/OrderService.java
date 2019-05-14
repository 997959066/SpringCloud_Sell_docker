package com.imooc.order.service;

import com.imooc.order.dto.OrderDTO;

/**
 * @ClassName OrderService
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 16:00
 * @Version 1.0
 **/
public interface OrderService {
    /*
    * @Author 99795
    * @Description 创建订单
    * @Date 16:04 2019/5/3
    * @Param [orderDTO]
    * @return com.imooc.order.dto.OrderDTO
    **/
    OrderDTO create(OrderDTO orderDTO);
}
