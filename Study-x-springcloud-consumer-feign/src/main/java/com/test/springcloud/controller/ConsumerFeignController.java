package com.test.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springcloud.service.TUserZuulService;

@RestController
@RequestMapping("/consumer")
public class ConsumerFeignController {
//	@Autowired
//	private TUserFeignService tUserFeignService;
	
	@Autowired
    private TUserZuulService tUserZuulService;
	
	@RequestMapping("/user/selectAll")
    public Object selectAll() {
		//非zuul路由模式
//		List<TUser> selectAll = tUserFeignService.selectAll();
//		System.out.println(selectAll);
		
		//zuul路由模式
		return tUserZuulService.selectAll();
    }
	
	@RequestMapping("/user/selectById/{id}")
    public Object selectById(@PathVariable("id") Integer id) {
		return tUserZuulService.selectById(id);
    }
	
}
