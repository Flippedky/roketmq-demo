package cn.iocoder.yudao.framework.mq.core.bus.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * 用户注册事件
 */
public class UserRegisterEvent extends RemoteApplicationEvent {

    public String userName;

    public UserRegisterEvent(String userName,Object source, String originService, String destinationService) {
        super(source, originService, DEFAULT_DESTINATION_FACTORY.getDestination(destinationService));
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
