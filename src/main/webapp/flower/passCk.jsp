<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
<form method="post" name="frm" action="FlowerServlet">
<input type="hidden" name="command" value="flowerClient_delete" />
<input type="hidden" name="id" value="${flowerClient.id}"/>
<table>
	<tr align="center">
		<td>
			<h2>회원 탈퇴를 진행하시겠습니까?</h2>
			<span>회원 탈퇴를 하시려면 비밀번호를 입력하셔야 합니다.</span>
		</td>
	</tr>
	<tr align="center">
		<td>
			<input type="password" name="pass"/> 
			<input type="submit" value="확인" onclick="return passCk()"/> 
		</td>
	</tr>
	<tr>
	<td>${massage} </td>
	</tr>
	
</table>
</form>
	<script src="js/mypage.js"></script>
</body>
</html>