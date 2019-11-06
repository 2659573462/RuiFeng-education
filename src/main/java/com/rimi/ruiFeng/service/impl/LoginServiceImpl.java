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
    private UserTableMapper userTableMapper;

    @Override
    public UserTable selectUser(User user) {
        UserTable u =  userTableMapper.selectUser(user.getUsername(),user.getPassword());
        return u;
    }


}
