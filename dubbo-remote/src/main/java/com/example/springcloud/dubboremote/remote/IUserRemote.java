package com.example.springcloud.dubboremote.remote;

import java.util.concurrent.CompletableFuture;

public interface IUserRemote{
	public String getName();

	public CompletableFuture<String> getNameById(Long id);
}
