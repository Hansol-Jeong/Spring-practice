<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JBlog 블로그 메인</title>
<Link rel="stylesheet" href="css/theme.css">
</head>
<body class="blogmain_detail">

	<div id="menu">
		<div class="hamburger">
			<div class="line"></div>
			<div class="line"></div>
			<div class="line"></div>
		</div>
		<div class="menu-inner">
			<ul>
				<sec:authorize access="isAnonymous()">
					<li class="li"><a href="/login"><b>로그인</b></a> <%-- <c:if test="${sessionScope.user==null}">
                           <a href="/login.do"><b>로그인</b></a>
                        </c:if> <c:if test="${sessionScope.user!=null}">
                           <a href="/logout.do"><b>로그아웃</b></a>
                        </c:if> --%></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="li"><a href="/logout"><b>로그아웃</b></a></li>
					<li class="li"><a href="/blogcreate.do"><b>블로그 등록</b></a></li>
					<li class="li"><a href="/blogmain_detail.do"><b>내 블로그로
								가기</b></a></li>
					<li class="li"><a href="/blogsystem_search.do"><b>블로그
								검색</b></a></li>
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
	<center>
		<table background="images/kubrickheader.jpg" width="760" height="200"
			border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="60">&nbsp;</td>
			</tr>
			<!-- 블로그 제목과 태그 시작 -->
			<tr>
				<td height="60" class="blogtitle">${blog.blogTitle }</td>
			</tr>
			<tr>
				<td height="20" class="blogtag"><c:forEach var="tag"
						items="${tagList }">
						<td height="20" class="blogtag">${tag }</td>
					</c:forEach></td>
			</tr>
			<!-- 블로그 제목과 태그 끝 -->
			<tr>
				<td height="60">&nbsp;</td>
			</tr>
		</table>
		<table background="images/kubrickbg.jpg" width="760" height="300"
			border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="10">&nbsp;</td>
			</tr>
			<tr>
				<td width="20">&nbsp;</td>
				<td width="530" valign="top"><c:if
						test="${clikedPost.postId==null }">
						<c:forEach var="post" items="${postList }">
							<table height="10" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td class="posttitle"><a class="posttitle"
										href="/blogmain_detail.do?postId=${post.postId }">${post.title }</a></td>
								</tr>
								<tr>
									<td class="postdate">${post.regiDate }</td>
								</tr>
								<tr>
									<td class="postcontent">${post.content }</td>
								</tr>
								<tr>
									<td height="5">&nbsp;</td>
								</tr>
								<tr>
									<td class="postwriter">posted by ${blog_User.name}
										${sessionScope.user.name } in ${post.category.categoryName }
										댓글 ${post.commentList.size() }</td>
								</tr>
								<tr>
									<td height="5">&nbsp;</td>
								</tr>
								<c:if test="${clikedPost.postId != null }">
									<tr>
										<td height="5">
											<!-- 덧글 보여주기 시작 -->
											<table height="20" border="0" cellpadding="0" cellspacing="0">
												<c:forEach var="comment" items="${post.commentList }">
													<tr>
														<td class="tdcontent">commented by ${comment.name }
															at ${comment.regiDate }</td>
													</tr>
													<tr>
														<td class="tdcontent">${comment.content }</td>
													</tr>
												</c:forEach>
											</table> <!-- 덧글 보여주기  끝 -->
										</td>
									</tr>
									<tr>
										<td height="5">새 덧글 시작
											<form action="addComment.do" method="GET">
												<table width="500" height="20" border="0" cellpadding="0"
													cellspacing="0">
													<tr>
														<td height="5">&nbsp;</td>
													</tr>
													<tr>
														<td width="120"><input class="inputtext" type="text"
															size="15" name="name"></td>
														<td width="380" class="tdcontent">이름</td>
													</tr>
													<tr>
														<td colspan="10" class="tdcontent"><textarea
																name="content" class="inputtextarea" rows="2" cols="80"></textarea></td>
													</tr>
													<tr>
														<td height="5">&nbsp;</td>
													</tr>

													<tr>
														<td colspan="10" align="right">&nbsp;<input
															type="submit" value="덧글추가"></td>
													</tr>
												</table>
											</form> 새 덧글 끝
										</td>
									</tr>
								</c:if>
								<tr>
									<td height="5">&nbsp;</td>
								</tr>
							</table>
						</c:forEach>
						<!-- 포스트 끝-->
					</c:if> <c:if test="${clikedPost.postId!=null }">

						<table height="10" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="posttitle"><a class="posttitle"
									href="/blogmain_detail.do?postId=${clikedPost.postId }">${clikedPost.title }</a></td>
							</tr>
							<tr>
								<td class="postdate">${clikedPost.regiDate }</td>
							</tr>
							<tr>
								<td class="postcontent">${clikedPost.content }</td>
							</tr>
							<tr>
								<td height="5">&nbsp;</td>
							</tr>
							<tr>
								<td class="postwriter">posted by ${blog_User.name}
									${sessionScope.user.name } in
									${clikedPost.category.categoryName } 댓글
									${clikedPost.commentList.size() }</td>
							</tr>
							<tr>
								<td height="5">&nbsp;</td>
							</tr>
							<tr>
								<td height="5">
									<!-- 덧글 보여주기 시작 -->
									<table height="20" border="0" cellpadding="0" cellspacing="0">
										<c:forEach var="comment" items="${clikedPost.commentList }">
											<tr>
												<td class="tdcontent">commented by ${comment.name } at
													${comment.regiDate }</td>
											</tr>
											<tr>
												<td class="tdcontent">${comment.content }</td>
											</tr>
										</c:forEach>
									</table> <!-- 덧글 보여주기  끝 -->
								</td>
							</tr>
							<tr>
								<td height="5">
									<form action="addComment.do?postId" method="GET">
										<table width="500" height="20" border="0" cellpadding="0"
											cellspacing="0">
											<tr>
												<td height="5">&nbsp;</td>
											</tr>
											<tr>
												<td width="120"><input class="inputtext" type="text"
													size="15" name="name"></td>
												<td width="380" class="tdcontent">이름</td>
											</tr>
											<tr>
												<td colspan="10" class="tdcontent"><textarea
														name="content" class="inputtextarea" rows="2" cols="80"></textarea></td>
											</tr>
											<tr>
												<td height="5">&nbsp;</td>
											</tr>

											<tr>
												<td colspan="10" align="right">&nbsp;<input
													type="submit" value="덧글추가"></td>
											</tr>
										</table>
									</form>
								</td>
							</tr>

							<tr>
								<td height="5">&nbsp;</td>
							</tr>
						</table>
					</c:if></td>
				<td width="20">&nbsp;</td>
				<td width="190" valign="top">
					<!-- 로그인, 관리자 메뉴, 로고, 카테고리 시작 -->

					<table cellpadding="0" cellspacing="0">

						<tr>
							<td height="5">&nbsp;</td>
						</tr>
						<tr>
							<td><img height="80" src="images/${blog.blogFileName}.jpg" border="0" onerror="this.src='images/buzz.jpg'"></td>
						</tr>
						<tr>
							<td height="5">&nbsp;</td>
						</tr>
						<tr>
							<td class="categorytitle">카테고리</td>
						</tr>
						<table>
							<tr>
								<td><c:forEach var="category" items="${categoryList }">
										<form action="/category.do" method="GET">
											<input type="submit" value="${category.categoryName }"
												name="categoryName">
										</form>
									</c:forEach></td>
							</tr>
						</table>
						<tr>
							<td height="5">&nbsp;</td>
						</tr>
						<tr>
							<td align="center"><img width="80" src="images/stich.png"
								border="0"></td>
						</tr>
					</table> <!-- 로그인, 관리자 메뉴, 로고, 카테고리 끝 -->
				</td>
			</tr>
		</table>
		<table background="images/kubrickfooter.jpg" width="760" height="63"
			border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td class="blogfooter">J2EE 이야기 is powered by JBlog</td>
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