package com.rubypaper.web.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rubypaper.biz.user.UserDAO;
import com.rubypaper.biz.user.UserVO;


public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용자 입력정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. DB연동 처리(by DAO, VO)
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		//3.화면 네비게이션
		if(user != null) {
			//로그인 성공한 경우, 브라우저에서 성공 베시지 전송
			response.setContentType("text/html; charset=EUC-KR");
			PrintWriter out = response.getWriter();
			System.out.println(user.getName() + "님 로그인 성공(Sever Console)");
			out.println("<h1>"+user.getName() + "님 로그인 성공(Browser</h1>");
		} else {
			//로그인 실패한 경우 , 다시 로그인 화면으로 이동
			response.sendRedirect("login.html");
		}
	}

}
