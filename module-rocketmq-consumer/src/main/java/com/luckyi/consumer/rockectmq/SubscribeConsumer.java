package com.luckyi.consumer.rockectmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.function.Consumer;

/**
 * 消费者类 实现Consumer接口
 * <p>
 * 在 stream.function.definition 配置配置当前消费者类 <br>
 * stream.bindings 中添加指定消费者信道 bindingName（消费者类/方法名 + -in- + 序列号 一个方法默认为o）例:subscribeConsumer-in-0 <br>
 * 消费者信道中对应的broker中的topic（stream.bindings."bindingName".destination）有消息后，对应的消费者(bindingName 的消费者类/方法)
 * 会把消息拉过来，然后进行消费，而他之所以能知道要去消费哪一个消息也就是因为这里的绑定好的原因。
 */
@Component
@Slf4j
public class SubscribeConsumer implements Consumer<String> {

    @Override
    public void accept(String message) {
        log.info("收到消息：{}",message);
    }

}
