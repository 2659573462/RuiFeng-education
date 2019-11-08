package com.rimi.ruiFeng.service.impl;

import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.service.RegisterService;
import com.rimi.ruiFeng.service.UserTableService;
import com.rimi.ruiFeng.util.PwdUtils;
import com.rimi.ruiFeng.vo.RegistUserVo;
import com.rimi.ruiFeng.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenjin
 * @date 2019/11/7 22:25
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Resource
    private UserTableService userTableService;

    /**
     * 插入用户
     * @param registUserVo
     * @return
     */
    @Override
    public int insertUser(RegistUserVo registUserVo) {
        UserTable userTable = new UserTable();
        userTable.setUserUsername(PwdUtils.getPwd(registUserVo.getUsername()));
        //加密密码
        userTable.setUserPassword(PwdUtils.getPwd(registUserVo.getPassword()));
        userTable.setUserTellphonenumber(registUserVo.getTelephoneNumber());
        int i = userTableService.insertSelective(userTable);
        return i;
    }


}
