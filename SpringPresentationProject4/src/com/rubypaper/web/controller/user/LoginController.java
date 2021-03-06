package com.rubypaper.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.user.UserDAOJDBC;
import com.rubypaper.biz.user.UserVO;
import com.rubypaper.web.controller.Controller;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 기능 처리");
		
		// 1. 사용자 입력정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO(); 
		vo.setId(id);             
		vo.setPassword(password);
		
		UserDAOJDBC userDAO = new UserDAOJDBC();
		UserVO user = userDAO.getUser(vo);
		
		// 3. 화면 네비게이션
		if(user != null) {
			// 로그인 성공 시, 세션에 상태정보를 저장한다.
			HttpSession session = request.getSession();
			session.setAttribute("user", user);		
			return "getBoardList.do";
		} else {
			return "login";
		}
	}

}
