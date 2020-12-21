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
		System.out.println("로그인 기능 처리");
		
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			session.setAttribute("user", user);
			return "forward:getBoardList.do";	
		} else return "login";//직접 주소치고 못가니까 viewResolver타야해
	}*/
	@RequestMapping(value="/login.do", method=RequestMethod.GET)//로그인 뷰
	public String loginView(UserVO vo) {
//		System.out.println(9/0);
		System.out.println("로그인 화면으로 이동");
		vo.setId("admin");
		vo.setPassword("admin");
		return "login";//직접 주소치고 못가니까 viewResolver타야해
	}
	@RequestMapping(value="/login.do",method=RequestMethod.POST)//로그인
	public String login(UserVO vo, HttpSession session) {
		System.out.println("로그인 기능 처리");
		
		UserVO user = userService.getUser(vo); //컨트롤러가 DAO를 직접 이용하면 안됨
		if(user != null) {
			session.setAttribute("user", user);
			return "forward:getBoardList.do";
		} else return "login";//직접 주소치고 못가니까 viewResolver타야해
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index.jsp";
	}
}
