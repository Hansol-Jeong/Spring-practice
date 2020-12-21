package com.rubypaper.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect//Aspect = Pointcut + Advice
public class LogAdvice {
	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..)")
	public void allPointcut() {}//어떤 기능을 수행하는 것이 목적이 아니고 , 구분을 하기 위해서, 마치 식별자 목적으로 하는 것이 참조형 메소드
	@Before("allPointcut()")
	public void printLog() {
		System.out.println("[ 사전 처리 ] 비즈니스 로직 수행 전 동작");
	}
}
