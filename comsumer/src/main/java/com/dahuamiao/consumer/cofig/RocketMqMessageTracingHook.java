package com.dahuamiao.consumer.cofig;

import brave.Span;
import brave.propagation.ThreadLocalSpan;
import org.apache.rocketmq.client.hook.SendMessageContext;
import org.apache.rocketmq.client.hook.SendMessageHook;

import static brave.Span.Kind.CLIENT;

/**
 * @program: dubbo_test
 * @description:
 * @author: wangJun
 * @create: 2020-07-03 15:05
 **/
public class RocketMqMessageTracingHook implements SendMessageHook {

    @Override
    public String hookName() {
        return "openTracingHook";
    }

    @Override
    public void sendMessageBefore(SendMessageContext context) {

        doBeforeSend(context);
    }

    private void doBeforeSend(SendMessageContext context) {
        // Gets the next span (and places it in scope) so code between here and postProcess can read it
        Span span = ThreadLocalSpan.CURRENT_TRACER.next();
        if (span == null || span.isNoop()) return ;
//        span.kind(CLIENT).name(spaceIndex == -1 ? sql : sql.substring(0, spaceIndex));
//        span.tag("sql.query", sql);
    }

    @Override
    public void sendMessageAfter(SendMessageContext context) {

    }
}
