package com.test.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.springcloud.service.TUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private TUserService tUserService;
	
	@RequestMapping(value="/queryAll", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "queryAllFallback")
	public Object queryAll() {
//		if (5/3 >0) {
//			throw new NullPointerException();
//		}
//		List<TUser> selectAll = tUserService.selectAll();
		return tUserService.selectAll();
	}
	
	//熔断：这是在服务提供方的熔断操作，
	//降级：但是如果由于网络原因，服务的消费方并不能调用到服务接口时，也应该进行降级处理。
	public Object queryAllFallback() {
		return "selectAllFallback!!!";
	}
	
	@RequestMapping(value="/selectById/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "selectByIdFallback")
	public Object selectById(@PathVariable("id") Integer id) {
		return tUserService.selectByPrimaryKey(id);
	}
	
	public Object selectByIdFallback(Integer id) {
		return "selectByIdFallback!!! "+id;
	}
	
	public Object test(Integer id) {
		return "selectByIdFallback!!! "+id;
	}
}
