<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 마이페이지</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/membership2.css">
<link rel="stylesheet" href="css/slick.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container">
		<ul class="category">
			<li>마이페이지</li>
			<li><a href="FlowerServlet?command=mypage">마이페이지</a></li>
			<li><a href="shoppingBasket.html">장바구니</a></li>
			<li><a href="delivery.html">주문배송조회</a></li>
		</ul>

		<div class="title">
			<h2>마이페이지</h2>
		</div>

		<div class="main">

			<form method="post" name="frm" action="FlowerServlet">
				<input type="hidden" name="command" value="flowerClient_update" />

				<div class="mainBox">
					<h1>기본정보</h1>
					<table>
						<tr>
							<th>이름</th>
							<td>${flowerClient.name}</td>
						</tr>
						<tr>
							<th>아이디</th>
							<td>${flowerClient.id}</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>${flowerClient.email}</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td>${flowerClient.phone}</td>
						</tr>
						<tr>
							<th>주소</th>
							<td>${flowerClient.address}</td>
						</tr>
					</table>
					<div class="btnSet">
						<input type="button" class="button" name="updateBtn" value="회원정보 수정"
							onclick="location.href='FlowerServlet?command=flowerClient_update_form&id=${flowerClient.id}'">
						
					</div>
					<table>
						<tr>
							<th>장바구니</th>
							<td>장바구니 내역</td>
						</tr>
						<tr>
							<th>주문배송</th>
							<td>주문 배송 내역</td>
						</tr>
					</table>
					<input type="button" name="deleteBtn" value="회원탈퇴" style="all: unset; float: left; margin-top: 10px; border-bottom: 1px solid black;"
							onclick="open_win('FlowerServlet?command=flowerClient_delete_form&id=${flowerClient.id}','delete')" />
				</div>
			</form>
		</div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="js/main.js"></script>
	<script src="js/mypage.js"></script>
</body>
</html>