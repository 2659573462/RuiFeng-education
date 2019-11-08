package com.rimi.ruiFeng.bean;

import lombok.Data;

/**
 *${Description}
 *@author chenjin
 *@date 2019/11/7 16:22
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


}