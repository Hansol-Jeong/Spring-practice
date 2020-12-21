package com.rubypaper.biz.board;

public class UpdateBoardTest {//업데이트에는 seq, title, content가 필요해
//data access object, Value object
public static void main(String[] args) {
	BoardDAO boardDAO = new BoardDAO();
	BoardVO vo = new BoardVO();
	vo.setSeq(4);
	vo.setTitle("새로운 타이틀");
	vo.setContent("새로운 컨텐트");
	
	boardDAO.updateBoard(vo);
	BoardVO board = boardDAO.getBoard(vo);
	System.out.println(board.getSeq() + "번 게시 글의 상세 정보");
	System.out.println("제목 : " + board.getTitle());
	System.out.println("작성자 : " + board.getWriter());
	System.out.println("내용 : " + board.getContent());
	System.out.println("등록일 : " + board.getRegDate());
	System.out.println("조회수 : " + board.getCnt());
	
}
}
