<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JBlog �ý��۰���</title>
<Link rel="stylesheet" href="css/theme.css">
</head>

<body>
	<center>
		<form action="#">
			<table width="100%" height=320 border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height=40 colspan="10">&nbsp;</td>
				</tr>
				<tr>
					<td width="100%" height="120" colspan="10" align="center"><img
						src="images/logo.jpg" border="0"></td>
				</tr>
				<tr>
					<td width="30%" height="30">&nbsp;</td>
					<td width="70%" colspan="2"><c:if
							test="${sessionScope.blog_User==null}">
							<a href="/login.do"><b>�α���</b></a>&nbsp;&nbsp;</c:if> <c:if
							test="${sessionScope.blog_User!=null}">
							<a href="/logout.do"><b>�α׾ƿ�</b></a>&nbsp;&nbsp;</c:if> <a
						href="/blogcreate.do"><b>��α׵��</b></a>&nbsp;&nbsp; <a
						href="/blogadmin_basic.do"><b>�� ��α׷� ����</b></a></td>
				</tr>
			</table>


			</table>
		</form>
	</center>
</body>
</html>