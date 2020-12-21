package com.rubypaper.biz.common;

import java.sql.SQLException;

import com.rubypaper.biz.user.UserVO;

public class AfterThrowingAdvice {
	public void exceptionLog(Exception exceptionObj) {//��� ������ �ֻ��� �θ�
		System.out.println("[ ���� ó�� ] ����Ͻ� �޼ҵ� ���� �� ���� �߻�");
		
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("0�� �Խ� ���� ����� ���� �����ϴ�.");
		} else if (exceptionObj instanceof ArithmeticException) {
			System.out.println("0���� ���ڸ� ���� �� �����ϴ�.");
		} else if(exceptionObj instanceof SQLException) {
			System.out.println("SQL ������ ������ �ֽ��ϴ�.");
		} else {
			System.out.println("�����߻�!! ��� �ý����� �����մϴ�.");
		}
		
	}
}
