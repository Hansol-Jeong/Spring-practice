package com.rubypaper.biz.web.controller.board;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.rubypaper.biz.board.BoardService;
import com.rubypaper.biz.board.BoardVO;
@SessionAttributes({"board"})
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	//글 등록 화면이동
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertBoardView(BoardVO vo) {
		vo.setTitle("2000자 미만으로");
		vo.setWriter("테스터");
		vo.setContent("2000자 미만으로 작성해 주세요");
		return "insertBoard";
	}
	
	public String insertBoard(BoardVO vo) throws Exception {
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			uploadFile.transferTo(new File("C:/DEV/eclipse-jee-photon-R-win32-x86_64/upload_files" + uploadFile.getOriginalFilename()));
		}
		return "forward:getBoardList.do";
	}
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("게시 글 수정 기능 처리");
		System.out.println("수정 처리에서의 BoardVO 객체 정보");
		System.out.println(vo.toString());
		
		boardService.updateBoard(vo);
		return "forward:getBoardList.do";
	}
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("게시 글 삭제 기능 처리");
		
		boardService.deleteBoard(vo);
		return "forward:getBoardList.do";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		if(vo.getSearchCondition()==null) {
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword()==null) 
			vo.setSearchKeyword("");
		
		model.addAttribute("boardList", boardService.getBoardList(vo));
		model.addAttribute("search", vo);
		return "getBoardList";
	}
	
	
}
