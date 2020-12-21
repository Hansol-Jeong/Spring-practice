package com.rubypaper.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rubypaper.biz.user.UserDAOJDBC;
import com.rubypaper.biz.user.UserService;
import com.rubypaper.biz.user.UserVO;
@Controller
public class LoginController {
	@Autowired
	private UserService userService;

/*	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAOJDBC userDAO, HttpSession session) {
		System.out.println("�α��� ��� ó��");
		
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			session.setAttribute("user", user);
			return "forward:getBoardList.do";	
		} else return "login";//���� �ּ�ġ�� �����ϱ� viewResolverŸ����
	}*/
	@RequestMapping(value="/login.do", method=RequestMethod.GET)//�α��� ��
	public String loginView(UserVO vo) {
//		System.out.println(9/0);
		System.out.println("�α��� ȭ������ �̵�");
		vo.setId("admin");
		vo.setPassword("admin");
		return "login";//���� �ּ�ġ�� �����ϱ� viewResolverŸ����
	}
	@RequestMapping(value="/login.do",method=RequestMethod.POST)//�α���
	public String login(UserVO vo, HttpSession session) {
		System.out.println("�α��� ��� ó��");
		
		UserVO user = userService.getUser(vo); //��Ʈ�ѷ��� DAO�� ���� �̿��ϸ� �ȵ�
		if(user != null) {
			session.setAttribute("user", user);
			return "forward:getBoardList.do";
		} else return "login";//���� �ּ�ġ�� �����ϱ� viewResolverŸ����
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index.jsp";
	}
}
