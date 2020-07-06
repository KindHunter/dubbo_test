package com.dahuamiao.consumer.mq.producer;

import brave.Span;
import brave.propagation.ThreadLocalSpan;
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.hook.SendMessageContext;
import org.apache.rocketmq.client.hook.SendMessageHook;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static brave.Span.Kind.CLIENT;

/**
 * @Author: WangJun
 * @Description:
 * @Date: Created in 14:47 2019/8/15
 * @Modifyied By:
 */
@Component
public class MessageProducer {

    Logger log = LoggerFactory.getLogger(MessageProducer.class);

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    @PostConstruct
    public void setSendHook(){
        rocketMQTemplate.getProducer().getDefaultMQProducerImpl().registerSendMessageHook(new SendMessageHook() {


            @Override
            public String hookName() {
                return "beforeSendHooker";
            }

            @Override
            public void sendMessageBefore(SendMessageContext context) {
                Message message = context.getMessage();
                Map<String, String> properties = message.getProperties();
                properties.put("myKey", "myValue");
                properties.put("sendBeforeTime", String.valueOf(new Date().getTime()));
                System.out.println("coming in sendHook! before");
            }

            @Override
            public void sendMessageAfter(SendMessageContext context) {
                Message message = context.getMessage();
                Map<String, String> properties = message.getProperties();
                properties.put("sendBeforeAfter", String.valueOf(new Date().getTime()));
                System.out.println("coming in sendHook! after");

            }
        });
    }


    /**
     * 发送消息（异步发送，mq服务器收到消息并响应，就可执行下一步）
     * <p>
     * 可靠异步发送
     *
     * @param topic
     * @param data
     */
    public void sendAsyncMsg(String topic, String tag, Object data) {
        log.info("MessageProducer.sendAsyncMsg，topic:{},tag:{},data:{}", topic, tag, JSON.toJSONString(data));
        this.rocketMQTemplate.asyncSend(topic + ":" + tag, data, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("MessageProducer.sendAsyncMsg发送消息成功，msgId：【{}】", sendResult.getMsgId());
            }

            @Override
            public void onException(Throwable e) {
                e.printStackTrace();
                log.error("MessageProducer.sendAsyncMsg发送消息异常：【{}】", e.getMessage());
            }
        });
    }


    /**
     * 发送事务消息（本地事务执行成功才会真正发送消息）
     * @param topic
     * @param data
     */
//    public void sendTransactionMsg(String topic,String tag, Object data){
//        Message message = MessageBuilder.withPayload(data).build();
//        // myTransactionGroup要和@RocketMQTransactionListener(txProducerGroup = "myTransactionGroup")定义的一致
//        TransactionSendResult result = this.rocketMQTemplate.sendMessageInTransaction(Constants.PRODUCER_GROUP_A,
//                topic + ":" + tag,
//                message,
//                data);
//        System.out.println("sendTransactionMsg send success!");
//    }


    /**
     * 发送同步消息(只要消息被broker端接收成功，才会继续下一步，不能保证被消费成功)
     * <p>
     * 可靠同步发送
     */
    public boolean sendSyncMsg(String topic, String tag, Object data) {
        log.info("MessageProducer.sendSyncMsg，topic:{},tag:{},data:{}", topic, tag, JSON.toJSONString(data));
        SendResult result = this.rocketMQTemplate.syncSend(topic + ":" + tag, data);
        if (result.getSendStatus() == SendStatus.SEND_OK) {
            log.info("MessageProducer.sendSyncMsg发送消息成功，msgId：【{}】", result.getMsgId());
            return true;
        } else {
            log.info("MessageProducer.sendSyncMsg发送消息失败，msgId：【{}】，", result.getMsgId());
            return false;
        }
    }


    /**
     * 发送消息，之后不管mq服务器是否接受到消息
     * <p>
     * 单向发送
     */
    public void sendOneWayMsg(String topic, String tag, Object data) {
        log.info("MessageProducer.sendOneWayMsg，topic:{},tag:{},data:{}", topic, tag, JSON.toJSONString(data));
        this.rocketMQTemplate.sendOneWay(topic + ":" + tag, data);
    }


    /**
     * 发送消息, 保证都发送到一个队列中，保证发送顺序
     */
    public void asyncSendOrderly(String topic, String tag, Object data, String hashKey) {
        log.info("MessageProducer.asyncSendOrderly，topic:{},tag:{},data:{},hashKey:{}", topic, tag,
                JSON.toJSONString(data), hashKey);
        this.rocketMQTemplate.asyncSendOrderly(topic + ":" + tag, data, hashKey, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("MessageProducer.asyncSendOrderly发送消息成功，msgId：【{}】", sendResult.getMsgId());
            }

            @Override
            public void onException(Throwable e) {
                e.printStackTrace();
                log.error("MessageProducer.asyncSendOrderly发送消息异常：【{}】", e.getMessage());
            }
        });
    }


}
