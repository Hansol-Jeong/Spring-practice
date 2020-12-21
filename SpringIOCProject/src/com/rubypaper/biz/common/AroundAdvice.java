package com.rubypaper.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

//around�� ����ó��, ����ó���� ��� �� �� �ִ�. (������ Filter�� ������ �����̴�. �ٸ����� �ִٸ� �����Ͻ� �޼ҵ忡 ���� ����, ����ó����.)
@Service
@Aspect
public class AroundAdvice {
	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..)")
	public void allPointcut() {}
	@Around("allPointcut")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable{//����Ÿ���� ����� void������ �ȵȴ�. �Ű������� �������ִ�.
		Object obj = null;
		StopWatch watch = new StopWatch();
		watch.start();
		
		obj = jp.proceed();
		
		watch.stop();
		System.out.println("����Ͻ� �޼ҵ� ���࿡ �ҿ�� �ð�" + watch.getTotalTimeMillis() + "(ms)��");
	return obj;
	}
}
