package com.rubypaper.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardDAOJDBC;
import com.rubypaper.biz.board.BoardVO;
import com.rubypaper.biz.user.UserDAO;
import com.rubypaper.biz.user.UserDAOJDBC;
import com.rubypaper.biz.user.UserVO;


public class DispatcherServletBackup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DispatcherServletBackup() {
     System.out.println("===> DispatcherServlet �깮�꽦");

    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//1. �궗�슜�옄 �슂泥� path �젙蹂�?�� ?��붿텧�븳�떎.
		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		//2.?��붿텧�맂 path�뿉 �뵲�씪 �슂泥��쓣 ?��꾧린泥섎?���븳�떎.
		if(path.equals("/login.do")) {
			// 1. �궗�슜�옄 �엯�젰�젙蹂� ?��붿텧
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
//				response.sendRedirect("getBoardList.jsp");//湲�紐⑸줉�?��濡� 諛붾줈媛�硫�? �븞�맂�떎. �꽌?��붾┸�뿉�꽌 ��?���젙蹂�?�� �꽭��?���? ���옣�븯?�� 媛��빞�븳�떎.
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login.do");
			}
		} else if(path.equals("/logout.do")) {
			System.out.println("濡쒓?���븘�썐 湲곕?�� 泥섎?��");
			//濡쒓?���븘�썐�쓣 �슂泥��븳 ?��?��?���슦���뿉 �빐�떦�븯�뒗 �꽭��?? 媛앹껜瑜�? 媛뺤?�� ?��?��즺�븳�?��.
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.do");
		} else if(path.equals("/insertBoard.do")) {
			// 1. �궗�슜�옄 �엯�젰�젙蹂� ?��붿텧
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB �뿰�룞 泥섎?��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAOJDBC boardDAO = new BoardDAOJDBC();
			boardDAO.insertBoard(vo);
			
			// 3. �솕硫� �꽕?��꾧쾶�씠��??
			response.sendRedirect("getBoardList.do");
		}  else if(path.equals("/deleteBoard.do")) {
			// 1. �궗�슜�옄 �엯�젰�젙蹂� ?��붿텧
			String seq = request.getParameter("seq");
			
			// 2. DB �뿰�룞 泥섎?��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAOJDBC boardDAO = new BoardDAOJDBC();
			boardDAO.deleteBoard(vo);
			
			// 3. �솕硫� �꽕?��꾧쾶�씠��??
			response.sendRedirect("getBoardList.do");
		}else if(path.equals("/getBoard.do")) {
			// 1. �궗�슜�옄 �엯�젰�젙蹂� ?��붿텧
			String seq = request.getParameter("seq");
			
			// 2. DB �뿰�룞 泥섎?��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAOJDBC boardDAO = new BoardDAOJDBC();
			BoardVO board = boardDAO.getBoard(vo);
			
			//3. 寃��깋 寃곌?��?���? �꽭��?���? �벑濡앺�??�� JSP�솕硫댁?��濡� �씠�룞�븳�떎.
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
		}else if(path.equals("/getBoardList.do")) {
			
		} else if(path.equals("/updateBoard.do")) {
			// 1. �궗�슜�옄 �엯�젰�젙蹂� ?��붿텧
			String title = request.getParameter("title");
			String seq = request.getParameter("seq");
			String content = request.getParameter("content");
			
			// 2. DB �뿰�룞 泥섎?��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setSeq(Integer.parseInt(seq));
			vo.setContent(content);
			
			BoardDAOJDBC boardDAO = new BoardDAOJDBC();
			boardDAO.updateBoard(vo);
			
			// 3. �솕硫� �꽕?��꾧쾶�씠��??
			response.sendRedirect("getBoardList.do");
		}
		else {
			System.out.println("URL�쓣 �떎�떆 �솗�씤�빐二쇱?��湲� 諛붾?���땲�떎.");
		}
	}

}
