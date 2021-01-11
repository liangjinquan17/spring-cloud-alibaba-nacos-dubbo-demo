package com.example.springcloud.dubboconsumer.rest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.springcloud.dubboremote.remote.IUserRemote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Reference
	private IUserRemote userRemote;

	@GetMapping("hello")
	public String hello() {
		return "hello dubboconsumer";
	}

	@GetMapping("getName")
	public String getName(){
		return "dubbo name:"+userRemote.getName();
	}
}
