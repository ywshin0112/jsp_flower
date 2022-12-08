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
		<td colspan="7" style="border:white; text-align:right">
		<a href="FlowerServlet?command=flower_add_product_form">상품 등록</a>
		</td>
	</tr>
	
	<tr>
		<th>카테고리</th><th>상품코드</th><th>상품명</th><th>가격</th><th>상품안내</th><th>추가문구1 사용</th><th>추가문구2 사용</th>
	</tr>
	
	<c:forEach var="categoryVO" items="${categoryList}">
		<c:if test="${categoryVO.category}"></c:if>
		<tr class="record">
			<td>${categoryVO.category}</td>
			<td><c:choose>
							<c:when test="${empty categoryVO.image}">
								<img src="image/wheelwind.gif">
							</c:when>
							<c:otherwise>
								<img src="image/${categoryVO.image}">
							</c:otherwise>
						</c:choose></td>
			
			<td><a href="FlowerServlet?command=flower_add_category_form&category=${categoryVO.category}&update=1">카테고리 수정</a></td>
			<td><a href="FlowerServlet?command=flower_delete_category&category=${categoryVO.category}" onclick="return removeCheck()">카테고리 삭제</a></td>
		</tr>
	
	</c:forEach>
	
	
</table>	

</div>
<jsp:include page="/flower/footer.jsp"></jsp:include>
<script src="js/script.js"></script>
</body>
</html>