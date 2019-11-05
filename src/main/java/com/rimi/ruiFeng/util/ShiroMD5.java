package com.rimi.ruiFeng.util;

import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.Arrays;
import java.util.UUID;

/**
 * @author shangzf
 * @date 2019/11/1 16:38
 */
public class ShiroMD5 {

    private static final int COUNTER = 1024;
    private static final String HASH_ALGORITHM_NAME = "SHA-512";

    /**
     * 加密
     *
     * @param password 密码
     * @return 盐和密码
     */
    public static String[] getPwd(String password) {
        // 生成盐
        String salt = UUID.randomUUID().toString();
        String pwd = getPwd(password, salt, COUNTER);

        return new String[]{salt, pwd};
    }

    public static String getPwd(String password, String salt, int count) {
        return new SimpleHash(HASH_ALGORITHM_NAME, password, salt, count).toHex();
    }

    public static void main(String[] args) {
        String[] pwd = getPwd("123");
        System.out.println(Arrays.toString(pwd));
        //144e24ed-9708-4a4d-a256-7d927b5dcc19
        System.out.println(pwd[1].length());
    }
}
