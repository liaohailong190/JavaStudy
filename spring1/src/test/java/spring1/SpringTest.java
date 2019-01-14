package spring1;

import org.liaohailong.spring.entity.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	public static void main(String[] args) {
		// 1,加载Spring加载容器
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring002.xml");
		// spring默认是单例(多线程不安全问题)
		UserEntity userEntity = (UserEntity) context.getBean("userEntity");
		System.out.println(userEntity);

		/*
		 * Spring默认四种生命周期 Singleton 单例 Prototype 多例 Request Http请求Request作用域 Session
		 * Http请求Request作用域
		 */

		userEntity = (UserEntity) context.getBean("userEntity1");
		System.out.println(userEntity);
		
		userEntity = (UserEntity) context.getBean("userEntity2");
		System.out.println(userEntity);
	}
}
