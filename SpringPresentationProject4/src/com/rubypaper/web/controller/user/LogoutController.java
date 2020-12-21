package com.rubypaper.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.web.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α׾ƿ� ��� ó��");
		
		// �α׾ƿ��� ��û�� �������� �ش��ϴ� ���� ��ü�� ���� �����Ѵ�. 
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "login";
		
	}

}
