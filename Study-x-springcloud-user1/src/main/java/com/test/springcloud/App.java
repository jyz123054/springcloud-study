package com.test.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.test.springcloud.dao")
@EnableEurekaClient	//向Eureka注册中心，注册user1服务
@EnableCircuitBreaker //启用断路器，支持熔断
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}
