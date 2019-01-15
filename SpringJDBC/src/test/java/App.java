import org.liaohailong.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService = (UserService) context.getBean("userService");
//		userService.add();
		userService.addLog();
		System.out.println("main≈‹ÕÍ¡À");
	}
}
