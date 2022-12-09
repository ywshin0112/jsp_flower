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
				<br>
				<form action="FlowerServlet" method="post" name="frm">
					<input type="hidden" name="command" value="id_pass_Ck">
					<table>
						<tr>
							<td class="logBox"><span>성함 :</span><br> 
								<input type="text" name="name">
							</td>
						</tr>
						<tr>
							<td class="logBox"><span>이메일 :</span><br> 
								<input type="text" name="email">
							</td>
						</tr>
					</table>
					<input type="submit" value="아이디 찾기" name="idCk">	
					</form>
				<form action="FlowerServlet" method="post" name="frm">
					<input type="hidden" name="command" value="Find_id">
					<table>
						<tr>
							<td class="logBox"><span>성함 :</span><br> 
								<input type="text" name="name">
							</td>
						</tr>
						<tr>
							<td class="logBox"><span>이메일 :</span><br> 
								<input type="text" name="email">
							</td>
						</tr>
					</table>
					<input type="submit" value="비밀번호 찾기" name="passCk">	
				</form>
			</div>
		</div>
	</main>
	<script src="js/main.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>