<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>���۵��</title>
</head>
<body>
<center>
	<h1><spring:message code="user.insertBoard.regi"/></h1>
<!-- 	�� ��� ȭ���� ���� ���ε� ������ ȭ������ �����Ѵ�. <form>���� �±׿� method="post"���� �ϰ� get����� ���� ���ε带 �������� �ʴ´�.
	�׸��� ecntype="multipart/form-data"�Ӽ��� �����Ǿ�� �� form�� ���ε� ����� �����ϴ� ���̴�. -->
	<hr>
		<form action="insertBoard.do" method="post" enctype="multipart/form-data"> <!-- ���� ���ε尡 ������ ȭ���� ����� -->
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="orange" width="70"><spring:message code="user.insertBoard.title"/></td><td align="left">
				<input type="text" name="title" value="${boardVO.title}"/></td>
			</tr>
			<tr>
				<td bgcolor="orange"><spring:message code="user.insertBoard.writer"/></td><td align="left">
				<input type="text" name="writer" size="10"  value="${boardVO.writer}"/></td>
			</tr>
			<tr>
				<td bgcolor="orange"><spring:message code="user.insertBoard.content"/></td><td align="left">
				<textarea name="content" cols="40" rows="10"> ${boardVO.content}</textarea></td>
			
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value=" ���� ��� "/></td>
			</tr>
		
		</table>
		</form>
	<hr>
</center>
</body>
</html>

    