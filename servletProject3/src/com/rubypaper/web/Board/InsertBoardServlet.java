package com.rubypaper.web.Board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;

public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String encoding;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 글로벌 파라미터 정보 추출
		ServletContext context = getServletContext();
		encoding = context.getInitParameter("boardEncoding");
		
		//1.사용자 입력정보 추출
		request.setCharacterEncoding(encoding);
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		vo.setContent(request.getParameter("content"));
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
		
		//3.화면 네비게이션
		response.sendRedirect("getBoardList.do");
		
	}

}
