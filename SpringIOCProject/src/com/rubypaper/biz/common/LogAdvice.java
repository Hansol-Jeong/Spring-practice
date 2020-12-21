package com.rubypaper.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect//Aspect = Pointcut + Advice
public class LogAdvice {
	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..)")
	public void allPointcut() {}//� ����� �����ϴ� ���� ������ �ƴϰ� , ������ �ϱ� ���ؼ�, ��ġ �ĺ��� �������� �ϴ� ���� ������ �޼ҵ�
	@Before("allPointcut()")
	public void printLog() {
		System.out.println("[ ���� ó�� ] ����Ͻ� ���� ���� �� ����");
	}
}
