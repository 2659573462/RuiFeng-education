package com.rimi.ruiFeng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.mapper.UserTableMapper;
import com.rimi.ruiFeng.service.UserTableService;
/**
 *${Description}
 *@author chenjin
 *@date 2019/11/6 20:17
 */
@Service
public class UserTableServiceImpl implements UserTableService{

    @Resource
    private UserTableMapper userTableMapper;

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return userTableMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(UserTable record) {
        return userTableMapper.insert(record);
    }

    @Override
    public int insertSelective(UserTable record) {
        return userTableMapper.insertSelective(record);
    }

    @Override
    public UserTable selectByPrimaryKey(Integer userId) {
        return userTableMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(UserTable record) {
        return userTableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserTable record) {
        return userTableMapper.updateByPrimaryKey(record);
    }

    @Override
    public UserTable selectUser(String username, String password) {
        return userTableMapper.selectUser(username,password);
    }

    @Override
    public UserTable selectUsername(String username) {
        return userTableMapper.selectUsername(username);
    }

    @Override
    public UserTable selectMobile(String mobile) {
        return userTableMapper.selectMobile(mobile);
    }

}
