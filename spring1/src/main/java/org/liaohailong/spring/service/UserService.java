package org.liaohailong.spring.service;

import javax.annotation.Resource;

import org.liaohailong.spring.dao.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Resource
	private UserDao userDao;
	
	@Resource
	private AOP aop;

	public void setUserDao(UserDao userDao) {
		System.out.println("setUserDao");
		this.userDao = userDao;
	}

	public void add() {
		System.out.println("ҵ���߼���");
		userDao.add();
	}
}
