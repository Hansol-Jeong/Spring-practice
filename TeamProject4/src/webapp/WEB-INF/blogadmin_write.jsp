<%@page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JBlog �� �ۼ�</title>
<Link rel="stylesheet" href="css/theme.css">
</head>

<body background="images/kubrickbgcolor.jpg">
	<center>
		<table background="images/kubrickheader.jpg" width="760" height="200"
			border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="60">&nbsp;</td>
			</tr>
			<!-- ���α� ����� �±� ���� -->
			<tr>
				<td height="60" class="blogtitle">Gurum ���α�</td>
			</tr>
			<tr>
				<td height="20" class="blogtag">�ڹ�, ������, �ƹ��ų�</td>
			</tr>
			<!-- ���α� ����� �±� �� -->
			<tr>
				<td align="right" height="60">
					<a href="logout.do">�α׾ƿ�</a>&nbsp;&nbsp;
					<a href="blogMain.do">�� ���α� ����</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
		</table>
		
		<table background="images/kubrickbg.jpg" width="760" height="40" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="10" colspan="10">&nbsp;</td>
			</tr>
			<tr>
				<td height="10" width="20">&nbsp;</td>
				<td width="530" valign="top" class="tdcontent">
					<!-- �޴� ���� --> 
					<a class="title" href="#"><b>�⺻����</b></a>&nbsp;&nbsp;
					<a class="title" href="#"><b>ī�װ���</b></a>&nbsp;&nbsp;
					<b>���ۼ�</b>&nbsp;&nbsp; 
					<a class="title" href="#"><b>���α׻���</b></a>&nbsp;&nbsp;
					<!-- �޴� �� -->
				</td>
			</tr>
			<tr>
				<td height="5">&nbsp;</td>
			</tr>
			<tr>
				<td height="10">&nbsp;</td>
				<td>
					<form action="addPost.do" method="post">
						<table width="720" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td width="50" class="inputlabel">���� :</td>
								<td width="390"><input class="inputtext" type="text" size="60" name="title"></td>
								<td width="300">
									<select class="inputtextarea">
										<option>�̺з�</option>
										<option>�ڹ�</option>
										<option>������ �����ӿ�ũ</option>
									</select>
								</td>
							</tr>
							<tr>
								<td width="50" class="inputlabel">���� :</td>
								<td colspan="10"><textarea name="content" class="inputtextarea" rows="10" cols="100"></textarea></td>
							</tr>
							<tr>
								<td height="5">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="10" align="center">&nbsp;<input type="submit" value="Ȯ��"></td>
							</tr>
						</table>
					</form> 
				</td>
			</tr>
			<tr>
				<td height="10" colspan="10">&nbsp;</td>
			</tr>
		</table>
		<table background="images/kubrickfooter.jpg" width="760" height="63" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td class="blogfooter">J2EE �̾߱� is powered by JBlog</td>
			</tr>
		</table>
	</center>

</body>
</html>