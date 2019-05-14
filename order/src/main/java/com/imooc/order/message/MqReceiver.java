package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName MqReceiver$
 * @Description TODO
 * @Author ZSH9440$
 * @Date 2019/5/14$ 10:55$
 * @Version 1.1
 **/
@Slf4j
@Component
public class MqReceiver {
   // 1. @RabbitListener(queues = "myQueue")
    //2.自动创建队列
    //@RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //3.自动创建，Exchange和Queue绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),exchange = @Exchange("myExchange")
    ))
    public void process(String message){
        System.out.println("message = [" + message + "]");
    }
}