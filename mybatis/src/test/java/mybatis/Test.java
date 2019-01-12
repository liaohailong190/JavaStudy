package mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.liaohailong.mybatis.User;

public class Test {
	public static void main(String[] args) {
		String resource = "mybatis.xml";
		Reader resourceAsReader;
		try {
			resourceAsReader = Resources.getResourceAsReader(resource);
			// session �Ự����
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
			// ��ȡ�Ự
			SqlSession openSession = sqlSessionFactory.openSession();
			// ����
			User user = new User();
			user.setName("�����Ĳ����");
			user.setAge(101);
			user.setSex("��");
			add(openSession, user);
			findAll(openSession);
			
			// �رջỰ���ͷ���Դ
			openSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void find(SqlSession openSession, int id) {
		String statement = "org.liaohailong.mybatis.UserMapper.getUser";
		User user = openSession.selectOne(statement, 1);
		System.out.println(user.toString());
	}

	private static void findAll(SqlSession openSession) {
		String statement = "org.liaohailong.mybatis.UserMapper.getAllUser";
		List<User> allUsers = openSession.selectList(statement);
		for (User user : allUsers) {
			System.out.println(user.toString());
		}
	}

	private static void add(SqlSession openSession, User user) {
		String statement = "org.liaohailong.mybatis.UserMapper.addUser";
		openSession.insert(statement, user);
	}
}