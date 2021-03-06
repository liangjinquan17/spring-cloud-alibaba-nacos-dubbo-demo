package com.example.springcloud.dubboprovider.remote;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.springcloud.dubboremote.remote.IUserRemote;

@Service(group = "user", version = "1.0.1", token = "true")
public class UserRemoteImpl implements IUserRemote{

	@Override
	public String getName() {
		System.out.println("new Date:"+new Date());
		// TODO Auto-generated method stub
		return "my name is liangjinquan 1";
	}

	@Override
	public CompletableFuture<String> getNameById(Long arg0) {
		// TODO Auto-generated method stub
		return CompletableFuture.supplyAsync(() ->{
			System.out.println("异步执行");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "异步执行完毕";
		});
	}

}
