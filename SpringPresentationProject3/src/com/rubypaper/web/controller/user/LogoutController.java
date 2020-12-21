package com.rubypaper.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α׾ƿ� ��� ó��");
		
		// �α׾ƿ��� ��û�� �������� �ش��ϴ� ���� ��ü�� ���� �����Ѵ�. 
		HttpSession session = request.getSession();
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:login.jsp");
		return mav;
		
	}

}
