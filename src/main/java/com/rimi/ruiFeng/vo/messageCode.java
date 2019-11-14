package com.rimi.ruiFeng.vo;

import lombok.Data;

/**
 * 前端验证
 *
 * @author chenjin
 * @date 2019/11/7 16:15
 */
@Data
public class messageCode{
    /**
     * id
     */
    public int id ;
    /**
     * 手机号
     */
    public String mobile;
    /**
     * 验证码
     */
    public String verificationCode;
    /**
     * 声明当前验证的是什么
     */
    public String state;
    /**
     * 验证身份的动态参数
     */
    private String verification;
}
