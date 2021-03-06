package com.rubypaper.biz.board;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
//		String[] configuration = {"business-layer.xml", "business-transaction.xml"};
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("business-*.xml");
		
		BoardService boardService = (BoardService) container.getBean("boardService");
		if(boardService != null) 
			System.out.println(boardService + " : Lookup 성공");
		
		BoardVO vo = new BoardVO();
//		vo.setSeq(14);
//		
//		BoardVO board = boardService.getBoard(vo);
//		System.out.println(board.toString());
//		System.out.println(board.getSeq() + "번 글 상세정보");
//		System.out.println("제목: " + board.getTitle());
//		System.out.println("작성자: " + board.getWriter());
//		System.out.println("내용: " + board.getContent());
//		System.out.println("등록일: " + board.getRegDate());
//		System.out.println("조회수: " + board.getCnt());
		
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List boardList = boardService.getBoardList(vo);
		System.out.println("[ BOARD LIST ]");
		for (Object board : boardList) {
//			Map<String, Object> board = (Map<String, Object>) row;
//			System.out.println(board.get("SEQ") + " : " + board.get("TITLE") + " : " + board.get("WRITER"));
			System.out.println("---> " + board.toString());
		}
//		vo.setSeq(47);
//		vo.setTitle("Spring 제목");
//		vo.setWriter("테스터");
//		vo.setContent("Spring 내용.....");
//		boardService.insertBoard(vo);
//		
//		vo.setTitle("xxxxxxxxxx");
//		vo.setContent("cccccccccccc");
//		vo.setSeq(15);
//		boardService.updateBoard(vo);
//		
//		boardService.deleteBoard(vo);
		
		
		
		
//		vo.setSearchCondition("TITLE");
//		vo.setSearchKeyword("");
//		List<BoardVO> boardList = boardService.getBoardList(vo);
//		System.out.println("[ BOARD LIST ]");
//		for (BoardVO board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
		
		container.close();
	}
}
