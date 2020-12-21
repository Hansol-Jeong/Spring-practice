package com.rubypaper.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service//컨테이너야 이거 생성해
@Aspect // Aspect = Pointcut + Advice, 컨테이너야 이거 어스펙트야
public class LogAdvice {
	
//	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..))")
//	public void allPointcut() {}

	@Before("BoardPointcut.allPointcut()")
	public void printLog(JoinPoint jp) {//이 메소드는 스프링 컨테이너가 생성한다. 서블릿엔진이 req 세팅다해서 넘겨주는 것처럼 jp다 세팅해서 스프링컨테이너가 넘겨준다.
		String method = jp.getSignature().getName();// 클라이언트가 호출한 메소드 이름
		Object[] args = jp.getArgs();               // 클라이언트가 전달한 인자 정보
		
		System.out.println("[ 사전 처리 ] " + method + "() 메소드 ARGS 정보:" + args[0].toString());
	}
}
