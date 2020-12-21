<%@page contentType="text/html; charset=EUC-KR" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!-- 
	EL(Expression Language) 이란?
	JSP 파일에서 request나 session(내장 객체)에 등록한 데이터를 접근하기 위한 표현식
	
	JSTL(JSP Standard Tag Library) 이란?
	JSP 파일에서 if, for, switch 등과 같은 자바 코드를 대체하는 JSP 표준 태그
-->

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>
<title>글 상세</title>
</head>
<body>
<center>
<h1><spring:message code="user.getBoard.get"/></h1>
<h3><a href='logout.do'><spring:message code="user.getBoard.logout"/></a></h3>
<hr>
<form action='updateBoard.do' method='post'>
<input type='hidden' name='seq' value='${board.seq }'/>
<table border='1' cellpadding='0' cellspacing='0'>
<tr>
<td bgcolor='orange' width='70'><spring:message code="user.getBoard.title"/></td>
<td align='left'><input name='title' type='text' value='${board.title }'/></td>
</tr>
<tr>
<td bgcolor='orange'><spring:message code="user.getBoard.writer"/></td>
<td align='left'>${board.writer }</td>
</tr>
<tr>
<td bgcolor='orange'><spring:message code="user.getBoard.content"/></td>
<td align='left'><textarea name='content' cols='40' rows='10'>${board.content }</textarea></td>
</tr>
<tr>
<td bgcolor='orange'><spring:message code="user.getBoard.regDate"/></td>
<td align='left'>${board.regDate }</td>
</tr>
<tr>
<td bgcolor='orange'><spring:message code="user.getBoard.cnt"/></td>
<td align='left'>${board.cnt }</td>
</tr>
<tr>
<td colspan='2' align='center'>
<input type='submit' value='글 수정'/>
</td>
</tr>
				<tr>
				<td bgcolor="orange"><spring:message code="user.getBoard.upload"/></td><td align="left">
				<input type="file" name="uploadFile"/></td>
			</tr>
</table>
</form>
<hr>
<a href='insertBoard.do'><spring:message code="user.getBoard.regi"/></a>&nbsp;&nbsp;&nbsp;
<c:if test="${user.role == 'ADMIN' }">
<a href='deleteBoard.do?seq=${board.seq }'><spring:message code="user.getBoard.del"/></a>&nbsp;&nbsp;&nbsp;
</c:if>
<a href='getBoardList.do'><spring:message code="user.getBoard.list"/></a>
</center>
</body>
</html>
