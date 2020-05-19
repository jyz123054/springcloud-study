package com.test.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient	//因为要去eureka拉取服务
@EnableFeignClients("com.test.springcloud.service")	//指向Feign接口层
public class FeignApp {
    public static void main( String[] args ) {
    	SpringApplication.run(FeignApp.class,args);
    }
}
