package com.rimi.ruiFeng.vo;

import lombok.Data;

/**
 * 登录获取参数需要传入的对象
 *
 * @author chenjin
 * @date 2019/11/11 10:49
 */
@Data
public class LoginDataVo {
    /**
     * 验证身份的动态参数
     */
    private String verification;
    /**
     * 需要获取的类型
     */
    private String courseintroductionType;
}
