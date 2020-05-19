//package com.test.springcloud.service;
//
//import java.util.List;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.test.springcloud.config.FeignClientAuthConfig;
//import com.test.springcloud.entity.TUser;
//import com.test.springcloud.service.fallback.TUserFeignFallBack;
////app-name-service-user1
//@FeignClient(name = "APP-NAME-SERVICE-USER1",
//			 configuration = FeignClientAuthConfig.class,
//			 fallbackFactory = TUserFeignFallBack.class) // 消费者 -> 服务  == 服务降级
//public interface TUserFeignService {
//	
//	@RequestMapping("/user/selectAll")
//    List<TUser> selectAll();
//}
