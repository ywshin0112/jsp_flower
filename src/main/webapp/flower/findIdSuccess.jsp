<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원님의 아이디는 ${flowerClient.id} 입니다.
<a href="FlowerServlet?command=login">로그인 하러가기</a> 
<a href="FlowerServlet?command=id_pass_Ck">비밀번호 찾기</a> 
</body>
</html>