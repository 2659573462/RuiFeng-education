package com.rimi.ruiFeng.controller;

import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.common.*;
import com.rimi.ruiFeng.service.LoginService;
import com.rimi.ruiFeng.util.AcquireOrderForm;
import com.rimi.ruiFeng.util.PwdUtils;
import com.rimi.ruiFeng.vo.User;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户控制层
 *
 * @author chenjin
 * @date 2019/11/5 14:30
 */
@Api(tags = "登录操作")
@CrossOrigin
@RestController
public class LoginController {

    public final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResultData loginController(@RequestBody User user) {
        //@ModelAttribute
        /*@ApiIgnore  @RequestBody*/
        System.out.println(user);
            if(user.getUsername()!=null && user.getPassword()!=null){
                //生成令牌
                String uses = PwdUtils.getPwd(user.getUsername());
                List list = new ArrayList();
                UserTable userTable = loginService.selectUser(user);
                if(userTable!=null){
                    list.add(uses);
                    //传给前端
                    return new DefaultResultData(list);
                }else{
                    return new DefaultResultData();
                }
            }else{

                return new DefaultResultData();
            }
        }
    }