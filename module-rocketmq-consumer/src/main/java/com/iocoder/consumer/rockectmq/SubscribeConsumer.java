package com.iocoder.consumer.rockectmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.function.Consumer;

@Component
@Slf4j
public class SubscribeConsumer implements Consumer<String> {

    @Override
    public void accept(String message) {
        log.info("收到消息：{}",message);
    }

    @Override
    public Consumer<String> andThen(Consumer<? super String> after) {
        return Consumer.super.andThen(after);
    }
}
