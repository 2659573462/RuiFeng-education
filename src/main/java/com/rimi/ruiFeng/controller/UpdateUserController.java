package com.rimi.ruiFeng.controller;

import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.common.DefaultResultData;
import com.rimi.ruiFeng.common.Result;
import com.rimi.ruiFeng.common.ResultCode;
import com.rimi.ruiFeng.common.ResultData;
import com.rimi.ruiFeng.mapper.UserTableMapper;
import com.rimi.ruiFeng.service.impl.UpdatePersonalDetailsImpl;
import com.rimi.ruiFeng.service.impl.UserTableServiceImpl;
import com.rimi.ruiFeng.util.PwdUtils;
import com.rimi.ruiFeng.util.UtilString;
import com.rimi.ruiFeng.vo.LoginDataVo;
import com.rimi.ruiFeng.vo.UpdatePwd;
import com.rimi.ruiFeng.vo.UpdateUserHeadVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 修改用户信息控制层
 *
 * @author chenjin
 * @date 2019/11/13 11:24
 */
@Api(tags = "修改用户信息控制层")
@CrossOrigin
@RestController
@Transactional(rollbackFor = Exception.class)
public class UpdateUserController {
    @Autowired
    private UpdatePersonalDetailsImpl updatePersonalDetailsImpl;

    @Autowired
    private UserTableServiceImpl userTableService;

    /**
     * 修改头像
     * @param updateHead
     * @param request
     * @return
     */
    @PostMapping("/updateUserHead")
    private ResultData updateHead(UpdateUserHeadVo updateHead, HttpServletRequest request){
        ResultData resultData = updatePersonalDetailsImpl.updateUserPassword(updateHead, request);
        return resultData;
        //http://10.2.5.16:8888/group1/M00/00/00/CgIFEF3ADr6APu1kABgOvcx4ouM060.png
    }

    /**
     * 修改昵称
     */
    @PostMapping("/updateAlias")
    private ResultData updateAlias(@RequestBody LoginDataVo tpe){
        int i=updatePersonalDetailsImpl.updateAlias(tpe.getVerification(),tpe.getCourseintroductionType());
        if(i>0){
            return new DefaultResultData(ResultCode.SUCCESS);
        }else{
            return new DefaultResultData(ResultCode.FAIL);
        }
    }


    /**
     * kP86wJWxLKHy4mbN+ilGy0rqLD3iBimUmA0YVmJzSjQ=
     *kP86wJWxLKHy4mbN+ilGy0rqLD3iBimUmA0YVmJzSjQ=
     * 修改密码
     */
    @PostMapping("/updatePassword")
    private ResultData updatePassword(@RequestBody  UpdatePwd pwds){
        System.out.println(pwds);
        String verification = pwds.getVerification();
        String[] strings = UtilString.InterceptString(verification);
        //更具账号和原始密码查询用户
        UserTable user= userTableService.selectUserAndPwd(strings[0],PwdUtils.getPwd(pwds.getOldPassword()));

        if(user==null){
            System.out.println("找不到用户");
            return new DefaultResultData(ResultCode.FAIL);
            //9999999999
            //UeRfyq2gk4TtlRhCdmL3dGwdFMQnfWt+sv9y4dyhohc=
            //cO3xJ4w9NBZeSXABG0OnTlrtXUS0XDG5ysMMd3gu9N0=
            //kP86wJWxLKHy4mbN+ilGy0rqLD3iBimUmA0YVmJzSjQ=
        }

        //修改秘密 :搜寻用户  修改密码
        int i=updatePersonalDetailsImpl.updateUserPassword(strings[0],PwdUtils.getPwd(pwds.getNewPassword()));
        System.out.println(strings[0]+"账号");
        System.out.println(PwdUtils.getPwd(pwds.getNewPassword())+"新密码");
        if(i>0){
            System.out.println("修改成功");
            return new DefaultResultData(ResultCode.SUCCESS);
        }else{
            System.out.println("修改失败");
            return new DefaultResultData(ResultCode.FAIL);
        }

    }


    /**
     * 修改邮箱
     */
    @PostMapping("/updateEmail")
    private ResultData updateEmail(@RequestBody LoginDataVo updateEmail){
        int i = updatePersonalDetailsImpl.updateUserEmail(updateEmail);
        if(i>0 && i!=-5){
            return new DefaultResultData(ResultCode.SUCCESS);
        }else{
            return new DefaultResultData(ResultCode.FAIL);
        }

    }

    /**
     * 修改手机
     */

}
