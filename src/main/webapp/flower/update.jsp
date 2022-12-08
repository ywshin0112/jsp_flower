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
				<input type="hidden" name="command" value="flowerClient_update"/>
			<h2>회원정보수정</h2>
				<table>
					<tr>
						<th>회원 형태</th>
						<td>
							<c:choose>
								<c:when test="${flowerClient.lev=='B'}">
									<input type="checkbox" name="lev" id="lev" value="B"
									checked="checked" onclick="return false;" /> 일반회원 
									<input type="checkbox" name="lev" id="lev" value="A"
									onclick="return false;" /> 관리자
								
								</c:when>
		
								<c:otherwise>
									<input type="checkbox" name="lev" id="lev" value="B"
									onclick="return false;" /> 일반회원 
									<input type="checkbox" name="lev" id="lev" value="A" checked="checked" 
									onclick="return false;" /> 관리자
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>성명</th>
						<td><input type="text" name="name"
							value="${flowerClient.name}" /></td>
					</tr>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="id" value="${flowerClient.id}" readonly /></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="pass" value="${flowerClient.pass}"/></td>
					</tr>
					<tr>
						<th>비번 확인</th>
						<td><input type="password" name="passCk"/></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="email"
							value="${flowerClient.email}" /></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="phone" onkeyup="test(this);" maxlength="13"
							value="${flowerClient.phone}" /></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="address"
							value="${flowerClient.address}" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<input type="submit" name="updateBtn" value="회원정보 수정" onclick="return updateCheck()">
							<input type="reset" value="취소" /></td>
					</tr>
					
				</table>
			</form>
		</div>
	</main>
	<script src="js/main.js"></script>
	<script src="js/mypage.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>