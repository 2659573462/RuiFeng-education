package com.rimi.ruiFeng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.mapper.UserTableMapper;
import com.rimi.ruiFeng.service.UserTableService;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/6 20:17
 */
@Service
public class UserTableServiceImpl implements UserTableService {

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
        return userTableMapper.selectUser(username, password);
    }

    @Override
    public UserTable selectUsername(String username) {
        return userTableMapper.selectUsername(username);
    }

    @Override
    public UserTable selectMobile(String mobile) {
        return userTableMapper.selectMobile(mobile);
    }

    @Override
    public UserTable selectCorrection(String statusode) {
        return userTableMapper.selectCorrection(statusode);
    }

    @Override
    public int updateByCorrection(String user,String correction) {
        return userTableMapper.updateByCorrection(user,correction);
    }

    @Override
    public UserTable selectUserAndCorrection(String s, String s1) {
        return userTableMapper.selectUserAndCorrection(s,s1);
    }

    @Override
    public UserTable selectUserAndPwd(String userNumber, String oldPassword) {
        return userTableMapper.selectUserAndPwd(userNumber,oldPassword);
    }

    @Override
    public int updatePhoneVerification(String string, String mobile) {
        return userTableMapper.updatePhoneVerification(string,mobile);
    }

    @Override
    public UserTable selectOpenid(String openid) {
        return userTableMapper.selectOpenid(openid);
    }

    @Override
    public int updateByVideo(String userUsername, String s) {
        return userTableMapper.updateByVideo(userUsername,s);
    }


}

