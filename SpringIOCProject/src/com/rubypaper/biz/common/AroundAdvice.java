package com.rubypaper.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

//around는 사전처리, 사후처리를 모두 할 수 있다. (서블릿의 Filter와 동일한 개념이다. 다른점이 있다면 비지니스 메소드에 대한 사전, 사후처리다.)
@Service
@Aspect
public class AroundAdvice {
	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..)")
	public void allPointcut() {}
	@Around("allPointcut")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable{//리턴타입이 절대로 void여서는 안된다. 매개변수도 정해져있다.
		Object obj = null;
		StopWatch watch = new StopWatch();
		watch.start();
		
		obj = jp.proceed();
		
		watch.stop();
		System.out.println("비즈니스 메소드 수행에 소요된 시간" + watch.getTotalTimeMillis() + "(ms)초");
	return obj;
	}
}
