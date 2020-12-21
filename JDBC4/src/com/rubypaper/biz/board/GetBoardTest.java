package com.rubypaper.biz.board;

public class GetBoardTest {
public static void main(String[] args) {
	BoardDAO boardDAO = new BoardDAO();
	BoardVO vo = new BoardVO();
	
	vo.setSeq(4);
	vo = boardDAO.getBoard(vo);
	System.out.println(vo.getSeq() + "번 글의 상세정보");
	System.out.println("제목:  "+vo.getTitle());
	System.out.println("작성자: " + vo.getWriter());
	System.out.println("내용: " + vo.getContent());
	System.out.println("등록일: " + vo.getRegDate());
	System.out.println("조회수: " + vo.getCnt());
}
}
