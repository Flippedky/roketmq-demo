package com.iocoder.producer.rockectmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.Msg;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class Producer {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    public void sendMessage(String topic, String body){
        rocketMQTemplate.convertAndSend(topic,body);
        log.info("发送消息成功！！！");
    }

    public void sendMessageInTransaction(String topic, String body){
        String[] tags = new String[]{"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 10; i++) {
            //注意该message为org.springframework.messaging.Message
            Message<String> msg = MessageBuilder.withPayload(body).build();
            //topic和tag整合在⼀起，以":"隔开
            String destination = topic+":"+tags[i % tags.length];
            //第⼀个destination为消息要发到的目的地，第二个destination为消协携带的业务数据
            TransactionSendResult sendResult = rocketMQTemplate.sendMessageInTransaction(destination, msg, destination);
            log.info("发送消息返回：{}",sendResult);
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

}
