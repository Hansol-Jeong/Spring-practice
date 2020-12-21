package com.rubypaper.biz.board;

public class UpdateBoardTest {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setSeq(5);
		vo.setContent("수정 내용");
		vo.setTitle("수정 제목");
		
		dao.updateBoard(vo);
		dao.getBoard(vo);
	}
}
