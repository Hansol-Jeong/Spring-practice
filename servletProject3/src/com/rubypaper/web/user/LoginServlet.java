package com.rubypaper.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

import com.rubypaper.biz.user.UserDAO;
import com.rubypaper.biz.user.UserVO;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용자 입력정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		//2. DB연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser(vo);// 자 이부분 정리들어간다 먼저vo를 통해 입력한 정보를 받았어(post 방식인거) 그 정보를  vo에 담아서
		//dao의 getUser메소드에 넣으면 해당 id와 pass가 데이터베이스에 있으면 null값이 아닌 값을 주겟지 없다면 null값을 줄거야 그러니까
	
		//3. 화면 네비게이션
		if(user != null) {
			response.sendRedirect("getBoardList.do"); //user값이 null이 아니면 글 목록으로 이동하시고
		}
		else {
			response.sendRedirect("login.html"); //응 다시 돌아가.
		}
	}

}
