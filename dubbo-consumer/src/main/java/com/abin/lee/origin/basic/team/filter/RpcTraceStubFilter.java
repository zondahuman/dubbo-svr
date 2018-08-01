package com.abin.lee.origin.basic.team.filter;

import com.alibaba.dubbo.rpc.*;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * Created by WANGJINZHAO on 2017/3/29.
 */
public class RpcTraceStubFilter implements Filter {

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = RpcContext.getContext().getAttachment("traceId");
        if(StringUtils.isNotBlank(traceId)){
            System.out.println("accept traceId=" + traceId);
        }else{
            traceId = UUID.randomUUID().toString();
            System.out.println("create traceId=" + traceId);
        }
        RpcContext.getContext().setAttachment("traceId", traceId);
        System.out.println("RpcLogSessionFilter---traceId=" + traceId);
        return invoker.invoke(invocation);
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }


}
