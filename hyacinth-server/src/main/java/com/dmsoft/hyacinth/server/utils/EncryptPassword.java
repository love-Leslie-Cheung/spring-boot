package com.dmsoft.hyacinth.server.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class EncryptPassword {

    public static String encryptPassword(Object password, Object salt) {
        String alname = "MD5";
        int times = 1024;
        Object result = new SimpleHash(alname, password, ByteSource.Util.bytes(salt), times).toHex();
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(encryptPassword("123456qq", "admin"));
    }
}
