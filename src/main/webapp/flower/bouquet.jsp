<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 꽃다발</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/bouquet.css">
<link rel="stylesheet" href="css/slick.css">
</head>
<body>
	<jsp:include page="/flower/header.jsp"></jsp:include>
	<main class="container">
		<ul class="category">
			<li>카테고리</li>
			<c:forEach var="categoryVO" items="${mainList}">
				<li><a
					href="FlowerServlet?command=flower_main_product_form&category=${categoryVO.category}">${categoryVO.category}</a></li>
			</c:forEach>
		</ul>

		<div class="title">
			<h1>
				<c:out value="${category }" />
				상품
			</h1>
		</div>

		<ul class="main">
			<c:forEach var="productVO" items="${detailList}">
				<li><a
					href="FlowerServlet?command=flower_buy_form&code=${productVO.code}">
						<img src="image/${productVO.image}">
						<h3>${productVO.name}</h3> <span>${productVO.price}원</span>
				</a></li>
			</c:forEach>

		</ul>
	</main>
	<jsp:include page="/flower/footer.jsp"></jsp:include>
	<script src="js/main.js"></script>
</body>
</html>