package com.dahuamiao.provider.mq.conosumer;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: WangJun
 * @Description:
 * @Date: Created in 8:58 2019/8/15
 * @Modifyied By:
 */
@Component
@RocketMQMessageListener(topic = "testTopicOne",
        consumerGroup = "group",
        selectorExpression = "group",
        selectorType = SelectorType.TAG,
        consumeMode = ConsumeMode.CONCURRENTLY,
        messageModel = MessageModel.CLUSTERING,
        consumeThreadMax = 64,
        consumeTimeout = 30)
public class GroupConsumer implements RocketMQListener<String> {

    Logger log = LoggerFactory.getLogger(GroupConsumer.class);


    @Override
    public void onMessage(String message) {

        log.info("consume msg :{}", message);
    }

}
