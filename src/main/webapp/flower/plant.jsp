<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 관엽식물</title>
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
			<h1>관엽식물 상품</h1>
		</div>

		<ul class="main">
			<li><a href="#"><img src="../image/plant1.jpg" alt="">
					<h3>여인초</h3>
					<span>70,000원</span></a></li>
			<li><a href="#"><img src="../image/plant2.jpg" alt="">
					<h3>점박이 크로톤</h3>
					<span>40,000원</span></a></li>
			<li><a href="#"><img src="../image/plant3.jpg" alt="">
					<h3>칼라데아 마코야나</h3>
					<span>50,000원</span></a></li>
			<li><a href="#"><img src="../image/plant4.jpg" alt="">
					<h3>금전수</h3>
					<span>40,000원</span></a></li>
			<li><a href="#"><img src="../image/plant5.jpg" alt="">
					<h3>몬스테라</h3>
					<span>50,000원</span></a></li>
			<li><a href="#"><img src="../image/plant6.jpg" alt="">
					<h3>벤자민</h3>
					<span>50,000원</span></a></li>
		</ul>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="../js/main.js"></script>
</body>
</html>