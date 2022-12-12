<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/boardForm.css">
<link rel="stylesheet" href="css/footer.css">
</head>
<body>
<jsp:include page="/flower/header.jsp"></jsp:include>
<div id="wrap" align="center">

<h1>상품 리스트 - 관리자 페이지</h1>
<table class="list">
	<tr>
		<td colspan="9" style="border:white; text-align:right">
		<a href="FlowerServlet?command=flower_add_product_form">상품 등록</a>
		</td>
	</tr>
	
	<tr>
		<th>카테고리</th><th>상품코드</th><th>상품명</th><th>가격</th><th>상품안내</th><th>추가문구1 사용</th><th>추가문구2 사용</th><th>상품이미지 추가</th><th>삭제</th>
	</tr>
	
	<c:forEach var="productVO" items="${productList}">
		<c:if test="${categoryVO.category}"></c:if>
		<tr class="record">
			<td>${productVO.category}</td>
			<td><a href="FlowerServlet?command=flower_update_product_form&code=${productVO.code}">${productVO.code}</a></td>
			<td><a href="FlowerServlet?command=flower_update_product_form&code=${productVO.code}">${productVO.name}</a></td>
			<td>${productVO.price} 원</td>
			<td>${productVO.information}</td>
			<td>${productVO.text1}</td>
			<td>${productVO.text2}</td>
			
			<td><a href="FlowerServlet?command=flower_add_product_image_form&code=${productVO.code}">이미지 추가</a></td>
			<td><a href="FlowerServlet?command=flower_delete_product&code=${productVO.code}" onclick="return removeCheck()">상품 삭제</a></td>
		</tr>
	
	</c:forEach>
	
	
</table>	

</div>
<jsp:include page="/flower/footer.jsp"></jsp:include>
<script src="js/main.js"></script>
</body>
</html>