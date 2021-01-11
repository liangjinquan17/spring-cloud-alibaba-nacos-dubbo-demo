package com.example.springcloud.dubboprovider.remote;

import java.util.Date;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.springcloud.dubboremote.remote.IUserRemote;

@Service
public class UserRemoteImpl implements IUserRemote{

	@Override
	public String getName() {
		System.out.println("new Date:"+new Date());
		// TODO Auto-generated method stub
		return "my name is liangjinquan";
	}

}
