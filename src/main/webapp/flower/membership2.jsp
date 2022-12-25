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
				<input type="hidden" name="command" value="membership_completion" />
				<div class="mainBox">
					<ul>
						<li>01 약관동의</li>
						<li>02 개인정보 입력</li>
						<li>03 가입완료</li>
						<li
							style="float: right; font-weight: normal; color: black; font-size: 13px;">
							<span style="color: red;">*</span> 항목은 필수입력 항목입니다.
						</li>
					</ul>
					<table>
						<!-- 						<tr> -->
						<!-- 							<th>회원 형태</th> -->
						<!-- 							<td><input type="checkbox" name="lev" id="lev" value="B" -->
						<!-- 								checked="checked" onclick="return false;" /> 일반회원  -->
						<!-- 								<input type="checkbox" name="lev" id="lev" value="A" -->
						<!-- 								onclick="return false;"/> 관리자 -->
						<!-- 							</td> -->
						<!-- 						</tr> -->

						<tr>
							<th><span style="color: red;">*</span> 아이디</th>
							<td><input type="text" name="id" maxlength="12" /> &nbsp; <input
								type="hidden" name="reid" size="20" /> <input type="button"
								name="idCk" value="ID중복확인" id="ckBtn" onclick="return idCheck()" />
								&nbsp; <input type="hidden" name="checked_id" value="" /> <span>4~12자리
									영문/숫자 조합</span></td>
						</tr>

						<tr>
							<th><span style="color: red;">*</span> 비밀번호</th>
							<td><input type="password" name="pass" maxlength="16"
								onchange="pwCheck()" /> &nbsp; 
								<span id="pwCk" style="color: #6e6e6e;">8~16자리 영문/숫자/특수문자
									조합</span></td>
						</tr>

						<tr>
							<th><span style="color: red;">*</span> 비번 확인 &nbsp;</th>
							<td><input type="password" name="passCk" maxlength="16"
								onchange="pwReCheck()"/> &nbsp;
							<span id="pwReCk" style="color: #6e6e6e;">비밀번호 일치 여부를 확인해 주세요.</span></td>
						</tr>

						<tr>
							<th><span style="color: red;">*</span> 성명</th>
							<td><input type="text" name="name" /></td>
						</tr>

						<tr>
							<th><span style="color: red;">*</span> 전화번호</th>
							<td><input type="text" name="phone"
								onchange="phoneCheck(${phoneList}, this)" onkeyup="test(this);"
								maxlength="13" /> &nbsp; <input type="hidden" id="phoneCkValue"
								value="0"> <!-- 								<input type="button" value="인증번호 발송" id="ckBtn" onclick=""/> -->
								<span id="phoneCk" style="color: #6e6e6e;">전화번호를 입력해 주세요.</span>
							</td>
						</tr>

						<!-- 						<tr> -->
						<!-- 							<th>인증번호</th> -->
						<!-- 							<td><input type="text" name="phoneCk"/>* &nbsp; -->
						<!-- 								<input type="button" value="인증번호 확인" id="ckBtn" onclick="" /></td> -->
						<!-- 						</tr> -->

						<tr>
							<th><span style="color: red;">*</span> 이메일</th>
							<td><input type="text" name="email"
								onchange="emailCheck(${emailList}, this)" /> &nbsp; <input
								type="hidden" id="emailCkValue" value="0"> <span
								id="emailCk" style="color: #6e6e6e;">이메일을 입력해 주세요.</span></td>
						</tr>
						<tr>
							<th><span style="color: red;">*</span> 주소</th>
							<td><input type="text" name="zip_code" id="sample6_postcode"
								placeholder="우편번호">&nbsp;&nbsp;&nbsp; <input
								type="button" onclick="sample6_execDaumPostcode()"
								value="우편번호 찾기"><input type="hidden" name="checked_zip_code" value="" /><br></td>
						</tr>
						<tr>
							<th></th>
							<td><input type="text" name="address" id="sample6_address" placeholder="주소"
								size="60"></td>
						</tr>
						<tr>
							<th></th>
							<td><input type="text" id="sample6_detailAddress" name="detailed_address" 
								placeholder="상세주소" size="30"> <input type="text" name="refer" 
								id="sample6_extraAddress" placeholder="참고항목" size="24"></td>
						</tr>
					</table>

					<br>
					<div class="btnSet">
						<input type="button" class="button" value="이전단계"
							onclick="location.href='FlowerServlet?command=membership_page'"/>
						<input type="submit" class="button" value="가입하기"
							onclick="return joinCheck()" />
					</div>
				</div>
			</form>
		</div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="js/main.js"></script>
	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>