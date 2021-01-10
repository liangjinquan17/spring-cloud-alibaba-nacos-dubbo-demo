package com.example.springcloud.dubboprovider.remote;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.springcloud.dubboremote.remote.IUserRemote;

@Service
public class UserRemoteImpl implements IUserRemote{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "my name is liangjinquan";
	}

}
