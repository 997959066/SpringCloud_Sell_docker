package com.imooc.order.repository;

import com.imooc.order.OrderApplication;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.enums.OrderStatusEnums;
import com.imooc.order.enums.PayStatusEnums;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class OrderMasterRepositoryTest  extends OrderDetailRepositoryTest {
@Autowired
    private OrderMasterRepository orderMasterRepository;
@Test
    public void  save(){
    OrderMaster orderMaster=new OrderMaster();
    orderMaster.setOrderId("1234567");
    orderMaster.setBuyerAddress("上海市宝山区健配龙");
    orderMaster.setBuyerName("小雨");
    orderMaster.setBuyerPhone("13918479905");
    orderMaster.setOrderId("1234567");
    orderMaster.setBuyerOpenid("110010100");
    orderMaster.setOrderAmount(new BigDecimal(2.5));
    orderMaster.setOrderStatus(OrderStatusEnums.NEW.getCode());
    orderMaster.setPayStatus(PayStatusEnums.WAIT.getCode());
    OrderMaster r=orderMasterRepository.save(orderMaster);
    Assert.assertTrue(r != null);
}
}