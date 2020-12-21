<%@page contentType="text/html; charset=EUC-KR" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!-- 
	EL(Expression Language) �̶�?
	JSP ���Ͽ��� request�� session(���� ��ü)�� ����� �����͸� �����ϱ� ���� ǥ����
	
	JSTL(JSP Standard Tag Library) �̶�?
	JSP ���Ͽ��� if, for, switch ��� ���� �ڹ� �ڵ带 ��ü�ϴ� JSP ǥ�� �±�
-->

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>
<title>�� ���</title>
</head>
<body>
	<center>
		<h1><spring:message code="user.boardList.list"/></h1>
		<h3>
			<font color='red'>${user.name }</font><spring:message code="user.boardList.welcome"/> <a href='logout.do'>Log-out</a>
		</h3>
		<!-- �˻� ���� -->
		<form action='getBoardList.do' method='post'>
			<table border='1' cellpadding='0' cellspacing='0' width='700'>
				<tr>
					<td align='right'><select name='searchCondition'>
							<option value='TITLE'>
							<c:if test="${search.searchCondition=='TITLE' }">selected="selected"</c:if><spring:message code="user.boardList.title"/></option>
							<option value='CONTENT'>
							<c:if test="${search.searchCondition=='CONTENT' }">selected="selected"</c:if><spring:message code="user.boardList.content"/></option>
					</select> 
					<input name='searchKeyword' type='text' value="${search.searchKeyword}"/>
					<input type='submit' value='�˻�' /></td>
				</tr>
			</table>
		</form>
		<!-- �˻� ���� -->
		<table border='1' cellpadding='0' cellspacing='0' width='700'>
			<tr>
				<th bgcolor='orange' width='100'><spring:message code="user.boardList.seq"/></th>
				<th bgcolor='orange' width='200'><spring:message code="user.boardList.writer"/></th>
				<th bgcolor='orange' width='150'><spring:message code="user.boardList.content"/></th>
				<th bgcolor='orange' width='150'><spring:message code="user.boardList.regDate"/></th>
				<th bgcolor='orange' width='100'><spring:message code="user.boardList.cnt"/></th>
			</tr>
			
			<c:forEach var="board" items="${boardList }">
			<tr>
				<td>${board.seq }</td>
				<td align='left'><a href='getBoard.do?seq=${board.seq }'>${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.regDate }</td>
				<td>${board.cnt }</td>$
			</tr>
			</c:forEach>
			
		</table>
		<br> <a href='insertBoard.do'><spring:message code="user.boardList.new"/></a>
	</center>
</body>
</html>