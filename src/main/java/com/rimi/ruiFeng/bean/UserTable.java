package com.rimi.ruiFeng.bean;

import lombok.Data;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/11 14:44
 */
@Data
public class UserTable {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 账号
     */
    private String userUsername;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 账号头像地址
     */
    private String userHeadportrait;

    /**
     * 昵称:展示在页面的
     */
    private String userAlias;

    /**
     * 手机号
     */
    private String userTellphonenumber;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 购物车
     */
    private String userShopcart;

    /**
     * 用户购买视频:套装的商品 如 JAVASE精讲103131515
     */
    private String userByvideo;

    /**
     * 用户心愿单视频:套装的商品 如 JAVASE精讲103131515
     */
    private String userWish;

    /**
     * 用户观看历史记录:存储视频id
     */
    private String userHistory;

    /**
     * 学习方向
     */
    private String userInter;

    /**
     * 用户唯一标识
     */
    private String userOpenid;

    /**
     * 动态拼接的动态码和时间
     */
    private String userCorrection;
}