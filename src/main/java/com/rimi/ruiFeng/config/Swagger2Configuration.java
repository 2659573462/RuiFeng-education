package com.rimi.ruiFeng.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * EnableSwagger2:接口文档要使用的注解
 * @author chenjin
 * @date 2019/11/2 16:11
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    //http://localhost:8080/swagger-ui.html
    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo(){
        return new ApiInfo(
                "睿峰在线教育管理系统API文档" // 标题
                , "" // 描述信息
                , "1.0" // 版本信息z
                , " 10.2.3.182:8008/" // 服务地址
                , "shangzf"
                , "" // 签名
                , "" // 签名链接
        );
    }
}
