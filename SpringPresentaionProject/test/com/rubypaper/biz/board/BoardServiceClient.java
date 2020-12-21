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
			System.out.println(boardService + " : Lookup ����");
		
		BoardVO vo = new BoardVO();
//		vo.setSeq(14);
//		
//		BoardVO board = boardService.getBoard(vo);
//		System.out.println(board.toString());
//		System.out.println(board.getSeq() + "�� �� ������");
//		System.out.println("����: " + board.getTitle());
//		System.out.println("�ۼ���: " + board.getWriter());
//		System.out.println("����: " + board.getContent());
//		System.out.println("�����: " + board.getRegDate());
//		System.out.println("��ȸ��: " + board.getCnt());
		
		
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
//		vo.setTitle("Spring ����");
//		vo.setWriter("�׽���");
//		vo.setContent("Spring ����.....");
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
