package com.imooc.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.order.dataobject.OrderDetail;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.ResultEnums;
import com.imooc.order.exception.OrderException;
import com.imooc.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderForm2OrderDTo
 * @Description TODO  转换
 * @Author 99795
 * @DaTe 2019/5/3 16:43
 * @Version 1.0
 **/
@Slf4j
public class OrderForm2OrderDTo {
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson=new Gson();
    OrderDTO orderDTO=new OrderDTO();
    orderDTO.setBuyerName(orderForm.getName());
    orderDTO.setBuyerPhone(orderForm.getPhone());
    orderDTO.setBuyerAddress(orderForm.getAddress());
    orderDTO.setOrderId(orderForm.getOpenid());
        List<OrderDetail> orderDetailList=new ArrayList<>();
      try {
          orderDetailList=gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());
      }catch (Exception e){
          log.error("【json转换错误，string={}】",orderForm.getItems());
          throw new OrderException(ResultEnums.PARAM_ERROR);
      }
        orderDTO.setOrderDetailList(orderDetailList);
    return  orderDTO;
    }
}
