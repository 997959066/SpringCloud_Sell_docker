package com.imooc.order.controller;

import com.imooc.order.VO.ResultVO;
import com.imooc.order.converter.OrderForm2OrderDTo;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.ResultEnums;
import com.imooc.order.exception.OrderException;
import com.imooc.order.form.OrderForm;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.ResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName OrderController
 * @Description TOOD
 * @Author 99795
 * @DaTe 2019/5/3 16:21
 * @Version 1.0
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVO<Map<String ,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
    log.error("创建订单参数不正确，orderForm={}",orderForm);
    throw new OrderException(ResultEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        //转换
        OrderDTO orderDTO= OrderForm2OrderDTo.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
        log.error("【创建订单】购物车信息为空");
        throw  new OrderException(ResultEnums.CART_EMPTY);
        }
       OrderDTO result= orderService.create(orderDTO);
        Map<String ,String> map=new HashMap<>();
        map.put("orderId",result.getOrderId());
        return ResultVOUtils.success(map);
    }


    /**
     * 完结订单
     * @param orderId
     * @return
     */
    @PostMapping("/finish")
    public ResultVO<OrderDTO> finish(@RequestParam("orderId") String orderId) {
        return ResultVOUtils.success(orderService.finish(orderId));
    }
}
