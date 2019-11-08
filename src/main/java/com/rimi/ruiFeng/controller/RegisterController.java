package com.rimi.ruiFeng.controller;

import com.rimi.ruiFeng.bean.MessageTable;
import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.common.AbstractResult;
import com.rimi.ruiFeng.common.DefaultResult;
import com.rimi.ruiFeng.common.Result;
import com.rimi.ruiFeng.common.ResultCode;
import com.rimi.ruiFeng.service.MessageTableService;
import com.rimi.ruiFeng.service.impl.RegisterServiceImpl;
import com.rimi.ruiFeng.service.impl.UserTableServiceImpl;
import com.rimi.ruiFeng.vo.RegistUserVo;
import com.rimi.ruiFeng.vo.messageCode;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.rimi.ruiFeng.common.ResultCode.ALREADYEXIST;

/**
 * 注册控制层
 *
 * @author chenjin
 * @date 2019/11/7 20:54
 */
@Api(tags = "注册")
@CrossOrigin
@RestController
public class RegisterController {

    private RegisterServiceImpl registerService;
    private UserTableServiceImpl userTableService;
    public MessageTableService messageTables;

    public RegisterController(RegisterServiceImpl registerService,UserTableServiceImpl userTableService,MessageTableService messageTables){
        this.registerService= registerService;
        this.userTableService =userTableService ;
        this.messageTables=messageTables;
    }
    @PostMapping("/register")
    public Result insertUserController(@RequestBody RegistUserVo registUserVo){
            //判断传入的数据是否为空
            if(registUserVo.getUsername()!=null&&registUserVo.getPassword()!=null&&registUserVo.getTelephoneNumber()!=null&&registUserVo.getAuthCode()!=null){
                    //判断账号是否存在
                    UserTable userTable = userTableService.selectUsername(registUserVo.getUsername());
                    UserTable userTable1 = userTableService.selectMobile(registUserVo.getTelephoneNumber());
                    if(userTable!=null || userTable1!=null){
                        return  new DefaultResult(ResultCode.ALREADYEXIST);
                    }else{
                        MessageTable messageTable=messageTables.selectMobileAndVerificationoCde(registUserVo.getTelephoneNumber(),registUserVo.getAuthCode());
                        //验证验证是否正确
                        if(messageTable!=null ){
                            int i = registerService.insertUser(registUserVo);
                            if(i>0){
                                //成功207
                                return  new DefaultResult(ResultCode.ACCOUNTNUMBERSUCCEED);
                            }else{
                                //失败208
                                return  new DefaultResult(ResultCode.ACCOUNTNUMBERDEFEATED);
                            }
                        }else{
                            return  new DefaultResult(ResultCode.ERROR_VERIFICATION_CODE_INCORRECT);
                        }
                    }
            }else{
                return  new DefaultResult(ResultCode.ERROR_PARAMETER);
            }
    }

    /**
     * 获取注册的验证码
     * @param mesCode
     * @return
     */
    @PostMapping("/register-verification")
    public Result verification(@RequestBody  messageCode mesCode){
        System.out.println("接收对象"+mesCode);
        //对象验证对象没有
        MessageTable messageTable1 = new MessageTable();
        //添加手机号到发送短信的对象
        messageTable1.setMessageMobile(mesCode.getMobile());
        SmsPushUtil smsPushUtil = new SmsPushUtil(messageTables);
        if(!mesCode.getState().equals("注册")){
            return  new DefaultResult(ResultCode.NOT_SUPPORT_REGISTER);
        }
        UserTable users=userTableService.selectMobile(mesCode.getMobile());
        if(users!=null){
            //手机号存在就发送失败
            return  new DefaultResult(ResultCode.ALREADYEXIST);
        }
        //发送短信
        System.out.println("发送短信对象"+messageTable1);
        if(messageTable1.getMessageMobile()==null){
            return  new DefaultResult(ResultCode.SUCCESSCDEFEATED);
        }
        AbstractResult messageCode = smsPushUtil.getMessageCode(messageTable1);
        Integer code = messageCode.getCode();
        System.out.println(code);
        if(code==205){
            System.out.println("成功");
            return  new DefaultResult(ResultCode.SUCCESSC);
        }else{
            System.out.println("失败");
            return  new DefaultResult(ResultCode.SUCCESSCDEFEATED);
        }

    }

}
