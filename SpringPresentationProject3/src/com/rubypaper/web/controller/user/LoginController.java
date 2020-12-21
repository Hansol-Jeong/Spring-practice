package com.rubypaper.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.rubypaper.biz.user.UserDAOJDBC;
import com.rubypaper.biz.user.UserVO;


public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			// 로그인 성공 시, 세션에 상태정보를 저장한다.
			HttpSession session = request.getSession();
			session.setAttribute("user", user);		
			//forward: 이나 redirect:을 뷰이름 앞에 붙이면 ViewResolver를 무시한다. 
			mav.setViewName("forward:getBoardList.do");
		} else {
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}

}
