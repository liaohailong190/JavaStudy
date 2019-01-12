package org.liaohailong.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import org.liaohailong.mysql.dao.JDBC;
import org.liaohailong.mysql.entity.Student;

public class SQLHelper implements ISQLHelper {
	private static final String IP = "127.0.0.1";
	private static final String PORT = "3306";
	private static final String DBNAME = "victor";

	private Connection conn = null;
	private PreparedStatement ps;
	private ResultSet rs = null;

	public int add(Student student) {
		int reuslt = 0;
		try {
			conn = JDBC.conn(IP, PORT, DBNAME);
			String sql = "INSERT INTO student(id,name,age,country) VALUES(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, student.id);
			ps.setString(2, student.name);
			ps.setInt(3, student.age);
			ps.setString(4, student.country);
			reuslt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			reuslt = 0;
		}
		return reuslt;
	}

	public int remove(Student student) {
		int reuslt = 0;
		try {
			conn = JDBC.conn(IP, PORT, DBNAME);
			String sql = "DELETE FROM student WHERE id=" + student.id;
			ps = conn.prepareStatement(sql);
			reuslt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			reuslt = 0;
		}
		return reuslt;
	}

	public int update(Student student) {
		int reuslt = 0;
		try {
			conn = JDBC.conn(IP, PORT, DBNAME);
			String sql = "UPDATE student SET name=?,age=?,country=? WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.name);
			ps.setInt(2, student.age);
			ps.setString(3, student.country);
			ps.setInt(4, student.id);
			reuslt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			reuslt = 0;
		}
		return reuslt;
	}

	public Student get(int id) {
		Student result = new Student();
		try {
			conn = JDBC.conn(IP, PORT, DBNAME);
			String sql = "SELECT * FROM student WHERE id=" + id;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				result.id = rs.getInt("id");
				result.name = rs.getString("name");
				result.age = rs.getInt("age");
				result.country = rs.getString("country");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Student> getAll() {
		List<Student> result = new LinkedList<Student>();
		try {
			conn = JDBC.conn(IP, PORT, DBNAME);
			String sql = "SELECT * FROM student";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.id = rs.getInt("id");
				student.name = rs.getString("name");
				student.age = rs.getInt("age");
				student.country = rs.getString("country");
				result.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}