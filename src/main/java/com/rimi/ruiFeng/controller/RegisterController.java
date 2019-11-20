package com.rimi.ruiFeng.controller;

import com.rimi.ruiFeng.bean.MessageTable;
import com.rimi.ruiFeng.bean.ShopTable;
import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.common.*;
import com.rimi.ruiFeng.service.MessageTableService;
import com.rimi.ruiFeng.service.ShopTableService;
import com.rimi.ruiFeng.service.UserTableService;
import com.rimi.ruiFeng.service.impl.RegisterServiceImpl;
import com.rimi.ruiFeng.service.impl.UserTableServiceImpl;
import com.rimi.ruiFeng.util.AcquireOrderForm;
import com.rimi.ruiFeng.util.PwdUtils;
import com.rimi.ruiFeng.vo.RegistUserVo;
import com.rimi.ruiFeng.vo.messageCode;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Transactional(rollbackFor = Exception.class)
public class RegisterController {

    private final RegisterServiceImpl registerService;
    private final UserTableService userTableService;
    private final MessageTableService messageTables;
    private final ShopTableService  shopTableService;

    public RegisterController(RegisterServiceImpl registerService,UserTableServiceImpl userTableService,
                              MessageTableService messageTables, ShopTableService  shopTableService){
        this.registerService= registerService;
        this.userTableService =userTableService ;
        this.messageTables=messageTables;
        this.shopTableService=shopTableService;
    }

    /**
     * 验证
     * @param registUserVo
     * @return
     */
    @PostMapping("/register")
    private ResultData insertUserController(@RequestBody RegistUserVo registUserVo){
            //判断传入的数据是否为空
            if(registUserVo.getUsername()!=null&&registUserVo.getPassword()!=null&&registUserVo.getTelephoneNumber()!=null&&registUserVo.getAuthCode()!=null){
                    //判断账号是否存在:手机和账号
                    UserTable userTable = userTableService.selectUsername(PwdUtils.getPwd(registUserVo.getUsername()));
                    UserTable userTable1 = userTableService.selectMobile(registUserVo.getTelephoneNumber());
                    if(userTable!=null || userTable1!=null){
                        return  new DefaultResultData(null,ResultCode.ALREADYEXIST);
                    }else{
                        MessageTable messageTable=messageTables.selectMobileAndVerificationoCde(registUserVo.getTelephoneNumber(),registUserVo.getAuthCode());
                        //验证验证是否正确
                        if(messageTable!=null ){
                            String use = PwdUtils.getPwd(registUserVo.getUsername());
                            //为用户生成购物车
                            ShopTable shopTable = new ShopTable();
                            shopTable.setShopAccountnumber(use);
                            int insert = shopTableService.insert(shopTable);

                            //查询购物车
                            ShopTable shop=shopTableService.selectAccountnumber(use);
                            Integer shopId = shop.getShopId();
                            //生成用户
                            int i = registerService.insertUser(shopId,registUserVo);
                            if(i>0){
                                //生成令牌
                                String correction =  null;
                                correction =use+","+ PwdUtils.getPwd(AcquireOrderForm.getOrderForm());
                                //截取时间
                                //String.valueOf(System.currentTimeMillis())
                                List list = new ArrayList();
                                list.add(correction);
                                //将生成的令牌状态吗传入数据库
                                int i1=userTableService.updateByCorrection(PwdUtils.getPwd(registUserVo.getUsername()),correction);

                                //成功200
                                return  new DefaultResultData(list);
                            }else{
                                //失败208
                                return  new DefaultResultData(null,ResultCode.ACCOUNTNUMBERDEFEATED);
                            }
                        }else{
                            return  new DefaultResultData(null,ResultCode.ERROR_VERIFICATION_CODE_INCORRECT);
                        }
                    }
            }else{
                return  new DefaultResultData(null,ResultCode.ERROR_PARAMETER);
            }
    }

    /**
     * 获取注册的验证码
     * @param mesCode
     * @return
     */
    @PostMapping("/register-verification")
    private Result verification(@RequestBody messageCode mesCode){
        System.out.println("接收对象"+mesCode);
        //对象验证对象没有
        MessageTable messageTable1 = new MessageTable();
        //添加手机号到发送短信的对象
        messageTable1.setMessageMobile(mesCode.getMobile());
        SmsPushUtil smsPushUtil = new SmsPushUtil(messageTables,userTableService);
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
