package com.test.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignClientAuthConfig {
    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
    	//注意这里配置的是调用服务接口时的安全认证 ：账号+密码，不是eureka的认证
        return new BasicAuthRequestInterceptor("sec-admin", "sec-admin");
    }
    
    @Bean
    public Logger.Level getFeignLoggerLevel() {
        return feign.Logger.Level.FULL;
    }
}

