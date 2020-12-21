package com.rubypaper.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.rubypaper.biz.user.UserDAOJDBC;
import com.rubypaper.biz.user.UserVO;


public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α��� ��� ó��");
		
		// 1. ����� �Է����� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB ���� ó��
		UserVO vo = new UserVO(); 
		vo.setId(id);             
		vo.setPassword(password);
		
		UserDAOJDBC userDAO = new UserDAOJDBC();
		UserVO user = userDAO.getUser(vo);
		
		// 3. ȭ�� �׺���̼�
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			// �α��� ���� ��, ���ǿ� ���������� �����Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("user", user);		
			//forward: �̳� redirect:�� ���̸� �տ� ���̸� ViewResolver�� �����Ѵ�. 
			mav.setViewName("forward:getBoardList.do");
		} else {
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}

}
