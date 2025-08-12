package cn.iocoder.yudao.framework.mq.core.bus.event;

import org.springframework.context.ApplicationEvent;

/**
 * 发送通知事件
 *
 * @author luckily
 * @version 1.0
 * @date 2025-08-12 22:14
 */
public class SendNoticeEvent extends ApplicationEvent {

    private String message;

    public SendNoticeEvent(Object source , String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
