package com.rubypaper.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.rubypaper.biz.board.BoardDAOJDBC;
import com.rubypaper.biz.board.BoardVO;

public class UpdateBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�Խ� �� ���� ��� ó��");
		
		// 1. ����� �Է����� ����
		String title = request.getParameter("title");
		String seq = request.getParameter("seq");
		String content = request.getParameter("content");
		
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setSeq(Integer.parseInt(seq));
		vo.setContent(content);
		
		BoardDAOJDBC boardDAO = new BoardDAOJDBC();
		boardDAO.updateBoard(vo);
		
		// 3. ȭ�� �׺���̼�
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:getBoardList.do");
		return mav;
	}

}