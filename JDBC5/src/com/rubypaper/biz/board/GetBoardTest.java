package com.rubypaper.biz.board;

public class GetBoardTest {
public static void main(String[] args) {
	BoardDAO dao = new BoardDAO();
	BoardVO vo = new BoardVO();
	
	vo.setSeq(5);
	dao.getBoard(vo);
}
}
