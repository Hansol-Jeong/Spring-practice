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
@SessionAttributes({"board"})//���������ϰ� �߿��� �ſ���, �̰� �̿��ϸ� Ư�� �̸����� Model�� ����� �����͸� ���ǿ��� ��ϵǵ��� �Ѵ�. 
@Controller//������ �̾: ���� getBoard�޼ҵ忡�� Model�� "board"��� �̸��Ƿ� BoardVO��ü�� �����ϸ�  ���ǿ�����"board"��� �̸����� BoardVO ��ü�� ��ϵǴ� ���̴�.
public class BoardController {
	//�� ��� ȭ���̵�
	@RequestMapping(value="/insertBoard.do",method=RequestMethod.GET)//get����̸� insertBoard.jsp�� ����
	public String insertBoardView(BoardVO vo) {
		//�Ű������� ���� VO ��ü�� �ڵ�����  request���� ��ü�� ��ϵȴ�.
		//���� ���������� ����Ǵ� ȭ��(JSP)���� EL�� �̿��Ͽ� ���� �Ѹ� �� �ִ�.
		vo.setTitle("200�� �̸�����");
		vo.setWriter("�׽���");
		vo.setContent("2000�� �̸����� �ۼ��� �ּ���");
		return "insertBoard";
	}
	@RequestMapping(value="/insertBoard.do",method=RequestMethod.POST)//post����̸� BoardList�� ���ٴٰ�
	public String insertBoard(BoardVO vo, BoardDAOJDBC boardDAO) {
		boardDAO.insertBoard(vo);// ������ �����̳ʰ� dao�� vo�� �����ؼ� �Ѱ��ش�. ���������� �ִ�.
//insertBoard�� title, content, writer�Ķ���� �ʿ��ϰ� BoardDAO�� �ش� set�� �־�ߵ�	(setter injection)
		return "forward:getBoardList.do";// �����̷�Ʈ �������� �������ض�
	}

	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAOJDBC boardDAO, Model model) {
		System.out.println("�� ȭ�鿡���� BoardVO ��ü ����");
		System.out.println(vo.toString());
		//moel�� ������ �����ʹ� �ڵ����� request�� ��ϵȴ�.
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard";
	}
//@ModelAttribute �� ���ǿ� "board"��� �̸����� �����Ͱ� ��ϵǾ� �ִٸ� �� ��ü�� vo���� ���ε��ض� ��� �ǹ̴�.
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAOJDBC boardDAO ) {//������̼Ǥ��� ���ٸ� t, c, s�� ä������ ���λ��������� ������̼��� �ִٸ� ��ü�� ���� ������ ���� ���ǿ� ��ϵ� vo�� ���� ���ε� ����
		//���ǿ� ���ٸ� ���θ����
		//�����ִ� vo�����Ϳ� ����ڰ� �����ѵ����͸� ������Ʈ��
		System.out.println("�Խ� �� ���� ��� ó��");
		System.out.println("���� ó�������� BoardVO ��ü ����");
		System.out.println(vo.toString());
		
		
		boardDAO.updateBoard(vo);
		return "forward:getBoardList.do";
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAOJDBC boardDAO) {
		System.out.println("�Խ� �� ���� ��� ó��");

		boardDAO.deleteBoard(vo);

		return "forward:getBoardList.do";

	}
/*	@RequestMapping("/deleteBoard.do")
//	public String handleRequest(@RequestParam("seq") int boardSeq, BoardDAOJDBC boardDAO) { �ٵ� �̰� ���� �ǹ̰� ���� �Ʒ��� �ǹ̰� �־�
	public String handleRequest(@RequestParam(value="seq", defaultValue="1", required=true) int boardSeq, BoardDAOJDBC boardDAO) {//required�� ���� ������ ä�����ߵ�?�Ƴ�?(true=�� ä����ߵ�)
		System.out.println(boardSeq+ "�� �� ���� ó��");

//		boardDAO.deleteBoard(vo);

		return "forward:getBoardList.do";

	}*/

	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAOJDBC boardDAO, Model model) {//modelandview�� �Ȱ����� �����͸� ������ �� �ִ�. modelandview�� ��ü �׷��� ��Ʈ��Ÿ������ ��ȯ ���޾Ƽ� model��
		// null check
		if (vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
//���� �˻������ ���ǿ� ����ϸ� �ȵȴ�. �˻������ request�� ����ؾ� �Ѵ�.
		//ModelAndView�� Model��ü�� �˻������ ����ϸ� �ڵ����� ������ �ƴ� request�� ������ش�.
//		session.setAttribute("boardList", boardDAO.getBoardList(vo));
//		session.setAttribute("search", vo);
		model.addAttribute("boardList", boardDAO.getBoardList(vo)); //model����
		model.addAttribute("search", vo);// model����
		return "getBoardList";//view����
	}

}
