package com.example.springcloud.dubboprovider.remote;

import java.util.concurrent.CompletableFuture;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.springcloud.dubboremote.remote.IUserRemote;

@Service(group = "user1", version = "1.0.2", token = "true")
public class User2RemoteImpl implements IUserRemote{

	@Override
	public String getName() {
		System.out.println("开启调用");
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "my name is xiaobu 2";
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

			return "执行完毕";
		});
	}

}
