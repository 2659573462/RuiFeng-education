package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.bean.UserTable;
    /**
 *${Description}
 *@author chenjin
 *@date 2019/11/6 20:17
 */
public interface UserTableService{


    int deleteByPrimaryKey(Integer userId);

    int insert(UserTable record);

    int insertSelective(UserTable record);

    UserTable selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserTable record);

    int updateByPrimaryKey(UserTable record);

     UserTable selectUser(String username, String password);

     UserTable selectUsername(String username);

        UserTable selectMobile(String mobile);
    }
