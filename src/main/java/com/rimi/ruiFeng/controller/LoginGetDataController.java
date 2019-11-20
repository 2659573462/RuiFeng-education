package com.rimi.ruiFeng.controller;

import com.rimi.ruiFeng.bean.CourseintroductionTable;
import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.bean.VideotimeTable;
import com.rimi.ruiFeng.common.DefaultResultData;
import com.rimi.ruiFeng.common.ResultCode;
import com.rimi.ruiFeng.common.ResultData;
import com.rimi.ruiFeng.service.CourseintroductionTableService;
import com.rimi.ruiFeng.service.LoginGetDataService;
import com.rimi.ruiFeng.service.VideotimeTableService;
import com.rimi.ruiFeng.service.impl.CourseintroductionTableServiceImpl;
import com.rimi.ruiFeng.service.impl.VideotimeTableServiceImpl;
import com.rimi.ruiFeng.util.UtilString;
import com.rimi.ruiFeng.vo.LoginDataVo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取数据
 *
 * @author chenjin
 * @date 2019/11/8 18:07
 */
@Api(tags = "登录获取的数据")
@CrossOrigin
@RestController
public class LoginGetDataController {

    private LoginGetDataService loginGetData;
    private CourseintroductionTableService courseintroductionTableService;
    private VideotimeTableService VideotimeTableService;

    private LoginGetDataController(LoginGetDataService loginGetData,
                                   CourseintroductionTableServiceImpl courseintroductionTableServiceImpl,
                                   VideotimeTableServiceImpl VideotimeTableServiceImpl){
        this.loginGetData= loginGetData;
        this.courseintroductionTableService = courseintroductionTableServiceImpl;
        this.VideotimeTableService =VideotimeTableServiceImpl;
    }

    /**
     * 获取精品
     * @param loginDataVo
     * @return
     */
    @PostMapping("/loginData")
    private ResultData loginGetData(@RequestBody  LoginDataVo loginDataVo){
        System.out.println(loginDataVo.getCourseintroductionType());
        List<CourseintroductionTable> courseintroductionTables = loginGetData.selectBoutique(loginDataVo.getCourseintroductionType());
        for (CourseintroductionTable s:
        courseintroductionTables) {
            System.out.println(s);
        }
        List<Object> list = new ArrayList<>();
        list.add(courseintroductionTables);
        return new DefaultResultData(list);
    }


    /**
     * 获取用户的个人信息
     */
    @PostMapping("/accessToPersonalInformation")
    private ResultData accessToPersonalInformation(@RequestBody  LoginDataVo loginDataVo){
        if(loginDataVo.getVerification()==null){
            return new DefaultResultData(ResultCode.ERROR_PARAMETER);
        }else {
            //UeRfyq2gk4TtlRhCdmL3dGwdFMQnfWt+sv9y4dyhohc=,Oz7UJmwLkoW5+BQwtprVKAZhtL4ixzbSMNeWAyrMtKg=
            UserTable userTable=loginGetData.selectUsername(loginDataVo.getVerification());
            return new DefaultResultData(userTable);
        }
    }


    /**
     * 获取已经购买的
     */
    @PostMapping("/userBought")
    private ResultData userBought(@RequestBody  LoginDataVo loginDataVo){
        if(loginDataVo.getVerification()==null){
            return new DefaultResultData(ResultCode.ERROR_PARAMETER);
        }else {
            UserTable userTable=loginGetData.selectUsername(loginDataVo.getVerification());
            String userByvideo = userTable.getUserByvideo();
            String[] strings = UtilString.InterceptString(userByvideo);
            List userBought=new ArrayList();
            for (int i = 0; i <strings.length ; i++) {
                CourseintroductionTable courseintroductionTable = courseintroductionTableService.selectDistinction(strings[i]);
                if(courseintroductionTable!=null){
                    userBought.add(courseintroductionTable);
                }
            }
            return new DefaultResultData(userBought);
        }
    }

    /**
     *获取用户的观看记录
     */
    @PostMapping("/historyRecord")
    private ResultData historyRecord(@RequestBody LoginDataVo loginDataVo){
        if(loginDataVo.getVerification()!=null){
            return new DefaultResultData(ResultCode.ERROR_PARAMETER);
        }else {
            String verification = loginDataVo.getVerification();
            String[] strings = UtilString.InterceptString(verification);
            List<VideotimeTable> fs = VideotimeTableService.selectUsername(strings[0]);
            return new DefaultResultData(fs);
        }
    }

    /**
     * 加入观看历史记录
     */
    //private Result  getHistoryRecord




}
