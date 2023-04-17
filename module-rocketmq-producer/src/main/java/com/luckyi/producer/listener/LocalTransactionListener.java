package com.luckyi.producer.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

@Slf4j
public class LocalTransactionListener implements TransactionListener {

    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object arg) {
        //获得业务参数中的数据
        String destination = (String) arg;
        // //使⽤RocketMQUtil将spring的message转换成rocketmq的message
        // org.apache.rocketmq.common.message.Message message =
        //         RocketMQUtil.convertToRocketMessage(new ObjectMapper(),"utf-8",destination,msg);
        //获得消息中的业务数据tags
        String tags = message.getTags();
        if(StringUtils.contains(tags,"TagA")){
            //提交本地事务
            log.info("{} ==> 提交本地事务",destination);
            return LocalTransactionState.COMMIT_MESSAGE;
        }else if(StringUtils.contains(tags,"TagB")){
            //回滚
            log.info("{} ==> 本地事务回滚",destination);
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }else{
            //中间状态
            log.info("{} ==> 本地事务未完成，等待回查",destination);
            return LocalTransactionState.UNKNOW;
        }
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        return null;
    }
}
