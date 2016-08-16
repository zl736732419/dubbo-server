package com.zheng.service.impl;

import org.springframework.stereotype.Service;

import com.zheng.domain.Person;
import com.zheng.service.ValidationService;

@Service("validationService")
public class ValidationServiceImpl implements ValidationService {

	@Override
	public String descs(Person person) {
		return person.toString();
	}

	@Override
	public void delete(int id) {
		System.out.println("执行删除操作...");
		System.out.println(id);
		System.out.println("删除成功!");
	}

}
