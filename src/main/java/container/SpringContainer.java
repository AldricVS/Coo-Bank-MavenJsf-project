package container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import container.configurations.AopConfig;
import container.configurations.ClientConfiguration;
import container.configurations.SimulationConfiguration;

public class SpringContainer {
	private static final ApplicationContext context = new AnnotationConfigApplicationContext(
			AopConfig.class,
			SimulationConfiguration.class,
			ClientConfiguration.class);

	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

	public static <T> T getBean(Class<T> type) {
		return context.getBean(type);
	}
}
