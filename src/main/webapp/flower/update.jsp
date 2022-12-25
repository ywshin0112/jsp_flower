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
				<h1>회원정보수정</h1>
				<div class="mainBox">
					<table>
						<tr>
							<th>회원 형태</th>
							<td><c:choose>
									<c:when test="${flowerClient.lev=='B'}">
										<input type="checkbox" name="lev" id="lev" value="B"
											checked="checked" onclick="return false;" /> 일반회원 
									<input type="checkbox" name="lev" id="lev" value="A"
											onclick="return false;" /> 관리자
								
								</c:when>

									<c:otherwise>
										<input type="checkbox" name="lev" id="lev" value="B"
											onclick="return false;" /> 일반회원 
									<input type="checkbox" name="lev" id="lev" value="A"
											checked="checked" onclick="return false;" /> 관리자
								</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<th>아이디</th>
							<td><input type="text" name="id" value="${flowerClient.id}"
								readonly /></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="pass"/></td>
						</tr>
						<tr>
							<th>비번 확인</th>
							<td><input type="password" name="passCk" /></td>
						</tr>
						<tr>
							<th>성명</th>
							<td><input type="text" name="name"
								value="${flowerClient.name}" /></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><input type="text" name="phone" onkeyup="test(this);"
								maxlength="13" value="${flowerClient.phone}" /></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="text" name="email"
								value="${flowerClient.email}" /></td>
						</tr>
						<tr>
							<th>주소</th>
							<td><input type="text" name="zip_code" id="sample6_postcode" 
							value="${flowerClient.zip_code}">&nbsp;&nbsp;&nbsp; <input
								type="button" onclick="sample6_execDaumPostcode()"
								value="우편번호 찾기"><input type="hidden"
								name="checked_zip_code" value="" /><br></td>
						</tr>
						<tr>
							<th></th>
							<td><input type="text" name="address" id="sample6_address" value="${flowerClient.address}"
								placeholder="주소" size="60"></td>
						</tr>
						<tr>
							<th></th>
							<td><input type="text" id="sample6_detailAddress" 
							value="${flowerClient.detailed_address}" name="detailed_address" size="30"> <input
								type="text" name="refer" id="sample6_extraAddress" 
								value="${flowerClient.refer}" size="24"></td>
						</tr>
					</table>
					<div class="btnSet">
						<input type="submit" name="updateBtn" class="button"
							value="회원정보 수정" onclick="return updateCheck()"> <input
							type="button" class="button" value="뒤로가기"
							onclick="location.href='FlowerServlet?command=mypage'" />

					</div>
				</div>
			</form>
		</div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="js/main.js"></script>
	<script src="js/mypage.js"></script>
	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</body>
</html>