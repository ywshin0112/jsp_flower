<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/header.css">
</head>
<body>
<%-- 	<%
	String category = "../";
	if (request.getServletPath().equals("/index.jsp")) {
		category = "";

	}
	System.out.println("경로 : " + request.getContextPath());
	System.out.println("경로2 : " + request.getRequestURI());
	%> --%>


	<header>
		<div class="header">
			<div class="logo">
				<a href="index.jsp"><img src="image/logo.png" alt=""></a>
			</div>
			<div class="asideButton">
				<div></div>
				<div></div>
				<div></div>
				<div></div>
			</div>
			<div class="mainAside">
				<div class=login>
					<ul>
						<c:choose>
							<c:when test="${!empty flowerClient}">
								<li class="visible loginTop"><a href="FlowerServlet?command=mypage">마이페이지</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="FlowerServlet?command=login_page">마이페이지</a></li>
							</c:otherwise>
						</c:choose>

						<li><a href="delivery.jsp" onclick="return alarm()">주문배송조회</a></li>
						<li><a href="shoppingBasket.jsp" onclick="return alarm()">장바구니</a></li>
						<c:if test="${empty flowerClient}">
							<li><a href="FlowerServlet?command=membership_page">회원가입</a></li>
							<li class="visible loginTop"><a
								href="FlowerServlet?command=login_page">로그인</a></li>
						</c:if>
						<c:if test="${!empty flowerClient}">
							<li class="visible"><a
								href="FlowerServlet?command=logout">로그아웃</a></li>
							<c:if test="${flowerClient.lev eq 'A'}">
								<li class="visible"><a
									href="FlowerServlet?command=flower_product_form">관리자페이지</a></li>
							</c:if>
							<li><a href="FlowerServlet?command=mypage">${flowerClient.name}</a>님
								환영합니다.</li>
						</c:if>
					</ul>
				</div>

				<div class=gnb>
					<ul>
					
					<c:forEach var="categoryVO" items="${mainList}">
								<li><a href="FlowerServlet?command=flower_main_product_form&category=${categoryVO.category}">${categoryVO.category}</a></li>
					</c:forEach>
						
						
						<!-- <li><a href="FlowerServlet?command=flower_plant">전체보기</a></li> -->
						<li><a href="FlowerServlet?command=client_board_form">고객 게시판</a></li>
					</ul>
				</div>
			</div>

		</div>
	</header>

	<div class="headerMargin"></div>

</body>
</html>