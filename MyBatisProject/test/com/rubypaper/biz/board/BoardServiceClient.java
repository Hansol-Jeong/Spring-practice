package com.rubypaper.biz.board;

import java.util.List;

class BoardServiceClient {
	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		vo.setTitle("MyBatis����");
		vo.setWriter("�׽���");
		vo.setContent("MyBatis����...");
		
		BoardDAOMyBATIS boardDAO = new BoardDAOMyBATIS();
		boardDAO.insertBoard(vo);
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for(BoardVO board: boardList) {
			System.out.println("---> " + board.toString());
		}
	}

}
