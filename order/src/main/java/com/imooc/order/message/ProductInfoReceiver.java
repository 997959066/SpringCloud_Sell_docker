package com.imooc.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.utils.JsonUtil;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName ProductInfoReceiver$
 * @Description TODO
 * @Author ZSH9440$
 * @Date 2019/5/14$ 14:31$
 * @Version 1.1
 **/
@Component
@Transactional
public class ProductInfoReceiver {
    public static final String PRODUCT_STOCK_TEMPLATE="product_stock_%s";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        List<ProductInfo> productInfoList = (List<ProductInfo>) JsonUtil.fromJson(message,
                new TypeReference<List<ProductInfo>>() {});
        System.out.println("从队列【{}】接收到消息：{}"+"productInfo"+"message = [" + productInfoList + "]");
        //存储到redis中
        for (ProductInfo productInfo : productInfoList) {
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, productInfo.getProductId()),
                    String.valueOf(productInfo.getProductStock()));
        }
    }
}
