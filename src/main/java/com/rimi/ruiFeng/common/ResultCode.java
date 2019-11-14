package com.rimi.ruiFeng.common;

/**
 * 返回结果码
 *
 * @author shangzf
 * @date 2019/10/31 14:26
 */
public enum ResultCode {
    /**
     * 叙述
     */
    DESCRIPTION(000,"叙述"),
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 失败
     */
    FAIL(201, "失败"),
    /**
     * 账号已经存在
     */
    ALREADYEXIST(202,"账号已经存在"),
    /**
     * 账号不存在
     */
    INEXISTENCE(203,"账号不存在"),
    /**
     *发送失败
     */
    SUCCESSCDEFEATED(204,"发送失败"),
    /**
     * 短消息发送成功
     */
    SUCCESSC(205,"发送成功"),
    /**
     *账号注册成功
     */
    ACCOUNTNUMBERSUCCEED(207,"账号注册成功"),
    /**
     *账号注册失败
     */
    ACCOUNTNUMBERDEFEATED(208,"账号注册失败"),
    /**
     * 登录成功
     */
    LOGIN_SUCCEED(210,"登录成功"),
    /**
     * 登录失败
     */
    LOGIN_DEFEATED(212,"登录失败"),
    /**
     * 以加入购物车
     */
    HAVE_ALREADY_PURCHASED(220,"宝贝已存在,请去购物车结算"),
    /**
     * 商品不存在
     */
    PRODUCT_DOES_NOT_EXIST(225,"商品不存在"),
    /**
     * 已购买
     */
    BOUGHT(230,"已经购买"),
    /**
     * 方法未找到
     */
    NOT_FOUND_METHOD(404, "方法未找到"),
    /**
     * 方法请求方式不支持
     */
    NOT_SUPPORT_METHOD(403, "方法请求方式不支持"),
    /**
     * 当前方法位为注册验证
     */
    NOT_SUPPORT_REGISTER(406, "当前方法位为注册验证"),
    /**
     * 当前方法位为登录验证
     */
    NOT_SUPPORT_LOGIN(408, "当前方法位为登录验证"),
    /**
     * 还没有加入购物车
     */
    NOT_NOSOPPING(410,"还没有购买商品"),
    /**
     * 购物车空空如也
     */
    NOT_NOSOPPINGS(415,"购物车空空如也"),
    /**
     * 服务器异常
     */
    ERROR(500, "服务器异常"),
    /**
     *缺少数据
     */
    ERROR_PARAMETER(505, "缺少数据类型"),
    /**
     * 验证码不正确
     */
    ERROR_VERIFICATION_CODE_INCORRECT(510,"验证码不正确"),
    /**
     * 验证码过期
     */
    ERROR_VERIFICATION_PAST_DUE(515,"验证码过期"),
    /**
     * 状态码已过期
     */
    ERROR_VERIFICATION_Expired(520,"状态码已过期"),
    /**
     * 服务器繁忙
     */
    ERROR_BUSY_SERVER(525,"服务器繁忙")
    ;

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
