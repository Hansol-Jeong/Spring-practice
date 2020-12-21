package com.rubypaper.web.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.board.BoardDAOJDBC;
import com.rubypaper.biz.board.BoardVO;
import com.rubypaper.web.controller.Controller;

public class GetBoardListController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. 占쎄�占쎌��占쎌�� 占쎌��占쎌�곤옙��癰�占� ?占쏙옙遺욱��
					String searchCondition = request.getParameter("searchCondition");
					String searchKeyword = request.getParameter("searchKeyword");
					
					// Null Check
					if(searchCondition == null) searchCondition = "TITLE";
					if(searchKeyword == null) searchKeyword = "";
					
					// 2. DB 占쎈염占쎈� 筌ｌ��?占쏙옙
					BoardVO vo = new BoardVO();
					vo.setSearchCondition(searchCondition);
					vo.setSearchKeyword(searchKeyword);
					
					BoardDAOJDBC boardDAO = new BoardDAOJDBC();
					List<BoardVO> boardList = boardDAO.getBoardList(vo);
					//3. 野�占쏙옙源� 野�怨�?占쏙옙?占쏙옙占�? 占쎌��筌�占�(JSP)占쎈�占쎄� 占쎄�占쎌��占쎈막 占쎈�� 占쎌�놂옙猷�嚥∽옙 占쎄쉭占쏙옙?占쏙옙占�? 占쎈�嚥≪�븍립占�?占쏙옙.
					HttpSession session = request.getSession();
					session.setAttribute("boardList", boardList);
					
					//疫뀐옙 筌��몌옙? 占쎌��筌�占�(getBoardList.jsp)占쎌��嚥∽옙 占쎌��占쎈�占쎈립占쎈��.
					return "getBoardList.do";
	
	}

}
