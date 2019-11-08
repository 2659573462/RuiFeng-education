package com.rimi.ruiFeng.mapper;

import com.rimi.ruiFeng.bean.UserTable;
import org.apache.ibatis.annotations.Param;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/6 20:17
 */
public interface UserTableMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserTable record);

    int insertSelective(UserTable record);

    UserTable selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserTable record);

    int updateByPrimaryKey(UserTable record);

    UserTable selectUser(@Param(value ="username") String username,@Param(value = "password") String password);

    UserTable selectUsername(String username);

    UserTable selectMobile(String mobile);
}