package com.alibaba.nacos.spring.cloud.rocketmq.provider;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class RocketMQProviderApplication implements CommandLineRunner {


    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Resource(name = "extRocketMQTemplate")
    private RocketMQTemplate extRocketMQTemplate;

    @Value("${demo.rocketmq.topic.user}")
    private String userTopic;

    @Value("${demo.rocketmq.topic}")
    private String springTopic;

    public static void main(String[] args) {
        SpringApplication.run(RocketMQProviderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Send string
        SendResult sendResult = rocketMQTemplate.syncSend(springTopic, "Hello, World!");
        System.out.printf("syncSend1 to topic %s sendResult=%s %n", springTopic, sendResult);

//        rocketMQTemplate.syncSend("test-topic-1", "Hello, World! I'm from simple message", "18122811143034568830");

        sendResult = extRocketMQTemplate.syncSend(userTopic, "Hello, World!");
        System.out.printf("syncSend1 to topic %s sendResult=%s %n", userTopic, sendResult);
    }
}
