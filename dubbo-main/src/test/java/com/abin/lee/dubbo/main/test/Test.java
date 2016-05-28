package com.abin.lee.dubbo.main.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: tinkpad
 * Date: 15-11-6
 * Time: 下午11:29
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int numberOfProcessors = runtime.availableProcessors();
        System.out.println(numberOfProcessors + " processor available to JVM");
        Set set = new HashSet();
    }
}
