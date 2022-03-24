package com.hejj.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//是否开启swagger，正式环境一般是需要关闭的（避免不必要的漏洞暴露！），可根据springboot的多环境配置进行设置
@ConditionalOnProperty(prefix = "swagger",name = "enable",  havingValue = "true")
public class Swagger2 {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hejj.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("hejj用户接口文档")
                // 创建人信息
                .contact(new Contact("hejj",  "",  "33@11.com"))
                // 版本号
                .version("1.0")
                // 描述
                .description("API 描述a")
                .build();
    }
}
