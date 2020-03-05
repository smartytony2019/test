package com.alibaba.nacos.spring.cloud.rocketmq.consumer.consumer;

import com.alibaba.nacos.spring.cloud.rocketmq.consumer.domain.User;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(nameServer = "${demo.rocketmq.myNameServer}", topic = "${demo.rocketmq.topic.user}", consumerGroup = "user_consumer")

public class UserConsumer implements RocketMQListener<User> {
    @Override
    public void onMessage(User user) {
        System.out.println("#################  --> "+user.getUserName());
    }
}
