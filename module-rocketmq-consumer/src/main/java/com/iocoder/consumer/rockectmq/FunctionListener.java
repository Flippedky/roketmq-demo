package com.iocoder.consumer.rockectmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * 消费者类 添加多个消费方法
 * <p>
 * 在 stream.function.definition 配置配置当前消费方法（例：acceptMessage）<br>
 * stream.bindings 中添加指定消费者信道 bindingName（消费者类/方法名 + -in- + 序列号 一个方法默认为0）例:subscribeConsumer-in-0 <br>
 * 消费者信道（bindingName）中配置的 RocketMq Broker中的 topic（stream.bindings."bindingName".destination）有消息后，对应的消费者信道(bindingName 的消费者类/方法)会把消息拉过来，然后进行消费，而他之所以能知道要去消费哪一个消息也就是因为这里的绑定好的原因。
 * 所以如果你一个类中声明了多个的消费方法，只需要再function.definition这个地方声明出你方法的名称，并且再代码里面使用@Bean的方式去声明出对应的方法即可
 */
@Component
@Slf4j
public class FunctionListener {

    @Bean
    public Consumer<String> acceptMessage(){
        return msg ->  log.info("acceptMessage:"+msg);
    }
}
