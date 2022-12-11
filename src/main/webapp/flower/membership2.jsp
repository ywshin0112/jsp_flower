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
<link rel="stylesheet" href="css/membership2.css">
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
			<h2>회원가입</h2>
		</div>

		<!-- 가입 내용 -->

		<div class="main">
		<form method="post" name="frm" action="FlowerServlet">
				<input type="hidden" name="command" value="membership_completion"/>
			<div class="mainBox">
				<ul>
					<li>01 약관동의</li>
					<li>02 개인정보 입력</li>
					<li>03 가입완료</li>
				</ul>
					<table>
						<tr>
							<th>회원 형태</th>
							<td><input type="checkbox" name="lev" id="lev" value="B"
								checked="checked" onclick="return false;" /> 일반회원 
								<input type="checkbox" name="lev" id="lev" value="A"
								onclick="return false;"/> 관리자
							</td>
						</tr>

						<tr>
							<th>아이디</th>
							<td>
								<input type="text" name="id" maxlength="12"/>* &nbsp;
								<input type="hidden" name="reid" size="20">
								<input type="button" name="idCk" value="ID중복확인" id="ckBtn" onclick="return idCheck()"/> &nbsp;
								<span>4~12자리 영문/숫자 조합</span>
							</td>
						</tr>

						<tr>
							<th>비밀번호</th>
							<td>
								<input type="password" name="pass" maxlength="16"/>*
								&nbsp;<span>8~16자리 영문/숫자/특수문자 조합</span>
							</td>
						</tr>

						<tr>
							<th>비번 확인 &nbsp;</th>
							<td>
								<input type="password" name="passCk"/>*
							</td>
						</tr>

						<tr>
							<th>성명</th>
							<td><input type="text" name="name"/>*
							</td>
						</tr>

						<tr>
							<th>전화번호</th>
							<td><input type="text" name="phone" onkeyup="test(this);" maxlength="13"/>* &nbsp;
								<input type="button" value="인증번호 발송" id="ckBtn" onclick=""/>
							</td>
						</tr>

						<tr>
							<th>인증번호</th>
							<td><input type="text" name="phoneCk"/>* &nbsp;
								<input type="button" value="인증번호 확인" id="ckBtn" onclick="" /></td>
						</tr>
						
						<tr>
							<th>이메일</th>
							<td>
								<input type="text" name="email"/>*
							</td>
						</tr>

						<tr>
							<th>주소</th>
							<td>
								<input type="text" name="address" id="addrBox"/>*
								&nbsp;<span>정확한 주소를 입력해 주세요.</span>
							</td>
						</tr>
					</table>
				
				<br> 
				<div class="btnSet">
					<input type="button" class="button" value="이전단계"
					onclick="location.href='FlowerServlet?command=membership_page'" />
					<input type="submit" class="button" value="가입하기" onclick="return joinCheck()"/>
				</div>
				</div>
			</form>
		</div>
	</main>
	<script src="js/main.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>