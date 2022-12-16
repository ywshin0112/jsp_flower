<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="css/boardForm.css">
</head>
<body>
	<jsp:include page="/flower/header.jsp"></jsp:include>
	<main class="container">
		<section class="mainTop">
			<div class="photo">
				<div class="photoBig">
					<c:forEach var="imageVO" items="${imageList}">
						<img src="image/${imageVO.image}" alt="">
					</c:forEach>
				</div>
				<div class="smallPhoto">
					<c:forEach var="imageVO" items="${imageList}">
						<img src="image/${imageVO.image}" alt="">
					</c:forEach>
					<!-- 					<img src="image/bouquet1.jpg" alt=""> <img -->
					<!-- 						src="image/bouquet2.jpg" alt=""> <img -->
					<!-- 						src="image/bouquet3.jpg" alt=""> <img -->
					<!-- 						src="image/bouquet4.jpg" alt=""> <img -->
					<!-- 						src="image/bouquet5.jpg" alt=""> -->
				</div>
			</div>
			<form method="post" name="frm" action="FlowerServlet">
				<div class="buyBox">
					<div class="code">상품 코드 : ${productList.code}</div>
					<div class="title">${productList.name}</div>

					<div class="price">
						판매 가격
						<h4>${productList.price}원</h4>
					</div>

					<div class="add">
						추가 옵션 <br> <br> <select class="addBox">
							<c:forEach var="OptionVO" items="${coList}">
								<option value='${OptionVO.information}'>${OptionVO.name}</option>
							</c:forEach>
						</select>
					</div>

					<div class="buy">
						<div>수량 : 
							<input type='button' onclick='count("minus")' value='-' />
							<span id='result'>1</span>
							<input type='button' onclick='count("plus")' value='+' /> 
						</div>


						<div>총 금액 :
							<span onchange="">${productList.price}</span> 원
						</div>

						<div class=btnSet>
							<input type="submit" class="button" name="buy" id="buyNow"
								value="바로구매" /> <input type="button" class="button"
								name="shoppingBasket" value="장바구니" />
							<button class="button">
								<i class="fa fa-heart" aria-hidden="true"></i>
							</button>
						</div>
					</div>
				</div>
			</form>
		</section>


		<section>
			<h3>상품안내</h3>
			<br> ${productList.information}
		</section>

		<section>
			<h3>사용후기</h3>
			<form>
				<table>
					<tr>
						<td colspan="6" style="border:white; text-align:right">
							<input style="all: unset; " type="button" value="리뷰 등록" onclick="location.href='FlowerServlet?command=flower_review_form'"></input>
						</td>
					</tr>
<!-- 					<tr> -->
<!-- 						<th>번호</th><th>제목</th><th>작성자</th><th>내용</th><th>작성일</th><th>조회수</th> -->
<!-- 					</tr> -->
<!-- 					<tr>	 -->
<!-- 						<td>1</td><td>좋아요</td><td>김콩이</td><td>최고의 선택!!</td><td>2022/12/16</td><td>0</td> -->
<!-- 					<tr> -->
					<tr>
					<th style="text-align:left">
					 qwe*** | 2022.12.16 | no1 | 조회수 | 상품 정보 | 평점 <i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star" aria-hidden="true"></i></th> 
					</tr>
					
					<tr>
					<td style="text-align:left">
					 내용 <br>
					이미지 </td>
					</tr>
				</table>
			</form>
		</section>

		<section>
			<h3>상품문의</h3>
			<form>
				<table>
					<tr>
						<td colspan="6" style="border:white; text-align:right">
							<input style="all: unset; " type="button" value="문의하기" onclick=""></input>
						</td>
					</tr>
					<tr>
						<th>번호</th><th>제목</th><th>작성자</th><th>내용</th><th>작성일</th><th>조회수</th>
					</tr>
					<tr>	
						<td>1</td><td>좋아요</td><td>김콩이</td><td>최고의 선택!!</td><td>2022/12/16</td><td>0</td>
					<tr>
					
				</table>
			</form>
		</section>

	</main>
	<jsp:include page="/flower/footer.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script src="js/slick.min.js"></script>
	<script src="js/main.js"></script>
	<script src="js/buy.js"></script>
</body>
</html>