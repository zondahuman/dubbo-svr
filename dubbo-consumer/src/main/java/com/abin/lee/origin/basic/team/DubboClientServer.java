package com.abin.lee.origin.basic.team;

import com.abin.lee.origin.service.team.TeamService;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abin on 2017/9/7 2017/9/7.
 * march-svr
 * com.abin.lee.march.svr.dubbo.client.view
 */
public class DubboClientServer {


    public static void main(String[] args) throws InterruptedException {
        //traceId
        main_filter();
    }


    public static void main_filter() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath*:spring/dubbo-reference.xml"});
        context.start();
        TeamService teamService = (TeamService) context.getBean("teamService"); // 获取bean
        String message = "";

        try {
            Map<String, String> param = new HashMap<>();
            int traceId = (int) (Math.random() * 1000);
            param.put("traceId", traceId + "");
            RpcContext.getContext().setAttachments(param);
            message = teamService.get("2016-10-20");
            System.out.println(" the message from server is:" + message);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
