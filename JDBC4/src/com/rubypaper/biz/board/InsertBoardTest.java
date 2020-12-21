package com.rubypaper.biz.board;

public class InsertBoardTest {//insert 는 title, writer랑 content정보가 필요해
	public static void main(String[] args) {
		//data access object 와 data value를 선언해준다
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setTitle("타이틀");
		vo.setWriter("테스텉");
		vo.setContent("VO 내용...");
		
		boardDAO.insertBoard(vo);; //boardDAO로 insertObject명령어를 실행시키고 뭘 담아가서 실행시켜? -> vo를 담아가서 실행시켜
		boardDAO.getBoardList(); // 마지막에 출력해주면 되지.
		
	}
}
