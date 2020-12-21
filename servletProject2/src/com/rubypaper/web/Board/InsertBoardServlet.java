package com.rubypaper.web.Board;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;


public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private String encoding;
	
//	@Override
//	public void init(ServletConfig config) throws ServletException {//엔진이 서블릿 컨피그객체를 생성해서 로컬파라미터 정보를 세팅한다. 그러고 전달한다.
//		// web.xml에 설정된 로컬 파라미터 정보 추출
//		encoding = config.getInitParameter("boardEncoding");
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 글로벌 파라미터 정보 추출
//		ServletContext context = getServletContext();//부모로부터 상속된 메소드
//		encoding = context.getInitParameter("boardEncoding");//서블릿 컨텍스트는 글로벌 파라미터
//		
//		//1.사용자 입력 정보 추출
//		request.setCharacterEncoding(encoding);
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		//2.DB연동 처리
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);

		//3.화면 네비게이션
		response.sendRedirect("getBoardList.do");
	}

}
