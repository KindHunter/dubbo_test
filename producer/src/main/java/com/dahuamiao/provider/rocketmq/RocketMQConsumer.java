package com.dahuamiao.provider.rocketmq;

import com.dahuamiao.api.Constants;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @program: dubbo_test
 * @description:
 * @author: wangJun
 * @create: 2020-10-30 17:36
 **/
@Component
@RocketMQMessageListener(
        topic = Constants.TOPIC,
        consumerGroup = "dubbo-producer",
        selectorExpression = Constants.TAG,
        selectorType = SelectorType.TAG,
        consumeMode = ConsumeMode.CONCURRENTLY,
        messageModel = MessageModel.CLUSTERING,
        consumeThreadMax = 64,
        consumeTimeout = 30
)
public class RocketMQConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println(message);
    }
}
