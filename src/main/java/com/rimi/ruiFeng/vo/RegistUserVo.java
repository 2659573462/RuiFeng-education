package com.rimi.ruiFeng.vo;

import lombok.Data;

/**
 * 注册的对象传入
 *
 * @author chenjin
 * @date 2019/11/7 22:20
 */
@Data
public class RegistUserVo {
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String telephoneNumber;
    /**
     * 验证码
     */
    private String authCode;

}
