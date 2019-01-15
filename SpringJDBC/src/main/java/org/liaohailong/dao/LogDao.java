package org.liaohailong.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	//当前有事务的话，不用当前的事务，开启一个新的事务
	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void add(String tag, String content) {
		String sql = "INSERT INTO LOG(tag,content) VALUES(?,?);";
		jdbcTemplate.update(sql, tag, content);
		System.out.println("数据插入成功! tag = " + tag + "  content = " + content);
	}
}
