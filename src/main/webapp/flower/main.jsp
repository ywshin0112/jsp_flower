<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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


					<div>
						<a href="FlowerServlet?command=flower_bouquet"><h2>꽃다발</h2>
							<h3>특별한 당신의 하루에 꽃을 더하다</h3> <img src="image/slider01.jpg" alt=""></a>
					</div>
					<div>
						<a href="FlowerServlet?command=flower_basket"><img src="image/slider02.jpg"
							alt="">
							<h2>꽃바구니</h2>
							<h3>특별한 당신의 하루에 꽃을 더하다</h3></a>
					</div>
					<div>
						<a href="FlowerServlet?command=flower_money_box"><img src="image/slider03.jpg"
							alt="">
							<h2>용돈박스</h2>
							<h3>특별한 당신의 하루에 꽃을 더하다</h3></a>
					</div>
					<div>
						<a href="FlowerServlet?command=flower_wdding_bouquet"><img
							src="image/slider04.jpg" alt="">
							<h2>웨딩부케</h2>
							<h3>특별한 당신의 하루에 꽃을 더하다</h3></a>
					</div>
					<div>
						<a href="FlowerServlet?command=flower_plant"><img src="image/slider05.jpg" alt="">
							<h2>관엽식물</h2>
							<h3>특별한 당신의 하루에 꽃을 더하다</h3></a>
					</div>
				</div>


				<div class="prevBtn">
					<i class="fa fa-chevron-left" aria-hidden="true"></i>
				</div>
				<div class="nextBtn">
					<i class="fa fa-chevron-right" aria-hidden="true"></i>
				</div>



			</section>




			<section class="boxList">
				<div class="box1">
					<a href="FlowerServlet?command=flower_bouquet" class="hr-sect">꽃다발 상품</a>
					
					<button>
						<a href="FlowerServlet?command=flower_bouquet">더보기 >></a>
					</button>
				</div>

				<div class="box2">
					<ul class="box2_slider">
						<li><a href="jsp/buy/bouquet1.jsp"><img
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
				</div>
			</section>

			<section class="boxList">
				<div class="box1">
					
					<a href="FlowerServlet?command=flower_basket" class="hr-sect">꽃바구니 상품</a>
					
					<button>
						<a href="FlowerServlet?command=flower_basket">더보기 >></a>
					</button>
				</div>

				<div class="box2">
					<ul class="box2_slider">
						<li><a href="jsp/buy/basket1.jsp"><img
								src="image/basket1.jpg" alt="">
								<h3>믹스 꽃바구니</h3> <span>100,000원</span></a></li>
						<li><a href="#"><img src="image/basket2.jpg" alt="">
								<h3>수국 꽃바구니</h3> <span>80,000원</span></a></li>
						<li><a href="#"><img src="image/basket3.jpg" alt="">
								<h3>해바라기 꽃바구니</h3> <span>80,000원</span></a></li>
						<li><a href="#"><img src="image/basket4.jpg" alt="">
								<h3>L 사이즈 꽃바구니</h3> <span>100,000원</span></a></li>
						<li><a href="#"><img src="image/basket5.jpg" alt="">
								<h3>M 사이즈 꽃바구니</h3> <span>80,000원</span></a></li>
						<li><a href="#"><img src="image/basket6.jpg" alt="">
								<h3>미니 꽃바구니</h3> <span>50,000원</span></a></li>
					</ul>
				</div>
			</section>

			<section class="boxList">
				<div class="box1">
					
					<a href="FlowerServlet?command=flower_wdding_bouquet" class="hr-sect">웨딩 부케</a>
					
					<button>
						<a href="FlowerServlet?command=flower_wdding_bouquet">더보기 >></a>
					</button>
				</div>

				<div class="box2">
					<ul class="box2_slider">
						<li><a href="jsp/buy/weddingBouquet1.jsp"><img
								src="image/wedding_bouquet1.jpg" alt="">
								<h3>장미 부케</h3> <span>200,000원</span></a></li>
						<li><a href="#"><img src="image/wedding_bouquet2.jpg"
								alt="">
								<h3>카라 장미 부케</h3> <span>200,000원</span></a></li>
						<li><a href="#"><img src="image/wedding_bouquet3.jpg"
								alt="">
								<h3>튤립 장미 부케</h3> <span>200,000원</span></a></li>
						<li><a href="#"><img src="image/wedding_bouquet4.jpg"
								alt="">
								<h3>세미 촬영 부케</h3> <span>200,000원</span></a></li>
						<li><a href="#"><img src="image/wedding_bouquet5.jpg"
								alt="">
								<h3>카라 믹스 부케</h3> <span>200,000원</span></a></li>
						<li><a href="#"><img src="image/slider04.jpg" alt="">
								<h3>본식 부케</h3> <span>300,000원</span></a></li>
					</ul>
				</div>
			</section>

			<section class="boxList">
				<div class="box1">
					
					<a href="FlowerServlet?command=flower_plant" class="hr-sect">관엽식물 상품</a>
					
					<button>
						<a href="FlowerServlet?command=flower_plant">더보기 >></a>
					</button>
				</div>

				<div class="box2">
					<ul class="box2_slider">
						<li><a href="jsp/buy/plant1.jsp"><img
								src="image/plant1.jpg" alt="">
								<h3>여인초</h3> <span>70,000원</span></a></li>
						<li><a href="#"><img src="image/plant2.jpg" alt="">
								<h3>점박이 크로톤</h3> <span>40,000원</span></a></li>
						<li><a href="#"><img src="image/plant3.jpg" alt="">
								<h3>칼라데아 마코야나</h3> <span>50,000원</span></a></li>
						<li><a href="#"><img src="image/plant4.jpg" alt="">
								<h3>금전수</h3> <span>40,000원</span></a></li>
						<li><a href="#"><img src="image/plant5.jpg" alt="">
								<h3>몬스테라</h3> <span>50,000원</span></a></li>
						<li><a href="#"><img src="image/plant6.jpg" alt="">
								<h3>벤자민</h3> <span>50,000원</span></a></li>
					</ul>
				</div>
			</section>
		</main>

		<jsp:include page="/flower/footer.jsp"></jsp:include>


		<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
		<script src="js/slick.min.js"></script>
		<script src="js/main.js"></script>
</body>
</html>