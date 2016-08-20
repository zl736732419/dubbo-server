package com.zheng.service.impl;

import org.springframework.stereotype.Service;

import com.zheng.domain.Person;
import com.zheng.service.EventService;

@Service("eventService")
public class EventServiceImpl implements EventService {

	@Override
	public Person get(String username, int age) {
		return new Person(username, age);
	}
}
