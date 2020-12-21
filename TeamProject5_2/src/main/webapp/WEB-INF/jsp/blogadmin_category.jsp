<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JBlog ī�װ� ����</title>
<Link rel="stylesheet" href="css/theme.css">
</head>

<body class="category">
	<div id="menu">
		<div class="hamburger">
			<div class="line"></div>
			<div class="line"></div>
			<div class="line"></div>
		</div>
		<div class="menu-inner">
			<ul>
				<sec:authorize access="isAnonymous()">
					<li class="li"><a href="/login"><b>�α���</b></a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="li"><a href="/logout"><b>�α׾ƿ�</b></a></li>
					<li class="li"><a href="/blogcreate.do"><b>��α� ���</b></a></li>
					<li class="li"><a href="/blogmain_detail.do"><b>�� ��α׷�
								����</b></a></li>
					<li class="li"><a href="/deleteUser.do"><b>ȸ�� Ż��</b></a></li>
				</sec:authorize>
			</ul>
		</div>
		<svg version="1.1" id="blob" xmlns="http://www.w3.org/2000/svg"
			xmlns:xlink="http://www.w3.org/1999/xlink"> <path
			id="blob-path" d="M60,500H0V0h60c0,0,20,172,20,250S60,900,60,500z" />
		</svg>
	</div>
	<center>
		<table background="images/kubrickheader.jpg" width="760" height="200"
			border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="60">&nbsp;</td>
			</tr>
			<!-- ��α� ����� �±� ���� -->
			<tr>
				<td height="60" class="blogtitle">${blog.blogTitle }</td>
			</tr>
			<tr>
				<td height="20" class="blogtag"><c:forEach var="tag"
						items="${tagList }">

						<td class="blogtag">${tag }</td>

					</c:forEach></td>
			</tr>
			<!-- ��α� ����� �±� �� -->
			<tr height="60">

			</tr>
		</table>
		<table background="images/kubrickbg.jpg" width="760" height="40"
			border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="10" colspan="10">&nbsp;</td>
			</tr>
			<tr>
				<td height="10" width="20">&nbsp;</td>
				<td width="530" valign="top" class="tdcontent">
					<!-- �޴� ���� --> <a class="title " href="/blogadmin_basic.do"><b>�⺻����</b></a>&nbsp;&nbsp;
					<a class="title disabled" href="/blogadmin_category.do"><b>ī�װ�</b></a>&nbsp;&nbsp;
					<a class="title" href="/blogadmin_write.do"><b>���ۼ�</b></a>&nbsp;&nbsp;
					<a class="title" href="/blogadmin_request_remove.do"><b>��α׻���</b></a>&nbsp;&nbsp;
					<!-- �޴� �� -->
				</td>
			</tr>
			<tr>
				<td height="5">&nbsp;</td>
			</tr>
			<tr>
				<td height="10">&nbsp;</td>
				<td>
					<!-- �۾� ȭ��  ���� -->
					<table width="720" border="1" cellpadding="0" cellspacing="0">
						<tr>
							<td width="50" class="tablelabel">��ȣ</td>
							<td width="150" class="tablelabel">ī�װ���</td>
							<td width="80" class="tablelabel">���̱� ����</td>
							<td width="70" class="tablelabel">����Ʈ ��</td>
							<td width="280" class="tablelabel">����</td>
							<td width="70" class="tablelabel">����</td>
						</tr>
						<c:forEach var="category" items="${categoryList }">
							<tr>
								<td class="tablecontent" align="center">${category.categoryId }</td>
								<td class="tablecontent"><a
									href="/category.do?categoryName=${category.categoryName }">${category.categoryName }</a></td>
								<td class="tablecontent" align="center">${category.categoryDisplayType }</td>
								<td class="tablecontent" align="center">${category.categoryDisplayCount }</td>
								<td class="tablecontent">${category.categoryDescription }</td>
								<td class="tablecontent" align="center">&nbsp; <a
									href="/deleteCategory.do"><img height="9"
										src="images/delete.jpg" border="0"></a>
								</td>
							</tr>
						</c:forEach>
					</table>

					<form action="/updateCategory.do" method="post">
						<table width="720" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td height="5">&nbsp;</td>
							</tr>
							<tr>
								<td height="5">&nbsp;</td>
							</tr>
							<tr>
								<td class="tdcontent" height="5"><b>ī�װ� ����</b></td>
							</tr>
							<tr>
								<td height="5">&nbsp;</td>
							</tr>
							<tr>






								<td width="150" class="inputlabel">ī�װ��� :</td>
								<td><input class="inputtext" type="text" size="40"
									name=categoryName /></td>
							</tr>
							<tr>
								<td width="150" class="inputlabel">���̱� ���� :</td>
								<td align='left'><select name='categoryDisplayType'>
										<option value='Title'>Title</option>
										<option value='Text'>Text</option>
								</select></td>
							</tr>
							<tr>
								<td width="150" class="inputlabel">����Ʈ �� :</td>
								<td class="tdcontent"><input class="inputtext" type="text"
									size="4" name="categoryDisplayCount">��(1~20)</td>
							</tr>
							<tr>
								<td width="150" class="inputlabel">���� :</td>
								<td><input class="inputtext" type="text" size="50"
									name="categoryDescription"></td>
							</tr>
							<tr>
								<td height="5">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="10" align="center">&nbsp; <input type="submit"
									value="ī�װ� ���� ����"></td>
							</tr>
						</table>
					</form>

					<form action="/addCategory.do" method="post">
						<table width="720" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td height="5">&nbsp;</td>
							</tr>
							<tr>
								<td height="5">&nbsp;</td>
							</tr>
							<tr>
								<td class="tdcontent" height="5"><b>���ο� ī�װ� �߰�</b></td>
							</tr>
							<tr>
								<td height="5">&nbsp;</td>
							</tr>
							<tr>
								<td width="150" class="inputlabel">ī�װ��� :</td>
								<td><input class="inputtext" type="text" size="40"
									name="categoryName"></td>
							</tr>
							<tr>
								<td width="150" class="inputlabel">���̱� ���� :</td>
								<td align='left'><select name='categoryDisplayType'>
										<option value='Title'>Title</option>
										<option value='Text'>Text</option>
								</select></td>
							</tr>
							<tr>
								<td width="150" class="inputlabel">����Ʈ �� :</td>
								<td class="tdcontent"><input class="inputtext" type="text"
									size="4" name="categoryDisplayCount">��(1~20)</td>
							</tr>
							<tr>
								<td width="150" class="inputlabel">���� :</td>
								<td><input class="inputtext" type="text" size="50"
									name="categoryDescription"></td>
							</tr>
							<tr>
								<td height="5">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="10" align="center">&nbsp;<input type="submit"
									value="ī�װ� �߰�"></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr>
				<td height="10" colspan="10">&nbsp;</td>
			</tr>
		</table>

		<table background="images/kubrickfooter.jpg" width="760" height="63"
			border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td class="blogfooter">J2EE �̾߱� is powered by JBlog</td>
			</tr>
		</table>
	</center>

</body>
<script src="//code.jquery.com/jquery-2.1.1.min.js"></script>
<script>
	$(window)
			.load(
					function() {
						var height = window.innerHeight, x = 0, y = height / 2, curveX = 10, curveY = 0, targetX = 0, xitteration = 0, yitteration = 0, menuExpanded = false;

						blob = $('#blob'), blobPath = $('#blob-path'),

						hamburger = $('.hamburger');

						$(this).on('mousemove', function(e) {
							x = e.pageX;

							y = e.pageY;
						});

						$('.hamburger, .menu-inner').on('mouseenter',
								function() {
									$(this).parent().addClass('expanded');
									menuExpanded = true;
								});

						$('.menu-inner').on('mouseleave', function() {
							menuExpanded = false;
							$(this).parent().removeClass('expanded');
						});

						function easeOutExpo(currentIteration, startValue,
								changeInValue, totalIterations) {
							return changeInValue
									* (-Math.pow(2, -10 * currentIteration
											/ totalIterations) + 1)
									+ startValue;
						}

						var hoverZone = 150;
						var expandAmount = 20;

						function svgCurve() {
							if ((curveX > x - 1) && (curveX < x + 1)) {
								xitteration = 0;
							} else {
								if (menuExpanded) {
									targetX = 0;
								} else {
									xitteration = 0;
									if (x > hoverZone) {
										targetX = 0;
									} else {
										targetX = -(((60 + expandAmount) / 100) * (x - hoverZone));
									}
								}
								xitteration++;
							}

							if ((curveY > y - 1) && (curveY < y + 1)) {
								yitteration = 0;
							} else {
								yitteration = 0;
								yitteration++;
							}

							curveX = easeOutExpo(xitteration, curveX, targetX
									- curveX, 100);
							curveY = easeOutExpo(yitteration, curveY, y
									- curveY, 100);

							var anchorDistance = 200;
							var curviness = anchorDistance - 40;

							var newCurve2 = "M60," + height + "H0V0h60v"
									+ (curveY - anchorDistance) + "c0,"
									+ curviness + "," + curveX + ","
									+ curviness + "," + curveX + ","
									+ anchorDistance + "S60," + (curveY)
									+ ",60," + (curveY + (anchorDistance * 2))
									+ "V" + height + "z";

							blobPath.attr('d', newCurve2);

							blob.width(curveX + 60);

							hamburger.css('transform', 'translate(' + curveX
									+ 'px, ' + curveY + 'px)');

							$('h2').css('transform',
									'translateY(' + curveY + 'px)');
							window.requestAnimationFrame(svgCurve);
						}

						window.requestAnimationFrame(svgCurve);

					});
</script>
</html>