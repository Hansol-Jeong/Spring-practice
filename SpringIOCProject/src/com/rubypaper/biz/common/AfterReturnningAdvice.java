package com.rubypaper.biz.common;

import com.rubypaper.biz.user.UserVO;

public class AfterReturnningAdvice {
	public void afterLog(Object returnObj) {
		System.out.println("[ ���� ó�� ] ����Ͻ� �޼ҵ� ���ϰ�:" + returnObj.toString());
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("ADMIN"))
				System.out.println(user.getName() + "���� ������ ȭ������ �ٷ��̵�^^");
		}
	}
}
