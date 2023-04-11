package com.iocoder.consumer.rockectmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(consumerGroup = "base-consumer-group1", topic = "BaseTopic1")
@Slf4j
public class Consumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("收到消息：{}",message);
    }
}
