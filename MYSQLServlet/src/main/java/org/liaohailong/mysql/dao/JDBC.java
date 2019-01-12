package org.liaohailong.mysql.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

public class JDBC {

	public static Connection conn(String ip, String port, String dbName) {
		// �����ַ
		String url = "jdbc:mysql://" + ip + ":" + port + "/" + dbName;
		String params = "?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
		url += params;
		// �������ӳ�ʼֵ
		Connection connection = null;
		try {
			// ��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			// ��������
			connection = DriverManager.getConnection(url, "root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
