<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 고객 게시판</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/slick.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/buyTest.css">
</head>
<body>
	<jsp:include page="/flower/header.jsp"></jsp:include>
	<main class="container">
		<section class="mainTop">
			<div class="photo">
				<div class="photoBig">
					<img src="image/bouquet1.jpg" alt=""> <img
						src="image/bouquet2.jpg" alt=""> <img
						src="image/bouquet3.jpg" alt=""> <img
						src="image/bouquet4.jpg" alt=""> <img
						src="image/bouquet5.jpg" alt="">
				</div>
				<div class="smallPhoto">
					<img src="image/bouquet1.jpg" alt=""> <img
						src="image/bouquet2.jpg" alt=""> <img
						src="image/bouquet3.jpg" alt=""> <img
						src="image/bouquet4.jpg" alt=""> <img
						src="image/bouquet5.jpg" alt="">
				</div>
			</div>
			<form method="post" name="frm" action="FlowerServlet">
				<div class="buyBox">
					<div class="code">상품 코드 : B1</div>
					<div class="title">기본 꽃다발</div>

					<div class="price">
						판매 가격
						<h4>40,000원</h4>
					</div>

					<div class="add">
						추가 옵션 <br><br>
						<select class="addBox">
							<option value='' selected>-- 추가 옵션 --</option>
							<option value='text1'>메시지 카드</option>
							<option value='text2'>리본 문구</option>
						</select>
					</div>

					<div class="buy">
						<div>
							수량 :
							<button>-</button>
							<span> 0 </span>
							<button>+</button>
						</div>


						<div>총 금액 :</div>
						
						<div class=btnSet>
						<input type="submit" class="button" name="buy" id="buyNow" value="바로구매"/>
						<input type="button" class="button" name="shoppingBasket" value="장바구니"/>
						<button class="button">
							<i class="fa fa-heart" aria-hidden="true"></i>
						</button>
						</div>
<!-- 						<div> -->
<!-- 							<button id="buyNow"> -->
<!-- 								<a href="#">바로구매</a> -->
<!-- 							</button> -->
<!-- 							<button> -->
<!-- 								<a href="shoppingBasket.html">장바구니</a> -->
<!-- 							</button> -->
<!-- 							<button> -->
<!-- 								<i class="fa fa-heart" aria-hidden="true"></i> -->
<!-- 							</button> -->
<!-- 						</div> -->
					</div>
				</div>
			</form>
		</section>


		<section>
			<h3>상품안내</h3>

		</section>

		<section>
			<h3>사용후기</h3>

		</section>

		<section>
			<h3>상품문의</h3>

		</section>

	</main>
	<jsp:include page="/flower/footer.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script src="js/slick.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>