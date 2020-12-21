package com.rubypaper.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service//�����̳ʾ� �̰� ������
@Aspect // Aspect = Pointcut + Advice, �����̳ʾ� �̰� ���Ʈ��
public class LogAdvice {
	
//	@Pointcut("execution(* com.rubypaper.biz..*Impl.*(..))")
//	public void allPointcut() {}

	@Before("BoardPointcut.allPointcut()")
	public void printLog(JoinPoint jp) {//�� �޼ҵ�� ������ �����̳ʰ� �����Ѵ�. ���������� req ���ô��ؼ� �Ѱ��ִ� ��ó�� jp�� �����ؼ� �����������̳ʰ� �Ѱ��ش�.
		String method = jp.getSignature().getName();// Ŭ���̾�Ʈ�� ȣ���� �޼ҵ� �̸�
		Object[] args = jp.getArgs();               // Ŭ���̾�Ʈ�� ������ ���� ����
		
		System.out.println("[ ���� ó�� ] " + method + "() �޼ҵ� ARGS ����:" + args[0].toString());
	}
}
