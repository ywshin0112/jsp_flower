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
	<%
	String category = "../";
 if(request.getServletPath().equals("/index.jsp")){
	 category="";

 }
 System.out.println("경로 : " + request.getContextPath());
 System.out.println("경로2 : " + request.getRequestURI());
 
%>


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
						<li><a href="FlowerServlet?command=mypage">마이페이지</a></li>
						<li><a href="delivery.jsp">주문배송조회</a></li>
						<li><a href="shoppingBasket.jsp">장바구니</a></li>
						<c:if test="${empty flowerClient}">
							<li><a href="FlowerServlet?command=membership_page">회원가입</a></li>
							<li class="visible loginTop"><a href="FlowerServlet?command=login_page">로그인</a></li>
						</c:if>
						<c:if test="${!empty flowerClient}">
							<li class="visible loginTop"><a href="FlowerServlet?command=logout">로그아웃</a></li>
							<c:if test="${flowerClient.lev eq 'A'}">
								<li class="visible"><a href="#">관리자페이지</a></li>
							</c:if>
							<li><a href="FlowerServlet?command=mypage">${flowerClient.name}</a>님 환영합니다.</li>
						</c:if>
					</ul>
				</div>

				<div class=gnb>
					<ul>
						<li><a href="FlowerServlet?command=flower_bouquet">꽃다발</a></li>
						<li><a href="FlowerServlet?command=flower_basket">꽃바구니</a></li>
						<li><a href="FlowerServlet?command=flower_money_box">용돈박스</a></li>
						<li><a href="FlowerServlet?command=flower_wdding_bouquet">웨딩부케</a></li>
						<li><a href="FlowerServlet?command=flower_plant">관엽식물</a></li>
						<li><a href="jsp/notice.jsp">고객 게시판</a></li>
					</ul>
				</div>
			</div>

		</div>
	</header>
	
	<div class="headerMargin">
	</div>
	
</body>
</html>