package com.rubypaper.biz.board;

public class GetBoardListTest {
public static void main(String[] args) {
	BoardDAO dao = new BoardDAO();
	
	System.out.println(dao.getBoardList().size() + "개의 글");
}
}
