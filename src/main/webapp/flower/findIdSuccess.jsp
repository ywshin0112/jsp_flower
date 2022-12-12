<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 아이디/비밀번호 찾기</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/slick.css">
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class=container>
		<ul class="category">
			<li>로그인</li>
			<li><a href="FlowerServlet?command=login_page">로그인</a></li>
			<li><a href="FlowerServlet?command=membership_page">회원가입</a></li>
		</ul>

		<div class="title">
			<h1>아이디 / 비밀번호 찾기</h1>
		</div>

		<div class="main">
			<div class="grayBox">
				<h1>아이디 찾기</h1><br><br><br><br><br><br><br><br>
				<h2>회원님의 아이디는 ${flowerClient.id} 입니다.<br><br>
				<a href="FlowerServlet?command=login">로그인 하러가기</a> /
				<a href="FlowerServlet?command=id_pass_Ck">비밀번호 찾기</a></h2>
			 	
			</div>
		</div>
	</main>
	<script src="js/main.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>