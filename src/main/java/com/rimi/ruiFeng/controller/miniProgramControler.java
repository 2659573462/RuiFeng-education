package com.rimi.ruiFeng.controller;

import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.common.DefaultResultData;
import com.rimi.ruiFeng.common.ResultCode;
import com.rimi.ruiFeng.common.ResultData;
import com.rimi.ruiFeng.service.impl.UserTableServiceImpl;
import com.rimi.ruiFeng.util.AcquireOrderForm;
import com.rimi.ruiFeng.util.PwdUtils;
import com.rimi.ruiFeng.vo.miniProgramControlerVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 小程序控制层
 *
 * @author chenjin
 * @date 2019/11/14 16:40
 */
@Api(tags = "小程序获取数据")
@CrossOrigin
@RestController
public class miniProgramControler {

    @Autowired
    private UserTableServiceImpl userTableService;


    @PostMapping("/minLogin")
    private ResultData minLogin(@RequestBody  miniProgramControlerVo minContro){
        if(minContro.getOpenid()==null){
            return new DefaultResultData(ResultCode.ERROR_PARAMETER);
        }
        UserTable user =  userTableService.selectOpenid(minContro.getOpenid());
        if(user==null){
            return new DefaultResultData(ResultCode.INEXISTENCE);
        }
        String correction=null;
        correction=user.getUserUsername()+","+ PwdUtils.getPwd(AcquireOrderForm.getOrderForm());
        List list = new ArrayList();
        list.add(correction);
        //将生成的令牌状态吗传入数据库
        int i1=userTableService.updateByCorrection(user.getUserUsername(),correction);
        System.out.println("注册修改状态码"+i1);
        return new DefaultResultData(list);
    }


}
