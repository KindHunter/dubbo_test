package com.dahuamiao.provider.config;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @program: blackbird
 * @description: 上下文传递过滤器
 * @author: wangJun
 * @create: 2019-10-12 15:57
 **/
@Activate(group = "provider")
public class ProviderFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ProviderFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        Result result;
        try {
            result = invoker.invoke(invocation);

        } finally {
            //清除mdc中的内容
            MDC.clear();
        }

        return result;
    }
}
