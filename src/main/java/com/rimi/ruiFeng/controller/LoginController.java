package com.rimi.ruiFeng.controller;

import com.rimi.ruiFeng.common.DefaultResult;
import com.rimi.ruiFeng.common.ResultCode;
import com.rimi.ruiFeng.util.AcquireOrderForm;
import com.rimi.ruiFeng.vo.User;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制层
 *
 * @author chenjin
 * @date 2019/11/5 14:30
 */
@CrossOrigin
@RequestMapping(produces = "application/json;charset=UTF-8")
@RestController()
@Api(tags = "登录操作")
public class LoginController {

    @PostMapping("/login")
    public String  loginController(User user, Model model){
        if(user.getUsername()!=null && user.getPassword()!=null){
            model.addAttribute("result", new DefaultResult(ResultCode.SUCCESS));
            //生成令牌
            String orderForm =new AcquireOrderForm().getOrderForm();
            //传给前端
            model.addAttribute("authentication",orderForm);
            //

        }else{
            return  "失败";
        }

        return "失败";
    }


}