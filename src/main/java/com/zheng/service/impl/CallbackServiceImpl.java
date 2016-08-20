package com.zheng.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zheng.service.CallbackListener;
import com.zheng.service.CallbackService;

/**
 * 服务端参数回调实现
 * 借用观察者模式
 * @author zhenglian
 *
 */
@Service("callbackService")
public class CallbackServiceImpl implements CallbackService {
	private final Map<String, CallbackListener> listeners = new HashMap<>();

	public CallbackServiceImpl() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					for(Map.Entry<String, CallbackListener> entry : listeners.entrySet()) {
						entry.getValue().changed(changed(entry.getKey()));
					}
					
					try {
						Thread.sleep(5000); 
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		thread.setDaemon(true);
		thread.start();
	}
	
	@Override
	public void addListener(String key, CallbackListener listener) {
		listeners.put(key, listener);
		listener.changed(changed(key));
	}
	
	private String changed(String key) {
		return "Changed: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
}
