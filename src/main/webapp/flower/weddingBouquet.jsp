<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 웨딩부케</title>
<link rel="stylesheet" href="../css/reset.css">
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/footer.css">
<link rel="stylesheet" href="../css/bouquet.css">
<link rel="stylesheet" href="../css/slick.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container">
		<ul class="category">
			<li>카테고리</li>
			<li><a href="bouquet.jsp">꽃다발</a></li>
			<li><a href="basket.jsp">꽃바구니</a></li>
			<li><a href="moneyBox.jsp">용돈박스</a></li>
			<li><a href="weddingBouquet.jsp">웨딩부케</a></li>
			<li><a href="plant.jsp">관엽식물</a></li>
		</ul>

		<div class="title">
			<h1>웨딩 부케</h1>
		</div>

		<ul class="main">
			<li><a href="#"><img src="../image/wedding_bouquet1.jpg"
					alt="">
				<h3>장미 부케</h3>
					<span>200,000원</span></a></li>
			<li><a href="#"><img src="../image/wedding_bouquet2.jpg"
					alt="">
				<h3>카라 장미 부케</h3>
					<span>200,000원</span></a></li>
			<li><a href="#"><img src="../image/wedding_bouquet3.jpg"
					alt="">
				<h3>튤립 장미 부케</h3>
					<span>200,000원</span></a></li>
			<li><a href="#"><img src="../image/wedding_bouquet4.jpg"
					alt="">
				<h3>세미 촬영 부케</h3>
					<span>200,000원</span></a></li>
			<li><a href="#"><img src="../image/wedding_bouquet5.jpg"
					alt="">
				<h3>카라 믹스 부케</h3>
					<span>200,000원</span></a></li>
			<li><a href="#"><img src="../image/slider04.jpg" alt="">
				<h3>본식 부케</h3>
					<span>300,000원</span></a></li>
		</ul>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="../js/main.js"></script>
</body>
</html>