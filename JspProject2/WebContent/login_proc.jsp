<%@page import="com.rubypaper.biz.user.UserDAO"%>
<%@page import="com.rubypaper.biz.user.UserVO"%>
<%@page import="org.apache.tomcat.jni.User"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
  //1. 사용자 입력정보 추출
    String id = request.getParameter("id"); // jsp 코드는 서블릿의 service메소드에서 구현된다. 때문에 req, res파라미터를 받고 시작한다.
    String password = request.getParameter("password");
    //2. DB연동 처리
    UserVO vo = new UserVO();
    vo.setId(id);
    vo.setPassword(password);

    UserDAO userDAO = new UserDAO();
    UserVO user = userDAO.getUser(vo);

    //3.화면 네비게이션
    if(user != null) {
    	HttpSession session2 = request.getSession(); //왜 세션2를 써야합니까??, 왜 request.getSession이어야 합니까?
        session2.setMaxInactiveInterval(10000);
    	session2.setAttribute("user", user);//user키에 user 값을 대입합니다.
    	response.sendRedirect("getBoardList.jsp");//이 부분은 변경되어야 합니다.
    } else {
    	System.out.println("로그인 실패");
    	response.sendRedirect("login.html");
    }
    %>
    