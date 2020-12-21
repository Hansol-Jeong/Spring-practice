<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<div id="menu">
					<div class="hamburger">
						<div class="line"></div>
						<div class="line"></div>
						<div class="line"></div>
					</div>
					<div class="menu-inner">

						<ul>
							<li class="li"><c:if test="${sessionScope.user==null}">
									<a href="/login.do"><b>로그인</b></a>
								</c:if> <c:if test="${sessionScope.user!=null}">
									<a href="/logout.do"><b>로그아웃</b></a>
								</c:if></li>
							<li class="li"><a href="/blogcreate.do"><b>블로그등록</b></a></li>
							<li class="li"><a href="/blogmain_detail.do"><b>내 블로그로 가기</b></a></li>
						</ul>
					</div>
					<svg version="1.1" id="blob" xmlns="http://www.w3.org/2000/svg"
						xmlns:xlink="http://www.w3.org/1999/xlink"> <path
						id="blob-path" d="M60,500H0V0h60c0,0,20,172,20,250S60,900,60,500z" />
					</svg>
				</div>
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
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>JBlog 로그인</title>
	<Link rel="stylesheet" href="css/theme.css">
</head>
<body>

	<form action="addBlog.do" method="post">		
    <table width="100%" height=320 border="0" cellpadding="0" cellspacing="0">
      <tr>
      	<td height=40 colspan="10">&nbsp;</td>
      </tr>
      <tr>
        <td width="100%" height="120"colspan="10" align="center">
        <img src="images/logo.jpg" border="0"></td>
      </tr>  
      <tr>
      	<td height="20" colspan="10" align="center" class="tdcontent">
      	블로그 제목 : <input type="text" name="blogTitle" size="40">&nbsp;&nbsp;
      	</td>
      </tr>
      <tr>
      	<td height="40" colspan="10" align="center">
      	<input type="submit" value="확인">&nbsp;&nbsp;<input type="submit" value="취소">
		</td>
      </tr>      
      <tr> 
      	<td colspan="10">&nbsp;</td>
      </tr>
    </table>
   	</form>
   	
</body>
</html>
