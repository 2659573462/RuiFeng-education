package com.rimi.ruiFeng.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.rimi.ruiFeng.bean.MessageTable;
import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.common.*;
import com.rimi.ruiFeng.service.LoginService;
import com.rimi.ruiFeng.service.MessageTableService;
import com.rimi.ruiFeng.service.impl.MessageTableServiceImpl;
import com.rimi.ruiFeng.service.impl.UserTableServiceImpl;
import com.rimi.ruiFeng.util.UtilString;
import com.rimi.ruiFeng.vo.messageCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

@Controller
@CrossOrigin
@Api(tags = ("获取短信验证码相关操作"))
public class SmsPushUtil {
    /**
     * 验证码
     */
    private static String codes;
    static final String product = "Dysmsapi";
    static final String domain = "dysmsapi.aliyuncs.com";
    static final String accessKeyId = "LTAI4FwDbYkct3bF28JJ2vbq";
    static final String accessKeySecret = "jfWg4SZqq8X0oNJAvNmBGf051Zs6Ah";

    public  MessageTableService messageTables;
    private final UserTableServiceImpl userTableService;

    public SmsPushUtil(MessageTableService messageTables,UserTableServiceImpl userTableService){
        this.messageTables=messageTables;
        this.userTableService=userTableService;
    }

    /**
     *
     *发送验证码
     * @return 返回验证码是否正确的消息结果
     */
    @ApiOperation(value = "注册发送验证码")
    @ResponseBody
    @PostMapping("/messageCode")
    public AbstractResult getMessageCode(@RequestBody MessageTable messageTable) {

        System.out.println("手机号是"+messageTable.getMessageMobile());
        String ssm = getSsm(messageTable.getMessageMobile());
        System.out.println("状态"+ssm);
        //判断发送是否成功
        if (ssm!=null){
            MessageTable messageTable1 = messageTables.selectMobile(messageTable.getMessageMobile());
            //手机存在然后将动态验证存储
            if(messageTable1!=null){
                messageTable.setMessageTime(String.valueOf(System.currentTimeMillis()));
                int i = messageTables.updateMobile(messageTable.getMessageMobile(), codes,messageTable.getMessageTime());
                return i>0?new DefaultResult(ResultCode.SUCCESSC):new DefaultResult(ResultCode.SUCCESSCDEFEATED);
            }else{
                //存入时间
                messageTable.setMessageVerifcationcode(codes);
                //存入时间
                messageTable.setMessageTime(String.valueOf(System.currentTimeMillis()));
                int insert = messageTables.insert(messageTable);
                return insert>0?new DefaultResult(ResultCode.SUCCESSC):new DefaultResult(ResultCode.SUCCESSCDEFEATED);
            }
        }
        return new DefaultResult(ResultCode.SUCCESSCDEFEATED);
    }

    @ApiOperation(value = "修改手机号,验证码验证码是否过期")
    @PostMapping("/updateUserTellphonenumber")
    private Result loginPhoneVerification(@RequestBody messageCode mesCode){
        System.out.println(mesCode);
        //messageCode(id=0, mobile=15828222728, verificationCode=303525, state=修改, verification=cO3xJ4w9NBZeSXABG0OnTlrtXUS0XDG5ysMMd3gu9N0=,OdWO9N895e+Hjdu7EXn4vsE4OjJcyIa5mYsG42iHJbU=)
        if(mesCode.getMobile()!=null&&mesCode.getVerificationCode()!=null&&mesCode.getState()!=null){
            if(!mesCode.getState().equals("修改")){
                return  new DefaultResult(ResultCode.NOT_SUPPORT_LOGIN);
            }else{
                //查询手机是否存在
                String verificationCode = mesCode.getVerificationCode();
                MessageTable messageTable = messageTables.selectMobileAndVerificationoCde(mesCode.getMobile(),verificationCode);
                if(messageTable==null){
                    System.out.println("不存在");
                    //原因是中途更换账号
                    return new DefaultResult(ResultCode.FAIL);
                }else{
                    System.out.println("验证通过");
                    //检测账号是否存在
                    String verification1 = mesCode.getVerification();
                    String[] strings1 = UtilString.InterceptString(verification1);
                    UserTable userTable = userTableService.selectUsername(strings1[0]);
                    if(userTable==null){
                        return new DefaultResult(ResultCode.INEXISTENCE);
                    }else{
                        Long s = Long.valueOf("3000000");
                        MessageTable messageTable1 = messageTables.selectMobile(mesCode.getMobile());
                        System.out.println(messageTable1.getMessageTime());
                        Date date = new Date(Long.parseLong(String.valueOf(messageTable1.getMessageTime()))-s);
                        Date d2 = new Date(System.currentTimeMillis());
                        if((date.compareTo(d2))<0){
                            //把验证码和时间便空
                            int i = messageTables.updateMobile(mesCode.getMobile(), "","");
                            //检测需要加入的手机是否已经存在
                            UserTable userTable1 = userTableService.selectMobile(mesCode.getMobile());
                            if(userTable1!=null){
                                return new DefaultResult(ResultCode.ALREADYEXIST);
                            }
                            int j =userTableService.updatePhoneVerification(strings1[0],mesCode.getMobile());
                            if(j>0){
                                return new DefaultResult(ResultCode.SUCCESS);
                            }else{
                                return new DefaultResult(ResultCode.FAIL);
                            }
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




    public static void main(String[] args) {
        String ssm = getSsm("18161326552");
        System.out.println(ssm);
    }


    public static String getSsm(String number) {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        } catch (ClientException e1) {
            e1.printStackTrace();
        }
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //随机生成六位验证码
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        codes =String.valueOf(code);
        //删除该号码上次的验证码记录
        //verificationCodeMapper.deleteVerificationCodeMapper(number);
        ////保存到数据库
        //VerificationCode verificationCode = new VerificationCode();
        //verificationCode.setCode(code+"");
        //verificationCode.setNumber(number);
        //int i =verificationCodeMapper.addVerificationCode(verificationCode);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(number);
        //必填:短信签名-可在短信控制台中找到，你在签名管理里的内容
        request.setSignName("芮米在线教育平台");
        //必填:短信模板-可在短信控制台中找到，你模板管理里的模板编号
        request.setTemplateCode("SMS_177257441");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":\"" + code + "\"}");

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        //获取发送状态
        String cod = sendSmsResponse.getCode();

        return cod;
    }
}
