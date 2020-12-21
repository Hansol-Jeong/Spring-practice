package com.rubypaper.web.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.user.UserDAO;
import com.rubypaper.biz.user.UserVO;
import com.sun.net.httpserver.HttpsServer;


public class LoginServlet extends HttpServlet {
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
			//로그인 성공 시 세션에 상태정보를 저장
			//세션에 저장한 상태정보는 브라우저가 종료되기 전까지 유효하다.
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(1000000);//10초
//			session.setAttribute("userId", user.getId());//세션은 맵과 같다 userId라는 카에 user.getId()값을 저장한다.
//			session.setAttribute("userName", user.getName());
//			session.setAttribute("userRole", user.getRole());
			session.setAttribute("user", user);
			//로그인 성공한 경우, 브라우저에서 성공 베시지 전송
//			response.setContentType("text/html; charset=EUC-KR");// 출력스트림 out얻기 전에 인코딩 해줘야 의미가 있다.
//			PrintWriter out = response.getWriter();
//			System.out.println(user.getName() + "님 로그인 성공(Sever Console)");
//			out.println("<h1>" + user.getName() + "님 로그인 성공(Browser)</h1>");
//			out.println("<h1><a href='getBoardList.do'>글 목록 화면으로 이동</h1>");
//			out.println("<h1><a href='insertBoard.html'>글 등록 화면으로 이동</h1>");
			
			//로그인 성공한 경우 글목록으로 바로이동
			response.sendRedirect("getBoardList.do");
		} else {
			//로그인 실패한 경우 , 다시 로그인 화면으로 이동
			response.sendRedirect("login.html");
		}
	}
}
