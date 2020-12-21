package com.rubypaper.biz.board;

public class DeleteBoardTest {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setSeq(4);
		dao.deleteBoard(vo);
		dao.getBoardList();
	}
}
