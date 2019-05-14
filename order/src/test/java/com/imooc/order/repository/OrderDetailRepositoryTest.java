package com.imooc.order.repository;

import com.imooc.order.OrderApplication;
import com.imooc.order.OrderApplicationTests;
import com.imooc.order.dataobject.OrderDetail;
import com.imooc.order.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {
    @Autowired
    private  OrderDetailRepository orderDetailRepository;
@Test
    public void save(){
    OrderDetail orderDetail =new OrderDetail();
    orderDetail.setDetailId("12345667");
    orderDetail.setOrderId("12345");
    orderDetail.setProductIcon("//fuss10.elemecdn.com/0/49/21212121.jpep");
    orderDetail.setProductName("皮蛋粥");
    orderDetail.setProductId("157875196366160022");
    orderDetail.setProductPrice(new BigDecimal(0.01));
    orderDetail.setProductQuantity(2);
    OrderDetail o=orderDetailRepository.save(orderDetail);
    Assert.assertTrue(o != null);
}
}