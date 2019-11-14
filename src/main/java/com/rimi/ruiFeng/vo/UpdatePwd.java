package com.rimi.ruiFeng.vo;

import lombok.Data;

/**
 * 修改密码对象
 *
 * @author chenjin
 * @date 2019/11/13 15:30
 */
@Data
public class UpdatePwd {
    /**
     * 验证身份的动态参数
     */
    private String verification;

    /**
     * 原始密码
     */
    private String oldPassword;


    /**
     * 新密码
     *
     */
    private String newPassword;
}
