<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 회원정보수정</title>
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
				<h1>기본정보</h1>
				<table>
					<tr>
						<th>회원 형태</th>
						<td>
							<c:choose>
								<c:when test="${flowerClient.lev=='A'}">
									<input type="checkbox" name="lev" id="lev" value="B"
									checked="checked" onclick="return false;" /> 일반회원 <input
									type="checkbox" name="lev" id="lev" value="A"
									onclick="return false;" /> 관리자
								
								</c:when>
		
								<c:otherwise>
									<td><input type="checkbox" name="lev" id="lev" value="B"
									onclick="return false;" /> 일반회원 <input
									type="checkbox" name="lev" id="lev" value="A" checked="checked" 
									onclick="return false;" /> 관리자
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td>성명</td>
						<td><input type="text" name="name"
							value="${flowerClient.name}" /></td>
					</tr>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id" value="${flowerClient.id}"
							readonly /></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" name="email"
							value="${flowerClient.email}" /></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><input type="text" name="phone"
							value="${flowerClient.phone}" /></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" name="address"
							value="${flowerClient.address}" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="button"
							name="updateBtn" value="회원정보 수정" onclick="return joinCheck()">
							<input type="reset" value="취소" /></td>
					</tr>
				</table>
			</form>
		</div>
	</main>
	<script src="js/main.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>