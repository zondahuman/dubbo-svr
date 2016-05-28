package com.abin.lee.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: tinkpad
 * Date: 15-11-1
 * Time: 下午6:43
 * To change this template use File | Settings | File Templates.
 */
public class AtrattributeTest {
    public static void main(String[] args) {
        String s ="pP_001";
//        String regEx = "^([P_]{2})+"; //表示a或F
//        String regEx = "^[P_]{2}+"; //表示a或F
        String regEx = "^([P_]|[p_]){2}+"; //表示a或F
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(s);
        boolean rs = mat.find();
        System.out.println(rs);
    }

}
