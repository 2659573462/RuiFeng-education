package com.rimi.ruiFeng.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * 短信推送
 *
 * @author chenjin
 * @date 2019/11/6 9:53
 */
public class SmsPushUtil {
    public static void main(String[] args) {
        SmsPushUtil smsPushUtil = new SmsPushUtil();
        try {
            SendSmsResponse sendSmsResponse = sendMessage("18161326552", "123541");
            if(sendSmsResponse!=null){
                System.out.println(sendSmsResponse);
                System.out.println("不空");
            }else{
                System.out.println("空");
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }


        // 产品名称:云通信短信API产品,开发者无需替换
        private static final String product = "Dysmsapi";
        // 产品域名,开发者无需替换
        private static final String domain = "dysmsapi.aliyuncs.com";
        private static String accessKeyId = "LTAI4FwDbYkct3bF28JJ2vbq";
        private static String accessKeySecret = "jfWg4SZqq8X0oNJAvNmBGf051Zs6Ah";
        private static String signName = "瑞峰在线教育平台";
        private static String templeteCode = "SMS_176938022";

    /**
     *
     * @param telephone 手机号
     * @param number 验证码
     * @return
     * @throws ClientException
     */
    public static SendSmsResponse sendMessage(String telephone, String number) throws ClientException {

        // 可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        // 初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-sichuan", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-sichuan", "cn-sichuan", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        // 组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();

        // 必填:待发送手机号
        request.setPhoneNumbers(telephone);
        // 必填:短信签名-可在短信控制台中找到
        request.setSignName(signName);
        // 必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templeteCode);

        // 可选:模板中的变量替换JSON串,如模板内容为"尊敬的用户,您的验证码为${code}"时,此处的值为
        String jsonParam = "{\"code\":\"" + number + "\"}";
        request.setTemplateParam(jsonParam);

        // hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }



}
