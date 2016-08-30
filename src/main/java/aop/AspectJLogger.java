package aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectJLogger {
	
	@Before("execution(* schedule.job..*.*(..))")
	public void logBefore(){
		System.out.println("test logger before ...");
	}
	
	@After("execution(* schedule.job..*.*(..))")
	public void logAfter(){
		System.out.println("test logger after ...");
	}

}
