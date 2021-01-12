package com.example.springcloud.dubboconsumer.rest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.springcloud.dubboremote.remote.IUserRemote;

import org.apache.dubbo.config.annotation.Method;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class UserController {

	/**
	 * 快速失败，只调用一次
	 * 轮训模式
	 * */
	@Reference( retries = 1, cluster = "failsafe", loadbalance = "leastactive", group = "user1", version = "1.0.2", timeout = 5000)
	// @Method( name = "getNameById", async = true, onreturn = "神烦" )
	private IUserRemote userRemote;

	@GetMapping("hello")
	public String hello() {
		return "hello dubboconsumer";
	}

	@GetMapping("getName")
	public String getName(){
		CompletableFuture<String> future = userRemote.getNameById(1l);
		future.whenComplete((v,t) ->{
			if( t != null){
				System.out.println("v:"+v+"  t:"+t);
			}else{
				System.out.println("2:v:"+v+"  t:"+t);
			}
		});
		return "dubbo name:";
	}
}
