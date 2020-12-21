package com.rubypaper.web.Board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;

public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String encoding;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 글로벌 파라미터 정보 추출
		ServletContext context = getServletContext();
		encoding = context.getInitParameter("boardEncoding");
		request.setCharacterEncoding(encoding);
		
		String seq = request.getParameter("seq");
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(vo);
		
		response.sendRedirect("getBoardList.do");
	}

}
