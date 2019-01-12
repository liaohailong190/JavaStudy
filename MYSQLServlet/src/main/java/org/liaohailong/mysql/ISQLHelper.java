package org.liaohailong.mysql;

import java.util.List;

import org.liaohailong.mysql.entity.Student;

public interface ISQLHelper {
	int add(Student student);
	
	int remove(Student student);
	
	int update(Student student);
	
	Student get(int id);
	
	List<Student> getAll();
}
