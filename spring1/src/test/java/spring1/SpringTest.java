package spring1;

import org.liaohailong.spring.entity.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	public static void main(String[] args) {
		// 1,����Spring��������
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring002.xml");
		// springĬ���ǵ���(���̲߳���ȫ����)
		UserEntity userEntity = (UserEntity) context.getBean("userEntity");
		System.out.println(userEntity);

		/*
		 * SpringĬ�������������� Singleton ���� Prototype ���� Request Http����Request������ Session
		 * Http����Request������
		 */

		userEntity = (UserEntity) context.getBean("userEntity1");
		System.out.println(userEntity);
		
		userEntity = (UserEntity) context.getBean("userEntity2");
		System.out.println(userEntity);
	}
}