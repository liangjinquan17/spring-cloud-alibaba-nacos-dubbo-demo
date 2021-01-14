package com.example.springcloud.gateway.rest;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController{

	@GetMapping("/hello")
	public String hello(){
		return "hello gateway"+ new Date();
	}
}
