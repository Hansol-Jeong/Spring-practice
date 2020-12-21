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

@RestController//모든 메소드에 responsebody를 달아주겟다
public class BoardController {
	public BoardController() {
		System.out.println("===> BoardController created");
	}
	
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
//	@ResponseBody //응답프로토콜 바디쪽에 담아서 전달하겠다.
	@GetMapping("/hello")
	public String hello(String name) {
		return "hello : " + name;
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("임시 제목");
		board.setWriter("임시 작성자");
		board.setContent("임시내용");
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
			board.setTitle("임시 제목");
			board.setWriter("임시 작성자");
			board.setContent("임시내용");
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		return boardList;
	}
	
}
