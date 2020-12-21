package com.rubypaper.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

// around�� ����ó���� ����ó���� ��� �� �� �ִ�. (������  Filter�� ������ ����)
@Service
@Aspect
public class AroundAdvice {
	
//	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..))")
//	public void allPointcut() {}

	@Around("BoardPointcut.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {// JoinPoint�� �ڽ�. �ٵ� Around�ܿ��� ���� ��������.
		Object obj = null;
		StopWatch watch = new StopWatch();
		watch.start();
		
		obj = jp.proceed();
		
		watch.stop();
		String method = jp.getSignature().getName();// Ŭ���̾�Ʈ�� ȣ���� �޼ҵ� �̸�
		System.out.println(method + "() �޼ҵ� ���࿡ �ҿ�� �ð� : "
			+ watch.getTotalTimeMillis() + "(ms)��");
		return obj;
	}
}
