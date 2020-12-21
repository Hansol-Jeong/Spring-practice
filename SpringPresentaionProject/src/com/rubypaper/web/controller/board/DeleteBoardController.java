package com.rubypaper.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.board.BoardDAOJDBC;
import com.rubypaper.biz.board.BoardVO;
import com.rubypaper.web.controller.Controller;

public class DeleteBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. �궗�슜�옄 �엯�젰�젙蹂� ?��붿텧
					String seq = request.getParameter("seq");
					
					// 2. DB �뿰�룞 泥섎?��
					BoardVO vo = new BoardVO();
					vo.setSeq(Integer.parseInt(seq));
					
					BoardDAOJDBC boardDAO = new BoardDAOJDBC();
					boardDAO.deleteBoard(vo);
					
					// 3. �솕硫� �꽕?��꾧쾶�씠��??
					return "getBoardList.do";
			
	}

}
