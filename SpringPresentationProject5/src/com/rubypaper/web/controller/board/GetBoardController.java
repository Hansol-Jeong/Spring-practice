package com.rubypaper.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.rubypaper.biz.board.BoardDAOJDBC;
import com.rubypaper.biz.board.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("게시 글 상세 조회 기능 처리");			

		// 1. 사용자 입력정보 추출
		String seq = request.getParameter("seq");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAOJDBC boardDAO = new BoardDAOJDBC();
		BoardVO board = boardDAO.getBoard(vo);
		
		// 3. 검색 결과를 화면(JSP)에서 사용할 수 있도록 세션에 등록한다.
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		// 글 상세 화면(getBoard.jsp)으로 이동한다.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoard");
		return mav;
		
	}

}
