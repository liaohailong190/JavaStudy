import org.liaohailong.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService = (UserService) context.getBean("userService");
		userService.add();
		System.out.println("main≈‹ÕÍ¡À");
	}
}
