package org.liaohailong.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void add(String name, int age, String sex) {
		String sql = "INSERT INTO user(name,age,sex) VALUES(?,?,?);";
		jdbcTemplate.update(sql, name, age, sex);
		System.out.println("数据插入成功! name = " + name + "  age = " + age + "  sex = " + sex);
	}
}
