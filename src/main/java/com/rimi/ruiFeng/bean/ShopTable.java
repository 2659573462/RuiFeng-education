package com.rimi.ruiFeng.bean;

import lombok.Data;

/**
 *${Description}
 *@author chenjin
 *@date 2019/11/5 14:17
 */
@Data
public class ShopTable {
    /**
    * 购物车id
    */
    private Integer shopId;

    /**
    * 用户账号
    */
    private String shopAccountnumber;

    /**
    * 加入的购物车的内容
    */
    private String shopcartOrderid;
}