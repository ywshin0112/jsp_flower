<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/slick.css">


</head>
<body>

	<jsp:include page="/flower/header.jsp"></jsp:include>


	<div class=container>
		<main>


			<section class="slider00">

				<div class="slider">
					<c:forEach var="MainPageVO" items="${mpvoList}">
						<div>
							<a
								href="FlowerServlet?command=flower_main_product_form&category=${MainPageVO.category}"><h2>${MainPageVO.category}</h2>
								<h3>특별한 당신의 하루에 꽃을 더하다</h3> <img
								src="image/${MainPageVO.mainImage }" alt=""></a>
						</div>
					</c:forEach>

				</div>

				<div class="prevBtn">
					<i class="fa fa-chevron-left" aria-hidden="true"></i>
				</div>
				<div class="nextBtn">
					<i class="fa fa-chevron-right" aria-hidden="true"></i>
				</div>



			</section>


			<c:forEach var="MainPageVO" items="${mpvoList}">

				<section class="boxList">
					<div class="box1">
						<a
							href="FlowerServlet?command=flower_main_product_form&category=${MainPageVO.category}"
							class="hr-sect">${MainPageVO.category} 상품</a>

						<button
							onclick="location.href='FlowerServlet?command=flower_main_product_form&category=${MainPageVO.category}'">더보기>>
						</button>
					</div>

					<div class="box2">
						<ul class="box2_slider">
							<c:forEach var="detailVO" items="${MainPageVO.dlvoList}">
								<li><a
									href="FlowerServlet?command=flower_buy_form&code=${detailVO.code}"><img
										src="image/${detailVO.image }" alt="">
										<h3>${detailVO.name }</h3> <span>${detailVO.price} 원</span></a></li>

							</c:forEach>
						</ul>
					</div>
				</section>


			</c:forEach>


		</main>

		<jsp:include page="/flower/footer.jsp"></jsp:include>


		<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
		<script src="js/slick.min.js"></script>
		<script src="js/main.js"></script>
</body>
</html>