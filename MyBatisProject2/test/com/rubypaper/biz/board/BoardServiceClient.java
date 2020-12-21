package com.rubypaper.biz.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardServiceClient {
	public static void main(String[] args) {
		Map<String, Object> paramMap = new HashMap<String, Object>();	
		paramMap.put("title", "MyBatis����");
		paramMap.put("writer", "MyBatis�ۼ���");
		paramMap.put("content", "MyBatis����");
		
		BoardDAOMyBATIS boardDAO = new BoardDAOMyBATIS();
		boardDAO.insertBoardMap(paramMap);
		
		BoardVO vo = new BoardVO();
		List<Map<String, Object>> boardList = boardDAO.getBoardListMap(vo);
		for (Map<String, Object> board : boardList) {
			System.out.println("---> " + board.get("SEQ") + " : " + board.get("TITLE"));
		}
	}
}
