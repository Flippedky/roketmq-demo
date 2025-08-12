package com.luckyi.consumer;

import cn.iocoder.yudao.framework.mq.core.bus.event.SendNoticeEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@Slf4j
public class ModuleRocketmqConsumerApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void sendEvent() {
        SendNoticeEvent event = new SendNoticeEvent(this, "今天吃饭了吗？");

        log.info("Thread [{}],发送通知消息 --------> {}", Thread.currentThread().getName(), event);
        applicationContext.publishEvent(event);

        log.info("Thread [{}],通知发送成功 --------> {}", Thread.currentThread().getName(), "SUCCESS");
    }

}
