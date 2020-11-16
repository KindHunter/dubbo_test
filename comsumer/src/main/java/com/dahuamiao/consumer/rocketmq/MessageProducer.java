package com.dahuamiao.consumer.rocketmq;

import com.google.gson.Gson;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


    /**
     * 发送消息（异步发送，mq服务器收到消息并响应，就可执行下一步）
     * <p>
     * 可靠异步发送
     *
     * @param topic
     * @param data
     */
    public void sendAsyncMsg(String topic, String tag, Object data) {
        log.info("MessageProducer.sendAsyncMsg，topic:{},tag:{},data:{}", topic, tag, new Gson().toJson(data));
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
        log.info("MessageProducer.sendSyncMsg，topic:{},tag:{},data:{}", topic, tag, new Gson().toJson(data));
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
        log.info("MessageProducer.sendOneWayMsg，topic:{},tag:{},data:{}", topic, tag, new Gson().toJson(data));
        this.rocketMQTemplate.sendOneWay(topic + ":" + tag, data);
    }


    /**
     * 发送消息, 保证都发送到一个队列中，保证发送顺序
     */
    public void asyncSendOrderly(String topic, String tag, Object data, String hashKey) {
        log.info("MessageProducer.asyncSendOrderly，topic:{},tag:{},data:{},hashKey:{}", topic, tag,
                new Gson().toJson(data), hashKey);
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
