package com.fei.adsponsor.util;

import org.apache.commons.codec.digest.DigestUtils;

public class DigestUtil {

    public static String generateUserToken(String key){
        String token = DigestUtils.md5Hex(key+"1)sdf%") ;
        return token ; 
    }

}
