package com.example.springcloud.nacosConfig.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class UserController{

	@Value("${user.name}")
	private String name;

	@Value("${age:30}")
	private Integer age;
	
	@GetMapping("hello")
	public String hello(){
		return "hello nacos config ";
	}

	@GetMapping("getName")
	public String getName(){
		return "nacos config name:"+name+"  age:"+age;
	}
}
