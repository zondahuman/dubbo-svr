package com.abin.lee.origin.service.team.filter;

import com.alibaba.dubbo.rpc.*;
import org.slf4j.MDC;

/**
 *
 */
public class RpcTraceSkeletonFilter implements Filter {

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = RpcContext.getContext().getAttachment("traceId");
        MDC.put("TRACE_ID", traceId);
        System.out.println("RpcTraceSkeletonFilter---traceId=" + traceId);
        return invoker.invoke(invocation);
    }


}
