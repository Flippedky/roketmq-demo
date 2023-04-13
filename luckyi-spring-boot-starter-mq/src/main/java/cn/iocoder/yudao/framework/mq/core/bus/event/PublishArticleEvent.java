package cn.iocoder.yudao.framework.mq.core.bus.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * 公众号发布文章事件
 */
public class PublishArticleEvent extends RemoteApplicationEvent {

    private String name;

    /**
     *
     * @param source
     * @param originService 事件的来源
     * @param destinationService 事件的目的服务 (可以使用通配符的形式{serviceId}:{appContextId}，两个变量都省略的话，则通知到所有服务的所有实例。只省略appContextId时，则对应的destinationService为相应serviceId的所有实例。)
     */
    public PublishArticleEvent(String name,Object source, String originService, String destinationService) {
        super(source, originService, DEFAULT_DESTINATION_FACTORY.getDestination(destinationService));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
