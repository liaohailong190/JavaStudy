import java.util.List;

import org.liaohailong.mysql.ISQLHelper;
import org.liaohailong.mysql.SQLHelper;
import org.liaohailong.mysql.entity.Student;

public class SQLTest {
	public static void main(String[] args) {
		ISQLHelper sqlHelper = new SQLHelper();
		queryAll(sqlHelper);
		add(sqlHelper);
		queryAll(sqlHelper);
	}

	private static List<Student> queryAll(ISQLHelper sqlHelper) {
		List<Student> all = sqlHelper.getAll();
		for (Student student : all) {
			System.out.println("result = " + student.toString());
		}
		System.out.println("****************************华丽的分割线****************************");
		return all;
	}
	
	
	private static int add(ISQLHelper sqlHelper) {
		Student student = new Student();
		student.id = 6;
		student.name = "PengYuYan";
		student.age = 1;
		student.country = "TaiWan";
		return sqlHelper.add(student);
	} 
}
