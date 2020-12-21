package com.rubypaper.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rubypaper.biz.board.BoardDAOJDBC;
import com.rubypaper.biz.board.BoardVO;
import com.rubypaper.web.controller.Controller;

public class UpdateBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. �궗�슜�옄 �엯�젰�젙蹂� ?��붿텧
					String title = request.getParameter("title");
					String seq = request.getParameter("seq");
					String content = request.getParameter("content");
					
					// 2. DB �뿰�룞 泥섎?��
					BoardVO vo = new BoardVO();
					vo.setTitle(title);
					vo.setSeq(Integer.parseInt(seq));
					vo.setContent(content);
					
					BoardDAOJDBC boardDAO = new BoardDAOJDBC();
					boardDAO.updateBoard(vo);
					
					// 3. �솕硫� �꽕?��꾧쾶�씠��??
				return "getBoardList.do";
	}

}
