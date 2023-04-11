package com.iocoder.producer.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQUtil;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.StringMessageConverter;

@RocketMQTransactionListener
@Slf4j
public class LocalTransactionListener implements RocketMQLocalTransactionListener {
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        //获得业务参数中的数据
        String destination = (String) arg;
        //使⽤RocketMQUtil将spring的message转换成rocketmq的message
        org.apache.rocketmq.common.message.Message message =
                RocketMQUtil.convertToRocketMessage(new StringMessageConverter(),"utf-8",destination,msg);
        //获得消息中的业务数据tags
        String tags = message.getTags();
        if(StringUtils.contains(tags,"TagA")){
            //提交本地事务
            log.info("{} ==> 提交本地事务",destination);
            return RocketMQLocalTransactionState.COMMIT;
        }else if(StringUtils.contains(tags,"TagB")){
            //回滚
            log.info("{} ==> 本地事务回滚",destination);
            return RocketMQLocalTransactionState.ROLLBACK;
        }else{
            //中间状态
            log.info("{} ==> 本地事务未完成，等待回查",destination);
            return RocketMQLocalTransactionState.UNKNOWN;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        return null;
    }
}
