package cn.iocoder.yudao.framework.mq.core.bus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.bus.ServiceMatcher;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

import javax.annotation.Resource;

/**
 * 基于 Spring Cloud Bus 实现的 Producer 抽象类
 *
 * @author 芋道源码
 */
public abstract class AbstractBusProducer {

    /**
     * 事件发布功能的接口。
     */
    @Resource
    protected ApplicationEventPublisher applicationEventPublisher;

    /**
     * 在 Spring Cloud Bus 中，消息总线可以将消息广播到不同的服务实例中，而 ServiceMatcher 则是用来确定消息应该发送到哪些服务实例。
     * 具体来说，当一个服务发送消息到消息总线时，消息总线会根据消息中指定的目标服务名称（destination）和实例ID（id）来匹配相应的服务实例，然后将消息发送到这些服务实例中。
     * ServiceMatcher 就是用来实现这个匹配逻辑的。它会根据配置的服务名称和实例ID的模式来匹配目标服务实例，如果匹配成功则返回匹配的服务实例信息。
     */
    @Resource
    protected ServiceMatcher serviceMatcher;

    @Value("${spring.application.name}")
    protected String applicationName;

    protected void publishEvent(RemoteApplicationEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    /**
     * @return 只广播给自己服务的实例 针对于（spring.cloud.bus.id中配置的值）
     */
    protected String selfDestinationService() {
        return applicationName + ":**";
    }

    /**
     * @return 广播给所有服务的实例 针对于（spring.cloud.bus.id中配置的值）
     */
    protected String allDestinationService() {
        return "**";
    }

    protected String getBusId() {
        return serviceMatcher.getBusId();
    }

}
