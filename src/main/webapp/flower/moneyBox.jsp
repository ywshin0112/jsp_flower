<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 용돈박스</title>
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
			<h1>용돈박스 상품</h1>
		</div>

		<ul class="main">
			<li><a href="#"><img src="../image/moneyBox1.jpg" alt="">
				<h3>핑크 용돈박스</h3>
					<span>50,000원</span></a></li>
			<li><a href="#"><img src="../image/moneyBox2.jpg" alt="">
				<h3>옐로 용돈박스</h3>
					<span>50,000원</span></a></li>
			<li><a href="#"><img src="../image/moneyBox3.jpg" alt="">
				<h3>파스텔 용돈박스</h3>
					<span>50,000원</span></a></li>
			<li><a href="#"><img src="../image/moneyBox4.jpg" alt="">
				<h3>블루 센터피스</h3>
					<span>40,000원</span></a></li>
			<li><a href="#"><img src="../image/moneyBox5.jpg" alt="">
				<h3>파스텔 센터피스</h3>
					<span>40,000원</span></a></li>
			<li><a href="#"><img src="../image/moneyBox6.jpg" alt="">
				<h3>레드 센터피스</h3>
					<span>40,000원</span></a></li>
		</ul>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="../js/main.js"></script>
</body>
</html>