package com.rimi.ruiFeng.bean;

import lombok.Data;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/11 9:21
 */
@Data
public class MessageTable {
    /**
     * 验证码id
     */
    private Integer messageId;

    /**
     * 验证码手机号
     */
    private String messageMobile;

    /**
     * 验证码码
     */
    private String messageVerifcationcode;

    /**
     * 存入时间
     */
    private String messageTime;
}