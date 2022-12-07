<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 꽃바구니</title>
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

    <div class="title"><h1>꽃바구니 상품</h1></div>

    <ul class="main">
      <li><a href="basket1.jsp"><img src="../image/basket1.jpg" alt=""><h3>믹스 꽃바구니</h3><span>100,000원</span></a></li>
      <li><a href="#"><img src="../image/basket2.jpg" alt=""><h3>수국 꽃바구니</h3><span>80,000원</span></a></li>
      <li><a href="#"><img src="../image/basket3.jpg" alt=""><h3>해바라기 꽃바구니</h3><span>80,000원</span></a></li>
      <li><a href="#"><img src="../image/basket4.jpg" alt=""><h3>L 사이즈 꽃바구니</h3><span>100,000원</span></a></li>
      <li><a href="#"><img src="../image/basket5.jpg" alt=""><h3>M 사이즈 꽃바구니</h3><span>80,000원</span></a></li>
      <li><a href="#"><img src="../image/basket6.jpg" alt=""><h3>미니 꽃바구니</h3><span>50,000원</span></a></li>
    </ul>
  </main>
  	<script src="../js/main.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>