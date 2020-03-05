package com.alibaba.nacos.spring.cloud.rocketmq.consumer.controller;

import com.alibaba.nacos.spring.cloud.rocketmq.consumer.domain.User;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageController {


    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Value("${demo.rocketmq.topic.user}")
    private String userTopic;

    @Value("${demo.rocketmq.topic}")
    private String springTopic;


    @GetMapping("/push")
    public String pushMessage() {

        // Send string
        User user = new User();
        user.setUserName("************** jack ************");
        SendResult sendResult = rocketMQTemplate.syncSend(userTopic, MessageBuilder.withPayload(user).build());

        String result = "sendResult="+sendResult;

        return result;
    }

}
