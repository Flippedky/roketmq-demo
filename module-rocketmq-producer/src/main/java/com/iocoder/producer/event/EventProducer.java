package com.iocoder.producer.event;

import cn.iocoder.yudao.framework.mq.core.bus.AbstractBusProducer;
import cn.iocoder.yudao.framework.mq.core.bus.event.PublishArticleEvent;
import cn.iocoder.yudao.framework.mq.core.bus.event.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 事件生产者
 */
@Component
@Slf4j
public class EventProducer extends AbstractBusProducer {

    /**
     * 发布文章事件
     */
    public void publishArticle(){
        publishEvent(new PublishArticleEvent("小片片说大片",this,getBusId(),allDestinationService()));
        log.info("[PublishArticleEvent]事件发送成功！！！");
    }

    /**
     * 用户注册事件
     */
    public void userRegister(){
        publishEvent(new UserRegisterEvent("高启强",this,getBusId(),allDestinationService()));
        log.info("[UserRegisterEvent]事件发送成功！！！");
    }

}
