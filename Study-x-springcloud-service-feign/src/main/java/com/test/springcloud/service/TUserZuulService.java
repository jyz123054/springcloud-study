package com.test.springcloud.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.springcloud.config.FeignClientAuthConfig;
import com.test.springcloud.entity.TUser;
import com.test.springcloud.service.fallback.IZuulTUserFallBack;

@FeignClient(name = "app-name-zuul-gateway1",
			 configuration = FeignClientAuthConfig.class,
			 fallbackFactory = IZuulTUserFallBack.class)
public interface TUserZuulService {
	@RequestMapping(value="/jyz/user1-proxy/user/queryAll", method = RequestMethod.GET)
	public List<TUser> selectAll();
	
	@RequestMapping(value="/jyz/user1-proxy/user/selectById/{id}", method = RequestMethod.GET)
	public TUser selectById(@PathVariable("id") Integer id);
}
