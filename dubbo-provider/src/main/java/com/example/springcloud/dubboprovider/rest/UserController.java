package com.example.springcloud.dubboprovider.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{
	
	@GetMapping("hello")
	public String hello(){
		return "hello dubbo provider";
	}

}
