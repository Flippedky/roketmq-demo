package com.luckyi.consumer.listener;

import cn.iocoder.yudao.framework.mq.core.bus.event.SendNoticeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 通知事件监听
 *
 * @author luckily
 * @version 1.0
 * @date 2025-08-12 22:28
 */
@Component
@Slf4j
public class NoticeEventListener {


    @Async // 默认为同步调用 使用 @Async 启动异步执行
    @EventListener(value = SendNoticeEvent.class)
    public void onApplicationEvent(SendNoticeEvent event) {
        log.info("Thread [{}], 收到通知消息 --------> {}", Thread.currentThread().getName(), event.getMessage());
        // 当前线程休眠3s
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
