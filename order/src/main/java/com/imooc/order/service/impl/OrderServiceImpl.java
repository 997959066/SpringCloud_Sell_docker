package com.imooc.order.service.impl;

import com.imooc.order.client.ProductClient;
import com.imooc.order.dataobject.OrderDetail;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.OrderStatusEnums;
import com.imooc.order.enums.PayStatusEnums;
import com.imooc.order.repository.OrderDetailRepository;
import com.imooc.order.repository.OrderMasterRepository;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName OrderServiceImpl
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 16:04
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private ProductClient productClient;

    /*
     * @Author 99795
     * @Description 创建
     * @Date 16:05 2019/5/3
     * @Param [orderDTO]
     * @return com.imooc.order.dto.OrderDTO
     **/
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId=KeyUtils.genUniqueKey();
        //TODO 查询商品信息
        List<String> productIdList = orderDTO.getOrderDetailList().stream().map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(productIdList);
        //TODO 计算总数
        //总价
        BigDecimal orderAmout=new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()
        ) {
            for (ProductInfo producTInfo : productInfoList
            ) {
                if (producTInfo.getProductId().equals(orderDetail.getProductId())) {
                    //单价*数量
                    orderAmout=producTInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmout);
                    BeanUtils.copyProperties(producTInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtils.genUniqueKey());
                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }
        //TODO 扣库存
        List<CartDTO> cartDTOList=orderDTO.getOrderDetailList().stream().
                map(e->new CartDTO(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);
        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setOrderStatus(OrderStatusEnums.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnums.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
