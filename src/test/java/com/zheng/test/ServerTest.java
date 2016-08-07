package com.zheng.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerTest {

	@Test
	@SuppressWarnings("resource")
	public void startServer() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		ctx.start();
		System.out.println("服务启动成功!");
		System.in.read();
	}
}
