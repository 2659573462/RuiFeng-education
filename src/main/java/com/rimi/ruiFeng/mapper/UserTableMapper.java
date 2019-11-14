package com.rimi.ruiFeng.mapper;

import com.rimi.ruiFeng.bean.UserTable;import org.apache.ibatis.annotations.Param;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/11 14:44
 */
public interface UserTableMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserTable record);

    int insertSelective(UserTable record);

    UserTable selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserTable record);

    int updateByPrimaryKey(UserTable record);

    UserTable selectUser(@Param(value = "username") String username, @Param(value = "password") String password);

    UserTable selectUsername(String username);

    UserTable selectMobile(String mobile);

    UserTable selectCorrection(String statusode);

    int updateByCorrection(@Param("user") String user,@Param("correction") String correction);

    UserTable selectUserAndCorrection(@Param("user") String s,@Param("correction") String s1);


    int updateHead(@Param("user") String s,@Param("fileName") String fileName);

    int updateAlias(@Param("userName") String userName,@Param("type") String type);

    int updateUserPassword(@Param("user")String user,@Param("pwd") String newPassword);

    UserTable selectUserAndPwd(@Param("user")String userNumber,@Param("oldPassword")String oldPassword);

    int updateEmail(@Param("user") String userNumber,@Param("email") String email);


    int updatePhoneVerification(@Param("user") String user,@Param("mobile") String mobile);

    UserTable selectOpenid(String openid);

    int updateByVideo(@Param("user") String userUsername, @Param("video") String s);
}