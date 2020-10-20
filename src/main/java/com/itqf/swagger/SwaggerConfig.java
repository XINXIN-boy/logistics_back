package com.itqf.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/517:12
 * description:
 */
@Configuration
@EnableSwagger2//开启Swagger2
public class SwaggerConfig {

    //配置Swagger的Bean实例
    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }


    //配置API的基本信息（会在http://项目实际地址/swagger-ui.html页面显示）
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试API文档标题")
                .description("测试api接口文档描述")
                .termsOfServiceUrl("http://www.baidu.com")
                .version("1.0")
                .build();
    }
}
