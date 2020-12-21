package com.rubypaper.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.user.UserDAOJDBC;
import com.rubypaper.biz.user.UserVO;
import com.rubypaper.web.controller.Controller;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB �뿰�룞 泥섎?��
		UserVO vo = new UserVO(); 
		vo.setId(id);             
		vo.setPassword(password);
		
		UserDAOJDBC userDAO = new UserDAOJDBC();
		UserVO user = userDAO.getUser(vo);
		
		// 3. �솕硫� �꽕?��꾧쾶�씠��??
		if(user != null) {
			// 濡쒓?���씤 �꽦?�� �떆, �꽭��??(�궡�옣 媛앹�?)�뿉 �긽�깭�젙蹂�?�� ���옣�븳�떎.
			HttpSession session = request.getSession();//jsp�뒗 洹몃�? �벐吏�留� �꽌?��붾┸�� 洹몃�? 紐살벖�?��.
			session.setAttribute("user", user);		
//			response.sendRedirect("getBoardList.jsp");//湲�紐⑸줉�?��濡� 諛붾줈媛�硫�? �븞�맂�떎. �꽌?��붾┸�뿉�꽌 ��?���젙蹂�?�� �꽭��?���? ���옣�븯?�� 媛��빞�븳�떎.
			return "getBoardList.do";
		} else {
			return "login.do";
		}
	}

}
