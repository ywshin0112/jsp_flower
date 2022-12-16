<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 리뷰 작성</title>
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
				<form>
				<h3 style="padding: 25px 0;">리뷰 작성</h3>
		<table>
			<tr>
				<td>상품명 :</td>
			</tr>
			<tr>
				<td>상품 가격 :</td>
			</tr>
		</table>
		<table>
			<tr>
				<th>작성자</th>
				<td>${client.id}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea></textarea></td>
			</tr>
			<tr>
				<th>이미지 등록</th>
				<td><input type="file"></td>
			</tr>

		</table>
		<input type="submit" value="등록" onclick="location.href='FlowerServlet?command=flower_buy_form'"/>
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