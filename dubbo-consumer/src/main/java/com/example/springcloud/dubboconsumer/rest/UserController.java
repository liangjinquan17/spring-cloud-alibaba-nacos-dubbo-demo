package com.example.springcloud.dubboconsumer.rest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.springcloud.dubboremote.remote.IUserRemote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	/**
	 * 快速失败，只调用一次
	 * 轮训模式
	 * */
	// @Reference( retries = 1, cluster = "failsafe", loadbalance = "leastactive", registry={"z1"} )
	// private IUserRemote userRemote;

	@GetMapping("hello")
	public String hello() {
		return "hello dubboconsumer";
	}

	@GetMapping("getName")
	public String getName(){
		// return "dubbo name:"+userRemote.getName();
		return null;
	}
}
