package com.rubypaper.biz.board;

public class InsertBoardTest {
public static void main(String[] args) {//insert하려면 제목, 작성자, 컨텐츠를 value값으로 넣어줘야 해
	//value값들 불러오고 컨트롤러 불러오자
	BoardVO vo = new BoardVO();
	BoardDAO dao = new BoardDAO();
	
	vo.setTitle("제목1");
	vo.setWriter("작성자1");
	vo.setContent("내용1");
	
	dao.insertBoard(vo);
	dao.getBoardList();
}
}
