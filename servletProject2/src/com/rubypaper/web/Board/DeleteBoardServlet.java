package com.rubypaper.web.Board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;

public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 세션 체크 --> 필터로 구현하기 숙제
				HttpSession session =request.getSession();
				if(session.getAttribute("userId")==null) {
					response.sendRedirect("login.html");
				} else {
		//1.사용자 입력 정보 추출
		request.setCharacterEncoding("EUC-KR");
		String seq = request.getParameter("seq");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
		//2.DB연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);

		//3.화면 네비게이션
		response.sendRedirect("getBoardList.do");
	}
	}

}
