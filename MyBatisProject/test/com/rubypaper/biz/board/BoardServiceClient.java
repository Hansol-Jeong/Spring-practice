package com.rubypaper.biz.board;

import java.util.List;

class BoardServiceClient {
	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		vo.setTitle("MyBatis제목");
		vo.setWriter("테스터");
		vo.setContent("MyBatis내용...");
		
		BoardDAOMyBATIS boardDAO = new BoardDAOMyBATIS();
		boardDAO.insertBoard(vo);
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for(BoardVO board: boardList) {
			System.out.println("---> " + board.toString());
		}
	}

}
