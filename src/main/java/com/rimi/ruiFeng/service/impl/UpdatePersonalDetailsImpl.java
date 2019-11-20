package com.rimi.ruiFeng.service.impl;

import com.rimi.ruiFeng.common.DefaultResultData;
import com.rimi.ruiFeng.common.ResultCode;
import com.rimi.ruiFeng.common.ResultData;
import com.rimi.ruiFeng.controller.FileUploadController;
import com.rimi.ruiFeng.mapper.UserTableMapper;
import com.rimi.ruiFeng.service.UpdatePersonalDetails;
import com.rimi.ruiFeng.util.UtilString;
import com.rimi.ruiFeng.util.VerificationLogin;
import com.rimi.ruiFeng.vo.LoginDataVo;
import com.rimi.ruiFeng.vo.UpdateUserHeadVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author chenjin
 * @date 2019/11/13 11:12
 */
@Service
public class UpdatePersonalDetailsImpl implements UpdatePersonalDetails {

    @Resource
    private UserTableMapper userTableMapper;



    /**
     * 修改头像
     * @param updateHead
     * @param request
     * @return
     */
    @Override
    public ResultData updateUserPassword(UpdateUserHeadVo updateHead, HttpServletRequest request) {
        Boolean verifcation = new VerificationLogin(userTableMapper).getVerifcation(updateHead.getVerification());
        if(updateHead.getVerification()==null&&updateHead.getMultipartFile()==null&&!verifcation){
            return new DefaultResultData(ResultCode.ERROR_PARAMETER);
        }
        FileUploadController fileUploadController = new FileUploadController();
        ResultData resultData =fileUploadController.uploadFile2(updateHead.getVerification(),updateHead.getMultipartFile(),  request);
        return resultData;
    }

    /**
     * 修改昵称
     */
    @Override
    public int updateAlias(String userName,String type) {
        Boolean verifcation = new VerificationLogin(userTableMapper).getVerifcation(userName);
        if(!verifcation){
            return -5;
        }
        String[] strings = UtilString.InterceptString(userName);
        int i = userTableMapper.updateAlias(strings[0],type);
        return i;
    }



    /**
     * 修改密码
     */
    @Override
    public int updateUserPassword(String userName, String newPassword) {
        int i = userTableMapper.updateUserPassword(userName,newPassword);
        return i;
    }


    /**
     * 修改邮箱
     */
    @Override
    public int updateUserEmail(LoginDataVo updateEmail) {
        Boolean verifcation = new VerificationLogin(userTableMapper).getVerifcation(updateEmail.getVerification());
        if(!verifcation){
            return -5;
        }
        String[] strings = UtilString.InterceptString(updateEmail.getVerification());
        int i = userTableMapper.updateEmail(strings[0],updateEmail.getCourseintroductionType());
        return i;
    }

}
