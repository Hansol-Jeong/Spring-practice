<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>새글등록</title>
</head>
<body>
<center>
	<h1><spring:message code="user.insertBoard.regi"/></h1>
<!-- 	글 등록 화면을 파일 업로드 가능한 화면으로 수정한다. <form>시작 태그에 method="post"여야 하고 get방식은 파일 업로드를 지원하지 않는다.
	그리고 ecntype="multipart/form-data"속성이 설정되어야 이 form이 업로드 기능을 지원하는 것이다. -->
	<hr>
		<form action="insertBoard.do" method="post" enctype="multipart/form-data"> <!-- 파일 업로드가 가능한 화면을 만든다 -->
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
				<input type="submit" value=" 새글 등록 "/></td>
			</tr>
		
		</table>
		</form>
	<hr>
</center>
</body>
</html>

    