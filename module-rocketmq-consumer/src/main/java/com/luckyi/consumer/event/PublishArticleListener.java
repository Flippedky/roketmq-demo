package com.luckyi.consumer.event;

import cn.iocoder.yudao.framework.mq.core.bus.event.PublishArticleEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 订阅公众号监听器 实现 ApplicationListener接口方式
 */
@Component
@Slf4j
public class PublishArticleListener implements ApplicationListener<PublishArticleEvent> {

    @Override
    public void onApplicationEvent(PublishArticleEvent event) {
        log.info("[PublishArticleEvent事件]:{}发布了一新的文章，快来围观！！！",event.getName());
    }

}
