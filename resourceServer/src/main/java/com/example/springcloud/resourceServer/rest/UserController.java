package com.example.springcloud.resourceServer.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{

	/**
	* 不用鉴权接口
	* @return
	 */
	@GetMapping("hello")
	public String hello(){
		return "hello resourceServer";
	}

	/**
	* 需要鉴权接口
	* @return
	 */
	@GetMapping("getName")
	public String getName(){
		return "my name is liangjinquan";
	}
}
