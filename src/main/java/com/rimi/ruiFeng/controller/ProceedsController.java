package com.rimi.ruiFeng.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.rimi.ruiFeng.util.AcquireOrderForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 支付
 *
 * @author chenjin
 * @date 2019/11/5 16:16
 */
@Controller
public class ProceedsController {

    //@PostMapping("/purchase")
    @GetMapping("/purchase")
    public void payment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //生成订单
        String orderForm =new AcquireOrderForm().getOrderForm();
        String orderForm1 =new AcquireOrderForm().getOrderForm();
        AlipayClient alipayClient = new DefaultAlipayClient(
                "https://openapi.alipaydev.com/gateway.do",
               "2016101700704246",
                "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCAljJneMC3dgC21wiwdS5R/CUhnMXgRW0fAW/Zmw1Z8bpBtqBIslljG20dt1h5NNJC5teD665HD5SC3Bv26f7QDQ0Jt7dMqwdkaZblRCka8uLVB4h1tuQaKCj3B3ADRCWglHtsMiJFoayN8sfqvV7SV7GJpPWp+fwF3KdZEbugVgkelE/0he/km8vsTrJDgnCa7dUzbnDEplciZsBYRc6b6rIIkbgengcn0uMPBmsIWxYxDmYWIP46VGgHTqD0u0DNskYPh+kcZ6UJLLTNCyyML2f7PQB7SAXN4aEQjlE5MJZ0fuHdrdLHoleIDt2pOeS7t4/PvJpGaAJgheOekcGNAgMBAAECggEAOX1tma92UlAS76xieSpbBFK8czO5kJTZvdQRovPc20rlIH47WWVL67CWb4PKrZ49J6Y30wZrS+AeYQdyBUoHIBPFsYOPE1sgGffPfD+mNSNE4UPV8fNMNpmf/xo3LW6peAsKx4v+oK0xDeHvGfeCzn5gpQ64uz9GO4S02XDBN2S4q4cSJdfRjaZEMoxI5rHRkmK0G+eICGSH16uG0V6uRL64gXyab1+M3OWnntoj9/N8CPoE9yXXiFJa9sKyOYmASh5U+MU2ITlF+FGhpOMyhaegiR7z7z0XxR9/Opbz4Iu2JqBw/UBq/GPdUi8BPPFP2+FpT6qIJfc6xUdqt1t3LQKBgQDo4S25xq3HY6tVauQ1Z5eLnB9tpsQ9ddWAkr/PRdmIAMDEi4tnWGampwPnfveRBDn3GqZbf6sy4WBIQRg3lKx40BS9xR/X58ckrVZMNJgsQ6gdkanL5f7uJhIET1Cuhsq6qB1RSBuDpD0T3YOpd0ME76Hcy6EFgSnhG+c2BsRotwKBgQCNWlS0fPdPgEkeG29DTO6Njfv2jvu3XeiBHMsm4iooeAPrgxQRbpOaBeSsAAPIldAzSr1vtQp9j7euApHuSaZk6uMB6E6VIQbM0+LVMNA/GlpGx7GDY2o/tlsIYk3SKPzKjrg4gp4cUT+F/w/M2MgvmTCf7xjLse5LYB85ZOY72wKBgDOy0ajdX3TVPpL+4NyuO6llpmB8VjJit1wMuAI2un0D1ceMRw1RRbCXgTliKWmLK6ccxnOnmwT3nZ1MviiQm91SLFiYq2IN9VrCFFdkkae5+VdfH/fA/mA2GWfVh87G47ieW6vQuzL1Qg3n7jOv4zP0UtWmav/C1d5AiIqo4+9vAoGAHcinynP+ZEkCnw5mzkZ6iWcebSBJl6R45iOcBrBm86n+IXS4GMg036JYQYmrQmuWuAgKjGwYLsbGjCrMduob3m3DsVYyoKeZ2DTZOdSUPIef+AQBuk6LR6tz2PtlrF+ojEGwPXAAQrU37lMFEEOpQqZDoZ9umRT/wfAaBCznejsCgYBJjlhMORVrAiS3akWhiJF+v/lB7bl12aqw8tFaNTow3hdwsOkVk3dMrD5pa/l0TIXjf2Ki8W2BNHzGw+5VuTi5iKi7UsZsYl0+4fpaI+LptVrujp4rOBSFTOQGypin58CpboO5OHOT/95nOlP/8t8/7YE4h4LZYvZxD1EI2qAz0Q==",
                "json",
                "UTF-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgJYyZ3jAt3YAttcIsHUuUfwlIZzF4EVtHwFv2ZsNWfG6QbagSLJZYxttHbdYeTTSQubXg+uuRw+Ugtwb9un+0A0NCbe3TKsHZGmW5UQpGvLi1QeIdbbkGigo9wdwA0QloJR7bDIiRaGsjfLH6r1e0lexiaT1qfn8BdynWRG7oFYJHpRP9IXv5JvL7E6yQ4Jwmu3VM25wxKZXImbAWEXOm+qyCJG4Hp4HJ9LjDwZrCFsWMQ5mFiD+OlRoB06g9LtAzbJGD4fpHGelCSy0zQssjC9n+z0Ae0gFzeGhEI5ROTCWdH7h3a3Sx6JXiA7dqTnku7ePz7yaRmgCYIXjnpHBjQIDAQAB",
                "RSA2");


        //获得初始化的AlipayClient

        //获取当前请求过来的地址
        String urls=request.getRequestURL().toString();
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl(urls);
        alipayRequest.setNotifyUrl(urls);//在公共参数中设置回跳和通知地址



        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+orderForm+"\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":8888," +
                "    \"subject\":\"Iphone32 160G\"," +
                "    \"body\":\"Iphone32 160G\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\""+orderForm1+"\"" +
                "    }"+
                "  }");//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
            //AlipayTradePagePayResponse responses = alipayClient.pageExecute(alipayRequest);
            //if(responses.isSuccess()){
            //    System.out.println("调用成功");
            //} else {
            //    System.out.println("调用失败");
            //}
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        //{    "out_trade_no":"4f59245f5bdf561f0f52",    "product_code":"FAST_INSTANT_TRADE_PAY",    "total_amount":8888,    "subject":"Iphone32 160G",    "body":"Iphone32 160G",    "passback_params":"merchantBizType%3d3C%26merchantBizNo%3d2016010101111",    "extend_params":{    "sys_service_provider_id":"92e7844abdd75710b6dd",    }  }
        response.setContentType("text/html;charset=" +  "UTF-8");
        response.getWriter().write(form);//直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();



    }
}
