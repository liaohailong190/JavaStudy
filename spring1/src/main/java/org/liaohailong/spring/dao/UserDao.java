package org.liaohailong.spring.dao;

import org.springframework.stereotype.Repository;

@Repository // ע���ʶ ����Сд����Ϊbean��id
public class UserDao {
	private boolean flag = false;

	public void setFlag(boolean flag) {
		System.out.println("setFlag flag = " + flag);
		this.flag = flag;
	}

	public void add() {
		//int i = 1 / 0;
		System.out.println("DAO�� flag = " + flag);
	}
}
