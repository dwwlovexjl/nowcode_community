package com.bokchoy.nowcode_community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author bokchoy
 * @description: 自定义工具类
 * @date 2021年10月26日 10:48
 */
public class CommunityUtil {

    //生成随机字符串
    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    //MD5加密密码
    //MD5加密生成的串是固定的而且不可以反向解密
    //hello->12234sad ;太过简单可能被破解
    //hello+sa4321->21321dwfe3  ;即利用密码加上一个随机字符串生成密码
    public static String md5(String key){
        if (StringUtils.isBlank(key)) {
            return null;
        }else {
            return DigestUtils.md5DigestAsHex(key.getBytes());
        }
    }
}
