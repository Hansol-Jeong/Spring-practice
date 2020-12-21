package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;

@RestController//��� �޼ҵ忡 responsebody�� �޾��ְٴ�
public class BoardController {
	public BoardController() {
		System.out.println("===> BoardController created");
	}
	
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
//	@ResponseBody //������������ �ٵ��ʿ� ��Ƽ� �����ϰڴ�.
	@GetMapping("/hello")
	public String hello(String name) {
		return "hello : " + name;
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("�ӽ� ����");
		board.setWriter("�ӽ� �ۼ���");
		board.setContent("�ӽó���");
		board.setCreateDate(new Date());
		board.setCnt(0);
		
		return board;
	}
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<>();
		for(int i = 0; i<5; ++i) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setTitle("�ӽ� ����");
			board.setWriter("�ӽ� �ۼ���");
			board.setContent("�ӽó���");
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		return boardList;
	}
	
}
