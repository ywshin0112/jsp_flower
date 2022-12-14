<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 고객 게시판</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
<!-- <link rel="stylesheet" href="css/bouquet.css"> -->
<link rel="stylesheet" href="css/slick.css">
</head>
<body>
	<jsp:include page="/flower/header.jsp"></jsp:include>
	<main class="container">
		<ul class="category">
			<li>카테고리</li>
			<li><a href="/flower/bouquet.jsp">꽃다발</a></li>
			<li><a href="/flower/basket.jsp">꽃바구니</a></li>
			<li><a href="/flower/moneyBox.jsp">용돈박스</a></li>
			<li><a href="/flower/weddingBouquet.jsp">웨딩부케</a></li>
			<li><a href="/flower/plant.jsp">관엽식물</a></li>
		</ul>

		<div class="title">
			<h1>꽃다발 상품</h1>
		</div>

		<ul class="main">
			<li><a href="/flowerbouquet1.jsp"><img
					src="image/bouquet1.jpg" alt="">
					<h3>기본 꽃다발</h3> <span>40,000원</span></a></li>
			<li><a href="#"><img src="image/bouquet2.jpg" alt="">
					<h3>빨간 장미 꽃다발</h3> <span>40,000원</span></a></li>
			<li><a href="#"><img src="image/bouquet3.jpg" alt="">
					<h3>튤립 꽃다발</h3> <span>50,000원</span></a></li>
			<li><a href="#"><img src="image/bouquet4.jpg" alt="">
					<h3>프로포즈 꽃다발</h3> <span>40,000원</span></a></li>
			<li><a href="#"><img src="image/bouquet5.jpg" alt="">
					<h3>카라 믹스 꽃다발</h3> <span>50,000원</span></a></li>
			<li><a href="#"><img src="image/bouquet6.jpg" alt="">
					<h3>장미 꽃다발</h3> <span>40,000원</span></a></li>
		</ul>

	</main>
	<jsp:include page="/flower/footer.jsp"></jsp:include>
	<script src="js/main.js"></script>
</body>
</html>