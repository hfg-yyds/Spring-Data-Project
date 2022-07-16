package com.hacker.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Create with Intellij IDEA.
 * Description：
 * User:Zero
 * Date:2021/7/30
 * Time:23:11
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("SpringCloud")
                .apiInfo(webApiInfo())
                .select()
                //.paths(Predicates.not(PathSelectors.regex("/admin/.*")))  //如果接口包含这个路径 是不会显示的
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
        //分组   api信息
    }

    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("SpringCloud2.0学习API文档")
                .description("本文档描述了微服务接口定义")
                .version("1.0")
                .contact(new Contact("韩福贵", "http://localhost:8035//", "1841814080@qq.com"))
                .build();
    }

}
