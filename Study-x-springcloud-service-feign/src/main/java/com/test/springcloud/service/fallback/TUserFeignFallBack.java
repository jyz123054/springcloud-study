//package com.test.springcloud.service.fallback;
//
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import com.test.springcloud.entity.TUser;
//import com.test.springcloud.service.TUserFeignService;
//
//import feign.hystrix.FallbackFactory;
//
//@Component
//public class TUserFeignFallBack implements FallbackFactory<TUserFeignService>{
//
//	@Override
//	public TUserFeignService create(Throwable cause) {
//		return new TUserFeignService() {
//			
//			@Override
//			public List<TUser> selectAll() {
//				return null;
//			}
//		};
//	}
//}
