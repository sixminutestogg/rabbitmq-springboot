package cn.com.zhang.rabbitmqspringboot.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class HelloWorld {


    @RabbitHandler
    public  void recivce(String message){

        System.out.println("message:"+message);
    }
}
