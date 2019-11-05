package com.rimi.ruiFeng.bean;

import lombok.Data;

/**
 *${Description}
 *@author chenjin
 *@date 2019/11/5 14:16
 */
@Data
public class OrdeTable {
    /**
    * 订单id
    */
    private Integer ordeId;

    /**
    * 下单的用户
    */
    private Integer ordeAccountnumber;

    /**
    * 商品视频编号
    */
    private String ordeVideoid;

    /**
    * 订单编号
    */
    private String ordeNumber;

    /**
    * 订单订单生成时间
    */
    private String ordeTime;

    /**
    * 订单状态
    */
    private String ordeStatus;
}