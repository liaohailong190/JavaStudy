package org.liaohailong.dao;

import java.util.List;

public interface BaseDao<T> {
	int insert(T videoInfo);

	int delete(int id);

	int update(T videoInfo);
	
	T select(int id);

	List<T> selectAll();
}
