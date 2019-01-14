package spring1;

import org.liaohailong.spring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringServiceTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("spring005.xml");
		UserService userService = (UserService) context.getBean("userService");
		userService.add();
	}
}