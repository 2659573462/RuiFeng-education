package com.rimi.ruiFeng.controller;

import com.rimi.ruiFeng.bean.MessageTable;
import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.common.*;
import com.rimi.ruiFeng.service.LoginService;
import com.rimi.ruiFeng.service.MessageTableService;
import com.rimi.ruiFeng.service.UserTableService;
import com.rimi.ruiFeng.service.impl.UserTableServiceImpl;
import com.rimi.ruiFeng.util.AcquireOrderForm;
import com.rimi.ruiFeng.util.PwdUtils;
import com.rimi.ruiFeng.vo.User;
import com.rimi.ruiFeng.vo.messageCode;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.Date;
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



    private final LoginService loginService;
    private final MessageTableService messageTables;
    private final UserTableService userTableService;

    public LoginController(LoginService loginService,MessageTableService messageTables,UserTableServiceImpl userTableService) {
        this.loginService = loginService;
        this.userTableService =userTableService ;
        this.messageTables=messageTables;
    }

    /**
     * 账号登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    private ResultData loginController(@RequestBody  User user) {
        //@ModelAttribute
        /*@ApiIgnore  @RequestBody*/
        System.out.println(user);
            if(user.getUsername()!=null && user.getPassword()!=null){
                UserTable userTable = loginService.selectUser(user);
                if(userTable!=null){
                    //生成令牌
                    String correction=null;
                    String pwd = PwdUtils.getPwd(user.getUsername());
                    correction =pwd+","+ PwdUtils.getPwd(AcquireOrderForm.getOrderForm());
                    //截取时间
                    //String.valueOf(System.currentTimeMillis())
                    List list = new ArrayList();
                    list.add(correction);
                    //将生成的令牌状态吗传入数据库
                    int i1=userTableService.updateByCorrection(PwdUtils.getPwd(user.getUsername()),correction);
                    //传给前端
                    return new DefaultResultData(list);
                }else{
                    return new DefaultResultData();
                }
            }else{
                return new DefaultResultData();
            }
        }

    /**
     *
     * 验证码登录发送短信
     * @return
     */
    @PostMapping("/login_Phone_Register")
    private Result loginPhoneRegister(@RequestBody messageCode mesCode){
        if(mesCode.getMobile()!=null&&mesCode.getState()!=null){
            if(!mesCode.getState().equals("登录")){
                return  new DefaultResult(ResultCode.NOT_SUPPORT_LOGIN);
            }
            //检测账号是否存在
            UserTable userTable = userTableService.selectMobile(mesCode.getMobile());
            if(userTable==null){
                return new DefaultResult(ResultCode.INEXISTENCE);
            }else{
                //创建一个发送验证码的工具
                SmsPushUtil smsPushUtil = new SmsPushUtil(messageTables, (UserTableServiceImpl) userTableService);
                //设置对象参数传入工具中
                MessageTable messageTable1 = new MessageTable();
                //手机号传入
                messageTable1.setMessageMobile(mesCode.getMobile());
                //发送
                AbstractResult messageCode = smsPushUtil.getMessageCode(messageTable1);
                //拿到状态嘛
                Integer code = messageCode.getCode();
                System.out.println(code);
                if(code==205){
                    return  new DefaultResult(ResultCode.SUCCESSC);
                }else{
                    return  new DefaultResult(ResultCode.SUCCESSCDEFEATED);
                }
            }
        }else{
            return new DefaultResult(ResultCode.ERROR_PARAMETER);
        }

    }

    /**
     * 校验短信验证
     * @return
     */
    @PostMapping("/login_Phone_Verification")
    private Result loginPhoneVerification(@RequestBody messageCode mesCode){
        if(mesCode.getMobile()!=null&&mesCode.getVerificationCode()!=null&&mesCode.getState()!=null){
            if(!mesCode.getState().equals("登录")){
                return  new DefaultResult(ResultCode.NOT_SUPPORT_LOGIN);
            }else{
                //查询手机是否存在
                MessageTable messageTable = messageTables.selectMobileAndVerificationoCde(mesCode.getMobile(),mesCode.getVerificationCode());
                if(messageTable==null){
                    //原因是中途更换账号
                    return new DefaultResult(ResultCode.FAIL);
                }else{
                    //检测账号是否存在
                    UserTable userTable = userTableService.selectMobile(mesCode.getMobile());
                    if(userTable==null){
                        return new DefaultResult(ResultCode.INEXISTENCE);
                    }else{
                        Long s = Long.valueOf("3000000");
                        Date date = new Date(Long.parseLong(String.valueOf(messageTables.selectMobile(mesCode.getMobile())))-s);
                        Date d2 = new Date(System.currentTimeMillis());
                        if((date.compareTo(d2))<0){
                            int i = messageTables.updateMobile(mesCode.getMobile(), "","");
                            return new DefaultResult(ResultCode.LOGIN_SUCCEED);
                        }else{
                            return new DefaultResult(ResultCode.ERROR_VERIFICATION_PAST_DUE);
                        }

                    }
                }
            }
        }else{
            return new DefaultResult(ResultCode.ERROR_PARAMETER);
        }
    }

    /**
     *                    _ooOoo_
     *                   o8888888o
     *                   88" . "88
     *                   (| -_- |)
     *                    O\ = /O
     *                ____/`---'\____
     *              .   ' \\| |// `.
     *               / \\||| : |||// \
     *             / _||||| -:- |||||- \
     *               | | \\\ - /// | |
     *             | \_| ''\---/'' | |
     *              \ .-\__ `-` ___/-. /
     *           ___`. .' /--.--\ `. . __
     *        ."" '< `.___\_<|>_/___.' >'"".
     *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
     *         \ \ `-. \_ __\ /__ _/ .-` / /
     * ======`-.____`-.___\_____/___.-`____.-'======
     *                    `=---='
     *
     * .............................................
     *          佛祖保佑             永无BUG
     */

/**
 *                                         ,s555SB@@&
 *                                      :9H####@@@@@Xi
 *                                     1@@@@@@@@@@@@@@8
 *                                   ,8@@@@@@@@@B@@@@@@8
 *                                  :B@@@@X3hi8Bs;B@@@@@Ah,
 *             ,8i                  r@@@B:     1S ,M@@@@@@#8;
 *            1AB35.i:               X@@8 .   SGhr ,A@@@@@@@@S
 *            1@h31MX8                18Hhh3i .i3r ,A@@@@@@@@@5
 *            ;@&i,58r5                 rGSS:     :B@@@@@@@@@@A
 *             1#i  . 9i                 hX.  .: .5@@@@@@@@@@@1
 *              sG1,  ,G53s.              9#Xi;hS5 3B@@@@@@@B1
 *               .h8h.,A@@@MXSs,           #@H1:    3ssSSX@1
 *               s ,@@@@@@@@@@@@Xhi,       r#@@X1s9M8    .GA981
 *               ,. rS8H#@@@@@@@@@@#HG51;.  .h31i;9@r    .8@@@@BS;i;
 *                .19AXXXAB@@@@@@@@@@@@@@#MHXG893hrX#XGGXM@@@@@@@@@@MS
 *                s@@MM@@@hsX#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&,
 *              :GB@#3G@@Brs ,1GM@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@B,
 *            .hM@@@#@@#MX 51  r;iSGAM@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@8
 *          :3B@@@@@@@@@@@&9@h :Gs   .;sSXH@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:
 *      s&HA#@@@@@@@@@@@@@@M89A;.8S.       ,r3@@@@@@@@@@@@@@@@@@@@@@@@@@@r
 *   ,13B@@@@@@@@@@@@@@@@@@@5 5B3 ;.         ;@@@@@@@@@@@@@@@@@@@@@@@@@@@i
 *  5#@@#&@@@@@@@@@@@@@@@@@@9  .39:          ;@@@@@@@@@@@@@@@@@@@@@@@@@@@;
 *  9@@@X:MM@@@@@@@@@@@@@@@#;    ;31.         H@@@@@@@@@@@@@@@@@@@@@@@@@@:
 *   SH#@B9.rM@@@@@@@@@@@@@B       :.         3@@@@@@@@@@@@@@@@@@@@@@@@@@5
 *     ,:.   9@@@@@@@@@@@#HB5                 .M@@@@@@@@@@@@@@@@@@@@@@@@@B
 *           ,ssirhSM@&1;i19911i,.             s@@@@@@@@@@@@@@@@@@@@@@@@@@S
 *              ,,,rHAri1h1rh&@#353Sh:          8@@@@@@@@@@@@@@@@@@@@@@@@@#:
 *            .A3hH@#5S553&@@#h   i:i9S          #@@@@@@@@@@@@@@@@@@@@@@@@@A.
 *
 *
 *    又看源码，看你妹妹呀！
 */

/**
 *  You are not expected to understand this
 *    你绝不会明白的
 */

}