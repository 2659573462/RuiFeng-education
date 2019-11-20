package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.common.Result;
import com.rimi.ruiFeng.common.ResultData;
import com.rimi.ruiFeng.vo.LoginDataVo;
import com.rimi.ruiFeng.vo.UpdateUserHeadVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 修改个人信息
 *
 * @author chenjin
 * @date 2019/11/13 11:01
 */
@Service
public interface UpdatePersonalDetails {
    /**
     * 修改头像
     */
    ResultData updateUserPassword(UpdateUserHeadVo updateHead, HttpServletRequest request);

    /**
     * 修改用户昵称
     * @param type
     * @return
     */
    int updateAlias(String userName,String type);

    /**
     * 修改密码
     */
    int updateUserPassword(String userName,String newPassword);

    /**
     * 修改邮箱
     */
    int updateUserEmail(LoginDataVo updateEmail);

}

