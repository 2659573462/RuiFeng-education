package com.rimi.ruiFeng.util;

/**
 * 处理字符串
 *
 * @author chenjin
 * @date 2019/11/11 21:33
 */
public class UtilString {
    /**
     * 通过','切分字符串
     * @param strings
     * @return
     */
    public static String[] InterceptString(String strings){
        String[] heZi= strings.split(",");
        return heZi;
    }


}
