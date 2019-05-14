package com.imooc.order.dto;

import com.imooc.order.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName OrderDTO
 * @Description 关联对象
 * @Author 99795
 * @DaTe 2019/5/3 16:01
 * @Version 1.0
 **/
@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
