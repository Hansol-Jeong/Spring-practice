<%@page import="com.rubypaper.biz.board.BoardDAO"%>
<%@page import="com.rubypaper.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("content");
//2.DB연동 처리
BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setWriter(writer);
vo.setContent(content);

BoardDAO boardDAO = new BoardDAO();
boardDAO.insertBoard(vo);

//3.화면 네비게이션
response.sendRedirect("getBoardList.jsp");
%>