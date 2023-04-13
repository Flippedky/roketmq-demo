package com.iocoder.consumer.event;

import cn.iocoder.yudao.framework.mq.core.bus.event.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserRegisterSmsConsumer {

    @EventListener
    public void onApplicationEvent(UserRegisterEvent event){
        log.info("[UserRegisterEvent事件]：{}已经注册成为新用户！",event.getUserName());
    }
}
