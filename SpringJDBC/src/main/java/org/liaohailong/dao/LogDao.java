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

	//��ǰ������Ļ������õ�ǰ�����񣬿���һ���µ�����
	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void add(String tag, String content) {
		String sql = "INSERT INTO LOG(tag,content) VALUES(?,?);";
		jdbcTemplate.update(sql, tag, content);
		System.out.println("���ݲ���ɹ�! tag = " + tag + "  content = " + content);
	}
}
