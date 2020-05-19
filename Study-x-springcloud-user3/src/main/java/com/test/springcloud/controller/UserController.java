package com.test.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.springcloud.entity.TUser;
import com.test.springcloud.service.TUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private TUserService tUserService;
	
	@ResponseBody
	@RequestMapping(value="/selectAll", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "selectAllFallback")
	public Object selectAll() {
//		if (5/3 >0) {
//			throw new NullPointerException();
//		}
//		List<TUser> selectAll = tUserService.selectAll();
		return tUserService.selectAll();
	}
	//熔断：这是在服务提供方的熔断操作，
	//降级：但是如果由于网络原因，服务的消费方并不能调用到服务接口时，也应该进行降级处理。
	public Object selectAllFallback() {
		return "selectAllFallback!!!";
	}
}
