package com.zheng.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.RpcException;
import com.zheng.service.HelloService;

@Service("helloService")
public class HelloServiceImpl implements HelloService {
	@Override
	public String sayHello(String name) {
		return "hello " + name;
	}

}
