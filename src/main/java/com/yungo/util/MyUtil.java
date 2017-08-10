package com.yungo.util;

import groovy.transform.ASTTest;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cx on 17-8-4.
 */
public class MyUtil {


    public static Map getCount(String[] strs){

       Map map = new HashMap();
       int count = 0;
       for(int i=1;i<strs.length;i++){
            count = (int) map.get(strs[i]);
           if(map.containsKey(strs[i])) {
               map.put(strs[i], count++);
           }
       }
    return map;
    }

    public static String md5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }


}
