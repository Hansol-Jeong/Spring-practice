<%@page import="com.rubypaper.biz.user.UserDAO"%>
<%@page import="com.rubypaper.biz.user.UserVO"%>
<%@page import="org.apache.tomcat.jni.User"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
  //1. ����� �Է����� ����
    String id = request.getParameter("id"); // jsp �ڵ�� ������ service�޼ҵ忡�� �����ȴ�. ������ req, res�Ķ���͸� �ް� �����Ѵ�.
    String password = request.getParameter("password");
    //2. DB���� ó��
    UserVO vo = new UserVO();
    vo.setId(id);
    vo.setPassword(password);

    UserDAO userDAO = new UserDAO();
    UserVO user = userDAO.getUser(vo);

    //3.ȭ�� �׺���̼�
    if(user != null) {
    	HttpSession session2 = request.getSession(); //�� ����2�� ����մϱ�??, �� request.getSession�̾�� �մϱ�?
        session2.setMaxInactiveInterval(10000);
    	session2.setAttribute("user", user);//userŰ�� user ���� �����մϴ�.
    	response.sendRedirect("getBoardList.jsp");//�� �κ��� ����Ǿ�� �մϴ�.
    } else {
    	System.out.println("�α��� ����");
    	response.sendRedirect("login.html");
    }
    %>
    