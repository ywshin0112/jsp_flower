<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복 확인</title>
<style type="text/css">
body {
text-align: center;
}
</style>
</head>
<body>
	<h2>아이디 중복확인</h2>
	<form method="post" name="frm" action="FlowerServlet">
	<input type="hidden" name="command" value="id_Ck"/>
		아이디 <input type="text" name="id" value="${id}"> 
			<input type="submit" value="중복 체크"> <br>
		<c:if test="${result == 1}">
			<script type="text/javascript">
				opener.document.frm.id.value = "";
			</script>
			${id}는 이미 사용 중인 아이디입니다.
		</c:if>
		<c:if test="${result==-1}">
		${id}는 사용 가능한 아이디입니다.
		<input type="button" value="사용" class="cancel" onclick="idok('${id}')">
		</c:if>
	</form>
	<script src="js/main.js"></script>
</body>
</html>