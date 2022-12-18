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
<link rel="stylesheet" href="css/boardForm.css">
<link rel="stylesheet" href="css/buyTest.css">
</head>
<body>
	<jsp:include page="/flower/header.jsp"></jsp:include>
	<main class="container">
		<section class="mainTop">
			<div>
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

					</div>
				</div>
				<div>
					<form method="post" name="frm" action="FlowerServlet">
						<div class="buyBox">
							<div class="code">상품 코드 : ${productList.code}</div>
							<div class="title">${productList.name}</div>

							<div class="price">
								판매 가격
								<h4>
									<span id="price">${productList.price}</span>원
								</h4>
							</div>

							<div class="add">
								추가 옵션 <br> <br> <select class="addBox"
									onchange="addOption(this)">
									<option value="100">--선택안함--</option>
									<c:forEach var="OptionVO" items="${coList}">
										<option
											value='{"information":"${OptionVO.information}", "name":"${OptionVO.name}", "code":"${OptionVO.code}", "price":"${OptionVO.price}", "text1":"${OptionVO.text1}", "text2":"${OptionVO.text2}"}'>${OptionVO.name}
											(+ ${OptionVO.price}원)</option>
									</c:forEach>
								</select>
								<div id="optionBlock"></div>
							</div>

							<div class="buy">
								<input type="hidden" name="text1" value="0"> <input
									type="hidden" name="text2" value="0"> <input
									type="hidden" class="optionCode" name="optionCode"
									value="${productList.code}"> <input type="hidden"
									class="optionQuantity" name="optionQuantity" value="1">

								<div>
									수량 : <input type='button'
										onclick='count("minus", this, "${productList.price}")'
										value='-' /> <span name=" " id='result'>1</span> <input
										type='button'
										onclick='count("plus", this, "${productList.price}")'
										value='+' /> <input type="hidden" class="eachPrice"
										name="eachPrice" value="${productList.price}">
								</div>


								<div>
									총 금액 : <span id="total">${productList.price}</span>원

								</div>

								<div class=btnSet>
									<input type="submit" class="button" name="buy" id="buyNow"
										value="바로구매"> <input type="button" class="button"
										name="shoppingBasket" value="장바구니">
									<button class="button" style="transform: translateY(-1px);">
										<i class="fa fa-heart" aria-hidden="true"></i>
									</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</section>
		<br>
		<section>
			<h3>상품안내</h3>
			<br> ${productList.information}
		</section>

		<section>
			<h3>사용후기</h3>
			<form>
				<table>
					<tr>
						<td>전체 평점 : <c:choose>
								<c:when test="${scoreAvg==5}">
									<c:forEach var="i" begin="1" end="5">
										<i class="fa fa-star" aria-hidden="true"></i>
									</c:forEach>
								</c:when>
								<c:when test="${scoreAvg==4}">
									<c:forEach var="i" begin="1" end="4">
										<i class="fa fa-star" aria-hidden="true"></i>
									</c:forEach>
								</c:when>
								<c:when test="${scoreAvg==3}">
									<c:forEach var="i" begin="1" end="3">
										<i class="fa fa-star" aria-hidden="true"></i>
									</c:forEach>
								</c:when>
								<c:when test="${scoreAvg==2}">
									<c:forEach var="i" begin="1" end="2">
										<i class="fa fa-star" aria-hidden="true"></i>
									</c:forEach>
								</c:when>
								<c:when test="${scoreAvg==1}">
									<c:forEach var="i" begin="1" end="1">
										<i class="fa fa-star" aria-hidden="true"></i>
									</c:forEach>
								</c:when>
								<c:when test="${scoreAvg > 4 && scoreAvg < 5}">
									<c:forEach var="i" begin="1" end="4">
										<i class="fa fa-star" aria-hidden="true"></i>
									</c:forEach>
									<c:forEach var="i" begin="1" end="1">
										<i class="fa fa-star-half-o" aria-hidden="true"></i>
									</c:forEach>
								</c:when>
								<c:when test="${scoreAvg > 3 && scoreAvg < 4}">
									<c:forEach var="i" begin="1" end="3">
										<i class="fa fa-star" aria-hidden="true"></i>
									</c:forEach>
									<c:forEach var="i" begin="1" end="1">
										<i class="fa fa-star-half-o" aria-hidden="true"></i>
									</c:forEach>
									<c:forEach var="i" begin="1" end="1">
										<i class="fa fa-star-o" aria-hidden="true"></i>
									</c:forEach>
								</c:when>
								<c:when test="${scoreAvg > 2 && scoreAvg < 3}">
									<c:forEach var="i" begin="1" end="2">
										<i class="fa fa-star" aria-hidden="true"></i>
									</c:forEach>
									<c:forEach var="i" begin="1" end="1">
										<i class="fa fa-star-half-o" aria-hidden="true"></i>
									</c:forEach>
									<c:forEach var="i" begin="1" end="2">
										<i class="fa fa-star-o" aria-hidden="true"></i>
									</c:forEach>
								</c:when>
								<c:when test="${scoreAvg > 1 && scoreAvg < 2}">
									<c:forEach var="i" begin="1" end="1">
										<i class="fa fa-star" aria-hidden="true"></i>
									</c:forEach>
									<c:forEach var="i" begin="1" end="1">
										<i class="fa fa-star-half-o" aria-hidden="true"></i>
									</c:forEach>
									<c:forEach var="i" begin="1" end="3">
										<i class="fa fa-star-o" aria-hidden="true"></i>
									</c:forEach>
								</c:when>
								<c:otherwise>
								등록된 평점이 없습니다.
							</c:otherwise>
							</c:choose> ${scoreAvg}점
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<td colspan="6" style="border: white; text-align: right"><c:choose>
								<c:when test="${empty flowerClient}">
									<input style="all: unset;" type="button" value="리뷰 등록"
										onclick="reviewIdNoneCk()"></input>
								</c:when>
								<c:otherwise>
									<input style="all: unset;" type="button" value="리뷰 등록"
										onclick="location.href='FlowerServlet?command=flower_review_form&code=${productList.code}'"></input>
								</c:otherwise>
							</c:choose></td>
					</tr>
					<c:if test="${!empty reviewList}">
						<c:forEach var="reviewList" items="${reviewList}">
							<tr>
								<th style="text-align: left">no.${reviewList.num} |
									${reviewList.id} | ${reviewList.writedate} | ${reviewList.code}
									<c:out value="${productList.name}" /> | 평점 <c:forEach var="i"
										begin="1" end="${reviewList.score}">
										<i class="fa fa-star" aria-hidden="true"></i>
									</c:forEach>
								</th>
							</tr>
							<tr>
								<td style="text-align: left">${reviewList.contents}<br>
									<img src="image/${reviewList.image}">
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty reviewList}">
						<tr>
							<th></th>
						</tr>
						<tr>
							<td>등록된 리뷰가 없습니다.</td>
						</tr>
					</c:if>
				</table>
			</form>
		</section>

		<section>
			<h3>상품문의</h3>
			<form>
				<table>
					<tr>
						<td colspan="6" style="border: white; text-align: right">
						<c:choose>
								<c:when test="${empty flowerClient}">
									<input style="all: unset;" type="button" value="문의하기"
										onclick="reviewIdNoneCk()"></input>
								</c:when>
								<c:otherwise>
									<input style="all: unset;" type="button" value="문의하기"
										onclick="location.href='FlowerServlet?command=flower_inquiry_form&code=${productList.code}'"></input>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>

						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>내용</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
					<c:if test="${!empty inquiryList}">
						<c:forEach var="inquiryList" items="${inquiryList}">
							<tr>
								<td>${inquiryList.num}</td>
								<td>${inquiryList.title}</td>
								<td>${inquiryList.id}</td>
								<c:choose>
									<c:when test="${inquiryList.secret.equals('B')}">
										<td>${inquiryList.contents}</td>
									</c:when>
									<c:otherwise>
										<td><i style="color: gray;" class="fa fa-lock"
											aria-hidden="true"></i> 비밀글입니다.</td>
									</c:otherwise>
								</c:choose>
								<td>${inquiryList.writedate}</td>
								<td>${inquiryList.count}</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty inquiryList}">
						<tr>
							<td colspan="6">등록된 상품 문의가 없습니다.</td>
						</tr>
					</c:if>
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