package com.rimi.ruiFeng.service.impl;

import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.mapper.CommentTableMapper;
import com.rimi.ruiFeng.mapper.UserTableMapper;
import com.rimi.ruiFeng.service.LoginService;
import com.rimi.ruiFeng.service.UserTableService;
import com.rimi.ruiFeng.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenjin
 * @date 2019/11/6 20:12
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserTableService userTableService;

    /**
     * 传入一个前端用户对象返回一个数据库实体用户对象
     * @param user
     * @return
     */
    @Override
    public UserTable selectUser(User user) {
        UserTable u = userTableService.selectUser(user.getUsername(),user.getPassword());
        return u;
    }


}
