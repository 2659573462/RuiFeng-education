package com.rimi.ruiFeng.util;

import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.mapper.UserTableMapper;

/**
 * 验证用户
 *
 * @author chenjin
 * @date 2019/11/12 15:47
 */
public class VerificationLogin {

    private  UserTableMapper userTableMapper;

    public VerificationLogin(UserTableMapper userTableMapper){
        this.userTableMapper=userTableMapper;
    }

    /**
     * 校验用户的验证是否能用
     * @param statusode 验证的字符串   :用户加密  + 动态嘛
     * @return
     */
    public  Boolean getVerifcation(String statusode){
        String[] strings = UtilString.InterceptString(statusode);
        UserTable userTables =userTableMapper.selectUserAndCorrection(strings[0],statusode);
        if(userTables!=null){
            return true;
        }
        return false;
    }
}
