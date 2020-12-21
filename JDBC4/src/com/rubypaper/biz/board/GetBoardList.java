package com.rubypaper.biz.board;

import java.util.ArrayList;
import java.util.List;

public class GetBoardList {
public static void main(String[] args) {
	BoardDAO boardDAO = new BoardDAO();
	BoardVO vo = new BoardVO();
	
	List<BoardVO> list = new ArrayList<BoardVO>();
	list = boardDAO.getBoardList();
	for (BoardVO board : list) {
		System.out.print("제목: " + board.getTitle());
		System.out.println(" 조회수: " + board.getCnt());
	}
	System.out.println("총 글 수 : " + list.size());
}
}
