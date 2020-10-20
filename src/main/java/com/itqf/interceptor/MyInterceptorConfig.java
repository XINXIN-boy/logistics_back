package com.itqf.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/1011:27
 * description:
 */

@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/*.html")
                .excludePathPatterns("/login.html");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}