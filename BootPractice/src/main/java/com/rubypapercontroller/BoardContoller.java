package com.rubypapercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rubypaper.domain.Board;
import com.rubypaper.service.BoardService;

@Controller
public class BoardContoller {
@Autowired
private BoardService boardService;

@GetMapping("/insertBoard")// /WEB-INF/board/insertBoard.jsp로 가겠징
public String insertBoardView(Board board) {
	return "redirect:insertBoard";//redirect이거 붙고안붙고 차이 뭐였지
}

@PostMapping("/insertBoard")
public String insertBoard(Board board) {
	boardService.insertBoard(board);
	return "redirect:getBoardList";
}


}
