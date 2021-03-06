package com.rimi.ruiFeng.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.annotations.Param;

/**
 * 前端传输用户登录信息
 *
 * @author chenjin
 * @date 2019/11/6 14:41
 */
@Data
public class User {
    /**
     * 账号
     */
    public String username;
    /**
     * 密码
     */
    public String password;
}
