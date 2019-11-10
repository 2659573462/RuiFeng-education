package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.vo.User;

/**
 * 登录验证
 *
 * @author chenjin
 * @date 2019/11/6 19:38
 */
public interface LoginService {
    /**
     * 账号密码查用户
     * @param user
     * @return
     */
    UserTable selectUser(User user);

}
