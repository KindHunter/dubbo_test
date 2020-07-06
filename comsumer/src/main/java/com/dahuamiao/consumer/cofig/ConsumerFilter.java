package com.dahuamiao.consumer.cofig;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * @program: blackbird
 * @description: 上下文传递过滤器
 * @author: wangJun
 * @create: 2019-10-12 17:16
 **/
@Activate(group = "consumer")
public class ConsumerFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result = invoker.invoke(invocation);
        return result;
    }
}
