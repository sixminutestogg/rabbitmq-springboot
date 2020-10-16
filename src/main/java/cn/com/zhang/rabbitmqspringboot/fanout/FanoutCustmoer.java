package cn.com.zhang.rabbitmqspringboot.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 广播
 */
@Component
public class FanoutCustmoer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列（如果没有指定队列名称的话那么创建的就是一个临时队列）
                    exchange = @Exchange(value = "logs",type = "fanout")//绑定的交换机
            )
    })
    public  void receive1(String message){

        System.out.println("message1:"+message);

    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列（如果没有指定队列名称的话那么创建的就是一个临时队列）
                    exchange = @Exchange(value = "logs",type = "fanout")//绑定的交换机
            )
    })
    public  void receive2(String message){

        System.out.println("message2:"+message);

    }
}
