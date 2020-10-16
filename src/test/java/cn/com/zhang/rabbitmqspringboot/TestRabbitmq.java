package cn.com.zhang.rabbitmqspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitmqSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitmq {


    @Autowired
    private  RabbitTemplate rabbitTemplate;
    


    //fanout 广播
    @Test
    public void testFanout(){

        rabbitTemplate.convertAndSend("logs","","fanout模型信息发布");
    }


    //work
    @Test
    public void testWork(){

        for (int i = 0 ;i<10;i++){

            rabbitTemplate.convertAndSend("work","work 模式消息第"+i+"条");
        }

    }

    //hello world
    @Test
    public void testHelloWorld(){

        rabbitTemplate.convertAndSend("hello","hello world to the glod");
    }




}
