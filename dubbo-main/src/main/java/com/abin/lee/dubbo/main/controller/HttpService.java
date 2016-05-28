package com.abin.lee.dubbo.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: tinkpad
 * Date: 16-4-22
 * Time: 下午10:09
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/http")
public class HttpService {


    @ResponseBody
    @RequestMapping(value = "/list")
    public String list(String keyword) throws Exception {
       return "abin"+keyword;
    }



}
