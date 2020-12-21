<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JBlog �⺻���� ����</title>
<Link rel="stylesheet" href="css/theme.css">
</head>

<body class="blogadmin_basic">
	<div id="menu">
		<div class="hamburger">
			<div class="line"></div>
			<div class="line"></div>
			<div class="line"></div>
		</div>
		<div class="menu-inner">
			<ul>
				<sec:authorize access="isAuthenticated()">
					<li class="li"><a href="/logout"><b>�α׾ƿ�</b></a></li>
					<li class="li"><a href="/blogcreate.do"><b>��α� ���</b></a></li>
					<li class="li"><a href="/blogmain_detail.do"><b>�� ��α׷�
								����</b></a></li>
					<li class="li"><a href="/blogsystem_search.do"><b>��α�
								�˻�</b></a></li>
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
				<td align="center" height="60" class="blogtitle">${blog.blogTitle }</td>
			</tr>
			<tr>
				<td height="20" class="blogtag"><c:forEach var="tag"
						items="${tagList }">

						<td class="blogtag">${tag }</td>

					</c:forEach></td>
			</tr>
			<!-- ��α� ����� �±� �� -->

			<tr>
				<td align="right" height="60"></td>
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
					<!-- �޴� ���� --> <a class="title disabled" href="/blogadmin_basic.do"><b>�⺻����</b></a>&nbsp;&nbsp;
					<a class="title" href="/blogadmin_category.do"><b>ī�װ�</b></a>&nbsp;&nbsp;
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
					<form action="updateBlog.do" method="post">
						<table width="720" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td width="150" class="inputlabel">��α� ���� :</td>
								<td><input class="inputtext" type="text" size="40"
									name="blogTitle"></td>
							</tr>
							<tr>
								<td width="150" class="inputlabel">��α� �±� :</td>
								<td><input class="inputtext" type="text" size="50"
									name="blogTag"></td>
							</tr>
							<tr>
								<td width="150" class="inputlabel">���������� ����Ʈ :</td>
								<td><input class="inputtext" type="text" size="4"
									name="blogDisplayCount"></td>
							</tr>
							<tr>
								<td width="150" class="inputlabel">�ΰ��̹��� :</td>
								<td>&nbsp;<img height="80" src="images/${blog.blogFileName}.jpg" border="0" onerror="this.src='images/buzz.jpg'"></td></td>
							</tr>
							<tr>
								<td width="150" class="inputlabel">&nbsp;</td>
								<td><input class="inputtext" type="text" size="40"
									name="blogFileName"> <input type="submit" value="ã�ƺ���"></td>
							</tr>
							<tr>
								<td height="40" colspan="10" align="center"><input
									type="submit" value="Ȯ��"></td>
							</tr>
						</table>
					</form> <!-- �۾� ȭ��  �� -->
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