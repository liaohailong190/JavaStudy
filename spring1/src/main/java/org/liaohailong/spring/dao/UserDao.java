package org.liaohailong.spring.dao;

import org.springframework.stereotype.Repository;

@Repository // 注入标识 类名小写，作为bean的id
public class UserDao {
	private boolean flag = false;

	public void setFlag(boolean flag) {
		System.out.println("setFlag flag = " + flag);
		this.flag = flag;
	}

	public void add() {
		//int i = 1 / 0;
		System.out.println("DAO层 flag = " + flag);
	}
}
