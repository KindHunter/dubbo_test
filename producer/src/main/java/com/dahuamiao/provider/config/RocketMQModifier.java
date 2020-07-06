package com.dahuamiao.provider.config;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.rocketmq.client.hook.ConsumeMessageContext;
import org.apache.rocketmq.client.hook.ConsumeMessageHook;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.support.DefaultRocketMQListenerContainer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @program: dubbo_test
 * @description:
 * @author: wangJun
 * @create: 2020-07-02 17:53
 **/
@Component
public class RocketMQModifier implements ApplicationListener<ContextRefreshedEvent> {



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        Map<String, DefaultRocketMQListenerContainer> rocketMqListenerContainers = applicationContext.getBeansOfType(DefaultRocketMQListenerContainer.class);
        if (MapUtils.isNotEmpty(rocketMqListenerContainers)){
            rocketMqListenerContainers.forEach((key, container) -> {
                container.getConsumer()
                        .getDefaultMQPushConsumerImpl()
                        .registerConsumeMessageHook(new ConsumeMessageHook() {
                            @Override
                            public String hookName() {
                                return "name1";
                            }

                            @Override
                            public void consumeMessageBefore(ConsumeMessageContext context) {
                                List<MessageExt> msgList = context.getMsgList();

                                if (CollectionUtils.isNotEmpty(msgList)){
                                    for (MessageExt messageExt : msgList) {
                                        System.out.println("consumeMessageBefore:" + messageExt.getProperty("myKey"));
                                    }
                                }
                            }

                            @Override
                            public void consumeMessageAfter(ConsumeMessageContext context) {
                                List<MessageExt> msgList = context.getMsgList();

                                if (CollectionUtils.isNotEmpty(msgList)){
                                    for (MessageExt messageExt : msgList) {
                                        System.out.println("consumeMessageAfter:" + messageExt.getProperty("myKey"));
                                    }
                                }
                            }
                        });

            });
        }
    }
}
