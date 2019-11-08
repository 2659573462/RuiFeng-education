package com.rimi.ruiFeng.common;

/**
 * 返回结果码
 *
 * @author shangzf
 * @date 2019/10/31 14:26
 */
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     *发送失败
     */
    SUCCESSCDEFEATED(204,"发送失败"),
    /**
     * 短消息发送成功
     */
    SUCCESSC(205,"发送成功"),
    /**
     * 账号已经存在
     */
    ALREADYEXIST(206,"账号已经存在"),
    /**
     *账号注册成功
     */
    ACCOUNTNUMBERSUCCEED(207,"账号注册成功"),
    /**
     *账号注册失败
     */
    ACCOUNTNUMBERDEFEATED(208,"账号注册失败"),
    /**
     * 失败
     */
    FAIL(201, "失败"),

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
    ERROR_VERIFICATION_CODE_INCORRECT(510,"验证码不正确");

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
