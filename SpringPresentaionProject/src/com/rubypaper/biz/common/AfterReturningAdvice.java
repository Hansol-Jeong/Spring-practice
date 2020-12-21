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
//	@Pointcut("execution(* com.rubypaper.biz..*Impl.get*(..))")//get안해주면 get에서는 문제없지만 get아닌거에서 리턴값이 없어서 returning값이 null이 된다.
//	public void getPointcut() {}
	
	@AfterReturning(pointcut="BoardPointcut.getPointcut()", returning="returnObj")
	public void afterLog(Object returnObj) {
		System.out.println("[ 사후 처리 ] 비즈니스 메소드 리턴 값 : " + returnObj.toString());
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("ADMIN")) {
				System.out.println(user.getName() + "님은 관리자 화면으로 바로 이동.....");
			}
		}
	}
}
