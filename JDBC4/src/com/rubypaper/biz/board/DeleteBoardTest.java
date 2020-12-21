package com.rubypaper.biz.board;

public class DeleteBoardTest {
public static void main(String[] args) {
	BoardDAO boardDAO = new BoardDAO();
	BoardVO vo = new BoardVO();
	
	vo.setSeq(3);
	boardDAO.deleteBoard(vo);
	boardDAO.getBoardList();
}
}
