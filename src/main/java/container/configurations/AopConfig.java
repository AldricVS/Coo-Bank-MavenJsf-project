package container.configurations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import container.ServiceReporter;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class AopConfig {

	@Bean
	public ServiceReporter serviceReporter() {
		return new ServiceReporter();
	}

	@Before("execution(* simulation.StatisticManager.registerNonServedClient(..))")
	public void nonServedClientEntry(JoinPoint joinPoint) {
		serviceReporter().nonServedClientEntry(joinPoint);
	}

}
