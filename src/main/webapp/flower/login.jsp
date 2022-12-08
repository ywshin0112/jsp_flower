<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 로그인</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/slick.css">
</head>
<body>
<!-- 쿠키값으로 id정보 받아오기 -->
<%
    String msg = (String)request.getAttribute("msg");
    Cookie[] c = request.getCookies();
    String cookieVal="";
    if(c!=null){
        for(Cookie i:c){
            if(i.getName().equals("saveId")){
                cookieVal=i.getValue();
            }
        }
    }
    
%>
	<jsp:include page="header.jsp"></jsp:include>
	<main class=container>
		<ul class="category">
			<li>로그인</li>
			<li><a href="FlowerServlet?command=login_page">로그인</a></li>
			<li><a href="FlowerServlet?command=membership_page">회원가입</a></li>
		</ul>

		<div class="title">
			<h1>로그인</h1>
		</div>

		<div class="main">
			<div class="grayBox">
				<h1>환영합니다</h1>
				<h2>회원님의 아이디와 비밀번호를 입력해주세요.</h2>
				<br>
				<form action="FlowerServlet" method="post" name="frm">
					<input type="hidden" name="command" value="login">
					<table>
						<tr>
							<td class="logBox"><span>아이디 :</span><br> 
							<input type="text" name="id" class="loginBox form-control" 
								value="<%=cookieVal !="" ? cookieVal : "" %>" placeholder="로그인" required>
							</td>
						</tr>

						<tr>
							<td class="logBox"><span>비밀번호 :</span><br> <input
								type="password" id="userpwd" name="pass" class="loginBox"
								placeholder="비밀번호"
								onkeypress="enterKey(event)" /></td>
						</tr>

						<tr>
							<td colspan="2" class=btnSet><input class="logBtn"
								type="submit" value="로그인" onclick="return idCheck()" /> <input
								class="logBtn membershipBtn" type="button" value="회원가입"
								onclick="location.href='FlowerServlet?command=membership_page'">
							</td>
						</tr>

						<tr align="center" class=idFind>
							<td>
								<label for="idSave" style="cursor: pointer"> 
									<input type="checkbox" name="saveId" id="idSave" <%=cookieVal!=""?"checked" : ""%>>
									&nbsp;아이디 저장
								</label>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="#">아이디 찾기</a>&nbsp;/ 
								<a href="#">비밀번호 찾기</a>
							</td>
						</tr>
						
					</table>
					${message}
				</form>
			</div>
		</div>
	</main>
	<script src="js/main.js"></script>
	<script src="js/login.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>