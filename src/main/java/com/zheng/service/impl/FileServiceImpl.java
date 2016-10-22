package com.zheng.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.zheng.domain.FileWrapper;
import com.zheng.service.FileService;

@Service("fileService")
public class FileServiceImpl implements FileService {
	@Override
	public InputStream getFileStream() {
		File file = new File("F:\\work\\spring-boot-shiro\\src\\main\\java\\com\\zheng\\config\\DruidConfig.java");
		InputStream input = null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	@Override
	public FileWrapper getFileStreams() {
		List<byte[]> streams = Lists.newArrayList();
		File file1 = new File("F:\\work\\spring-boot-shiro\\src\\main\\java\\com\\zheng\\config\\DruidConfig.java");
		File file2 = new File("F:\\work\\spring-boot-shiro\\src\\main\\java\\com\\zheng\\config\\JcaptchaConfig.java");
		FileInputStream input1 = null;
		FileInputStream input2 = null;
		try {
			
			input1 = new FileInputStream(file1);
			byte[] bytes = new byte[input1.available()];
			input1.read(bytes);
			streams.add(bytes);
			
			input2 = new FileInputStream(file2);
			byte[] bytes2 = new byte[input2.available()];
			input2.read(bytes2);
			streams.add(bytes2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		FileWrapper wrapper = new FileWrapper();
		wrapper.setInputs(streams);
		
		return wrapper;
	}
}
