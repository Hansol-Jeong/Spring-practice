package com.rubypaper.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.web.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그아웃 기능 처리");
		
		// 로그아웃을 요청한 브라우저에 해당하는 세션 객체를 강제 종료한다. 
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "login";
		
	}

}
