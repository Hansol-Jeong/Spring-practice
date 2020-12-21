package com.rubypaper.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rubypaper.biz.board.BoardDAOJDBC;
import com.rubypaper.biz.board.BoardVO;
//implements Controller
@SessionAttributes({"board"})//으마으마하게 중요한 거에요, 이걸 이용하면 특정 이름으로 Model에 저장된 데이터를 세션에도 등록되도록 한다. 
@Controller//위에꺼 이어서: 따라서 getBoard메소드에서 Model에 "board"라는 이름의로 BoardVO객체를 저장하면  세션에서도"board"라는 이름으로 BoardVO 객체가 등록되는 것이다.
public class BoardController {
	//글 등록 화면이동
	@RequestMapping(value="/insertBoard.do",method=RequestMethod.GET)//get방식이면 insertBoard.jsp로 가고
	public String insertBoardView(BoardVO vo) {
		//매개변수로 받은 VO 객체는 자동으로  request내장 객체에 등록된다.
		//따라서 최종적으로 실행되는 화면(JSP)에서 EL을 이용하여 값을 뿌릴 수 있다.
		vo.setTitle("200자 미만으로");
		vo.setWriter("테스터");
		vo.setContent("2000자 미만으로 작성해 주세요");
		return "insertBoard";
	}
	@RequestMapping(value="/insertBoard.do",method=RequestMethod.POST)//post방식이면 BoardList로 가겟다고
	public String insertBoard(BoardVO vo, BoardDAOJDBC boardDAO) {
		boardDAO.insertBoard(vo);// 스프링 컨테이너가 dao랑 vo다 세팅해서 넘겨준다. 전제조건이 있다.
//insertBoard엔 title, content, writer파라미터 필요하고 BoardDAO에 해당 set이 있어야돼	(setter injection)
		return "forward:getBoardList.do";// 리다이렉트 하지말고 포워드해라
	}

	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAOJDBC boardDAO, Model model) {
		System.out.println("상세 화면에서의 BoardVO 객체 정보");
		System.out.println(vo.toString());
		//moel에 저장한 데이터는 자동으로 request에 등록된다.
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard";
	}
//@ModelAttribute 는 세션에 "board"라는 이름으로 데이터가 등록되어 있다면 그 객체를 vo변숭 바인딩해라 라는 의미다.
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAOJDBC boardDAO ) {//어노테이션ㄴ이 없다면 t, c, s만 채워져서 새로생성되지만 어노테이션이 있다면 객체를 새로 만들지 말고 세션에 등록된 vo를 고대로 바인드 시켜
		//세션에 없다면 새로만들어
		//원래있던 vo데이터에 사용자가 변경한데이터만 업데이트됨
		System.out.println("게시 글 수정 기능 처리");
		System.out.println("수정 처리에서의 BoardVO 객체 정보");
		System.out.println(vo.toString());
		
		
		boardDAO.updateBoard(vo);
		return "forward:getBoardList.do";
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAOJDBC boardDAO) {
		System.out.println("게시 글 삭제 기능 처리");

		boardDAO.deleteBoard(vo);

		return "forward:getBoardList.do";

	}
/*	@RequestMapping("/deleteBoard.do")
//	public String handleRequest(@RequestParam("seq") int boardSeq, BoardDAOJDBC boardDAO) { 근데 이건 별로 의미가 없고 아래가 의미가 있어
	public String handleRequest(@RequestParam(value="seq", defaultValue="1", required=true) int boardSeq, BoardDAOJDBC boardDAO) {//required는 값이 무조건 채워져야되?아냐?(true=응 채워줘야돼)
		System.out.println(boardSeq+ "번 글 삭제 처리");

//		boardDAO.deleteBoard(vo);

		return "forward:getBoardList.do";

	}*/

	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAOJDBC boardDAO, Model model) {//modelandview랑 똑같지만 데이터만 저장할 수 있다. modelandview는 객체 그래서 스트링타입으로 반환 못받아서 model써
		// null check
		if (vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
//절대 검색결과는 세션에 등록하면 안된다. 검색결과는 request에 등록해야 한다.
		//ModelAndView나 Model객체에 검색결과를 등록하면 자동으로 세션이 아닌 request에 등록해준다.
//		session.setAttribute("boardList", boardDAO.getBoardList(vo));
//		session.setAttribute("search", vo);
		model.addAttribute("boardList", boardDAO.getBoardList(vo)); //model정보
		model.addAttribute("search", vo);// model정보
		return "getBoardList";//view리턴
	}

}
