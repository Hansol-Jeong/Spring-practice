<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JBlog 시스템관리</title>
<Link rel="stylesheet" href="css/theme.css">

</head>
<body class="blogsystem_search">
	<center>
		<form action="blogsystem_search.do" method="GET">
			<table width="100%" height=320 border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height=40 colspan="10">&nbsp;</td>
				</tr>
				<tr>
					<td width="100%" height="120" colspan="10" align="center"><img
						class="blogsystem_img" src="images/stich.png" border="0"
						width="200" height="200"></td>
				</tr>
				<div id="menu">
					<div class="hamburger">
						<div class="line"></div>
						<div class="line"></div>
						<div class="line"></div>
					</div>
					<div class="menu-inner">
						<ul>
							<sec:authorize access="isAnonymous()">
								<li class="li"><a href="/login"><b>로그인</b></a> </li>
								<li class="li"><a href="/createUser.do"><b>회원가입</b></a> </li>
							</sec:authorize>
							<sec:authorize access="isAuthenticated()">
								<li class="li"><a href="/logout"><b>로그아웃</b></a></li>
								<li class="li"><a href="/blogcreate.do"><b>블로그 등록</b></a></li>
								<li class="li"><a href="/blogmain_detail.do"><b>내
											블로그로 가기</b></a></li>
								<c:if test="${loginUser==blogUser}">
									<li class="li"><a href="blogadmin_basic.do"><b>블로그
												시스템 관리</b></a></li>
								</c:if>
										<li class="li"><a href="/deleteUser.do"><b>회원 탈퇴</b></a></li>
							</sec:authorize>
						</ul>
					</div>
					<svg version="1.1" id="blob" xmlns="http://www.w3.org/2000/svg"
						xmlns:xlink="http://www.w3.org/1999/xlink"> <path
						id="blob-path" d="M60,500H0V0h60c0,0,20,172,20,250S60,900,60,500z" />
					</svg>
				</div>
			</table>

			<!-- 블로그 검색 시작  -->
			<table width="760" height="40" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="5" colspan="10">&nbsp;</td>
				</tr>
				<tr>

					<td width="50%"><input type="text" name="searchKeyword"
						size="50"></td>
					<td align='left'><select name='searchCondition'>
							<option value='TITLE'>
								<c:if test="${search.searchCondition=='TITLE' }"></c:if>title
							</option>
							<option value='BLOGGER'>
								<c:if test="${search.searchCondition=='BLOGGER' }"></c:if>blogger
							</option>
							<option value='TAG'>
								<c:if test="${search.searchCondition=='TAG' }"></c:if>tag
							</option>
					</select></td>

					<td width="30%">&nbsp;<input type="submit" value="검색"></td>
				</tr>
				<tr>
					<td height="10" colspan="10">&nbsp;</td>
				</tr>
			</table>
			<!-- 블로그 검색 끝 -->

			<!-- 작업 화면  시작 -->
			<table width="720" height="100" border="1" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="50" class="tablelabel">번호</td>
					<td width="270" class="tablelabel">블로그 제목</td>
					<td width="100" class="tablelabel">블로거</td>
					<td width="100" class="tablelabel">로고</td>
					<sec:authorize access="hasRole('ADMIN')">
						<td width="100" class="tablelabel">상태</td>
						<td width="100" class="tablelabel">삭제</td>
					</sec:authorize>
				</tr>
				<c:forEach var="blog" items="${blogList}">
					<tr>
						<td class="tablecontent" align="center">${blog.blogId }</td>
						<td class="tablecontent"><a
							href="/blogmain_detail2.do?userId=${blog.blog_User.userId }">${blog.blogTitle }</a></td>
						<td class="tablecontent" align="center">${blog.blog_User.name}</td>
						<td class="tablecontent" align="center"><img height="32"
							src="images/${blog.blogFileName }.jpg" border="0" onerror="this.src='images/buzz.jpg'"></td>
						<sec:authorize access="hasRole('ADMIN')">
							<td class="tablecontent" align="center">${blog.status}</td>
							<td class="tablecontent" align="center">&nbsp;</td>
						</sec:authorize>
					</tr>
				</c:forEach>

			</table>
		</form>
	</center>
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

								curveX = easeOutExpo(xitteration, curveX,
										targetX - curveX, 100);
								curveY = easeOutExpo(yitteration, curveY, y
										- curveY, 100);

								var anchorDistance = 200;
								var curviness = anchorDistance - 40;

								var newCurve2 = "M60," + height + "H0V0h60v"
										+ (curveY - anchorDistance) + "c0,"
										+ curviness + "," + curveX + ","
										+ curviness + "," + curveX + ","
										+ anchorDistance + "S60," + (curveY)
										+ ",60,"
										+ (curveY + (anchorDistance * 2)) + "V"
										+ height + "z";

								blobPath.attr('d', newCurve2);

								blob.width(curveX + 60);

								hamburger.css('transform', 'translate('
										+ curveX + 'px, ' + curveY + 'px)');

								$('h2').css('transform',
										'translateY(' + curveY + 'px)');
								window.requestAnimationFrame(svgCurve);
							}

							window.requestAnimationFrame(svgCurve);

						});
	</script>
</body>
</html>