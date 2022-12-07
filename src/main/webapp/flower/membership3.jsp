<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 회원가입</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/membership3.css">
<link rel="stylesheet" href="css/slick.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container">
		<ul class="category">
			<li>로그인</li>
			<li><a href="FlowerServlet?command=login_page">로그인</a></li>
			<li><a href="FlowerServlet?command=membership_page">회원가입</a></li>
		</ul>

		<div class="title">
			<h1>회원가입</h1>
		</div>

		<!-- 가입 내용 -->

		<div class="main">
			<div class="mainBox">
				<ul class="firstUl">
					<li>01 약관동의</li>
					<li>02 개인정보 입력</li>
					<li>03 가입완료</li>
				</ul>
				<form method="post" action="FlowerServlet">
					<table>
						<tr align="center">
							<td><i class="fa fa-check" aria-hidden="true"></i></td>
						</tr>
						<tr align="center">
							<td class="text">회원가입 완료</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</main>
	<script src="js/main.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>