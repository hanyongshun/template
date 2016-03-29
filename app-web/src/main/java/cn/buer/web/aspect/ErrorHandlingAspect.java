package cn.buer.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class ErrorHandlingAspect {
	@Pointcut("execution(* cn.buer.web.service.*.*(..))")
	private void anyMethod(){};
	@AfterThrowing(pointcut = "anyMethod()",throwing = "error")
	public void afterThrowing(JoinPoint point,Throwable error){
		System.out.println("发生异常了");
	}
}
