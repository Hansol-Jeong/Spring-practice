package com.rubypaper.biz.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.rubypaper.biz.user.UserVO;
@Service
@Aspect
public class AfterReturningAdvice {
//	@Pointcut("execution(* com.rubypaper.biz..*Impl.get*(..))")//get�����ָ� get������ ���������� get�ƴѰſ��� ���ϰ��� ��� returning���� null�� �ȴ�.
//	public void getPointcut() {}
	
	@AfterReturning(pointcut="BoardPointcut.getPointcut()", returning="returnObj")
	public void afterLog(Object returnObj) {
		System.out.println("[ ���� ó�� ] ����Ͻ� �޼ҵ� ���� �� : " + returnObj.toString());
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("ADMIN")) {
				System.out.println(user.getName() + "���� ������ ȭ������ �ٷ� �̵�.....");
			}
		}
	}
}
