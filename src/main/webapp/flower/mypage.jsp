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
<style type="text/css">
h1 {
	font-size: 28px;
	font-weight: bold;
}

form {
	padding: 0 20%;
}
</style>
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
				<h1>기본정보</h1>
				<table>
					<tr>
						<td>이름</td>
						<td>${flowerClient.name}</td>
					</tr>
					<tr>
						<td>아이디</td>
						<td>${flowerClient.id}</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>${flowerClient.email}</td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td>${flowerClient.phone}</td>
					</tr>
					<tr>
						<td>주소</td>
						<td>${flowerClient.address}</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="button"
							name="updateBtn" value="회원정보 수정"
							onclick="open_win('FlowerServlet?command=flowerClient_update_form&id=${flowerClient.id}','update')">
							<input type="button" name="deleteBtn" value="회원탈퇴"
							onclick="FlowerServlet?command=flowerClient_delete">
						</td>
					</tr>
					<tr>
						<td colspan="2"><br>
						<h1>장바구니</h1>
							<br> 장바구니 내역</td>
						<td colspan="2"><br>
						<h1>주문배송</h1>
							<br> 주문 배송 내역</td>
					</tr>
				</table>
			</form>
		</div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="js/main.js"></script>
</body>
</html>