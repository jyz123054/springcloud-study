package com.test.springcloud.service.fallback;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.test.springcloud.entity.TUser;
import com.test.springcloud.service.TUserZuulService;

import feign.hystrix.FallbackFactory;

@Component
public class IZuulTUserFallBack implements FallbackFactory<TUserZuulService> {
	@Override
	public TUserZuulService create(Throwable cause) {
		return new TUserZuulService() {
			
			@Override
			public List<TUser> selectAll() {
				return new ArrayList<TUser>();
			}

			@Override
			public TUser selectById(Integer id) {
				TUser err = new TUser();
				err.setUserName("error");
				return err;
			}
			
		};
	}
}
