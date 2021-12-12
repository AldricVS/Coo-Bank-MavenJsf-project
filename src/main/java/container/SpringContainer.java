package container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContainer {
	private static final ApplicationContext context = new ClassPathXmlApplicationContext("container/spring.xml");
	
	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

}
