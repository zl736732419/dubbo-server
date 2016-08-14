package com.zheng.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerTest {
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		ctx.start();
		System.out.println("服务启动成功!");
		System.in.read();
	}
}
