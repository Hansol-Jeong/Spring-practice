<%@page import="com.rubypaper.biz.user.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="com.rubypaper.biz.board.BoardDAO"%>
<%@page import="com.rubypaper.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR"%>

<%
	// 1. 사용자 입력정보 추출
	String searchCondition = request.getParameter("searchCondition");//request는 어디서 값을 채워오는데?
	String searchKeyword = request.getParameter("searchKeyword");
	
	// Null Check
	if(searchCondition == null) searchCondition = "TITLE";
	if(searchKeyword == null) searchKeyword = "";
	
	// 2. DB 연동 처리
	BoardVO vo = new BoardVO();
	vo.setSearchCondition(searchCondition);
	vo.setSearchKeyword(searchKeyword);
	
	BoardDAO boardDAO = new BoardDAO();
	List<BoardVO> boardList = boardDAO.getBoardList(vo);
	
	HttpSession session2 = request.getSession();
	UserVO user = (UserVO)session2.getAttribute("user");
	// 3. 응답 화면 구성
%>

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>
<title>글 목록</title>
</head>
<body>
	<center>
		<h1>게시글 목록</h1>
		<h3>
			<font color='red'><%= user.getName()%></font>님 로그인 환영합니다...... <a href='logout_proc.jsp'>Log-out</a>
		</h3>
		<!-- 검색 시작 -->
		<form action='getBoardList.jsp' method='post'>
			<table border='1' cellpadding='0' cellspacing='0' width='700'>
				<tr>
					<td align='right'><select name='searchCondition'>
							<option value='TITLE'>제목
							<option value='CONTENT'>내용
					</select> <input name='searchKeyword' type='text' /> <input type='submit'
						value='검색' /></td>
				</tr>
			</table>
		</form>
		<!-- 검색 종료 -->
		<table border='1' cellpadding='0' cellspacing='0' width='700'>
			<tr>
				<th bgcolor='orange' width='100'>번호</th>
				<th bgcolor='orange' width='200'>제목</th>
				<th bgcolor='orange' width='150'>작성자</th>
				<th bgcolor='orange' width='150'>등록일</th>
				<th bgcolor='orange' width='100'>조회수</th>
			</tr>
			
			<% for(BoardVO board : boardList) { %>
			<tr>
				<td><%= board.getSeq() %></td>
				<td align='left'><a href='getBoard.jsp?seq=2'><%= board.getTitle() %></a></td>
				<td><%= board.getWriter() %></td>
				<td><%= board.getRegDate() %></td>
				<td><%= board.getCnt() %></td>
			</tr>
			<% } %>
			
		</table>
		<br> <a href='insertBoard.html'>새글 등록</a>
	</center>
</body>
</html>
