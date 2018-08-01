package com.abin.lee.origin.service.team.impl;

import com.abin.lee.origin.service.team.TeamService;
import com.alibaba.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-16 上午1:14
 */
@Service(value = "teamService")
public class TeamServiceImpl implements TeamService {
    private static final Logger logger = LoggerFactory.getLogger(TeamServiceImpl.class);

    @Override
    public String get(String param) {
        String traceId = RpcContext.getContext().getAttachment("traceId");
        logger.info("TeamServiceImpl-----------traceId: " + traceId );
        logger.info(" got a argument param : " + param );

        return "hello " + param;
    }
}
