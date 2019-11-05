package com.rimi.ruiFeng.util;

import org.apache.shiro.crypto.hash.SimpleHash;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 获取订单
 *
 * @author chenjin
 * @date 2019/11/5 21:22
 */
public class AcquireOrderForm {
    //加密次数
    private static final int COUNTER = 1024;
    //截取长度
    private static final int COUNTER_NUMBER=20;
    //加密方式
    private static final String HASH_ALGORITHM_NAME = "SHA-512";
    /**
     * 生成订单
     * (截取当前的时间戳然后截取前128位加密)
     * @return
     */
    public  String getOrderForm(){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String hehe = dateFormat.format(date);
        String[] pwd = getPwd(hehe);
        String s = pwd[1];
        String substring = null;
        if(s.length()>COUNTER_NUMBER){
            substring = s.substring(0, COUNTER_NUMBER);
        }else{
            substring = s.substring(0, s.length()-1);
        }
        return substring;
    }

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
        String orderForm =new AcquireOrderForm().getOrderForm();
        System.out.println(orderForm);
        System.out.println(orderForm.length());
    }
}
