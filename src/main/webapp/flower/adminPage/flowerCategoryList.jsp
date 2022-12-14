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
<form action="FlowerServlet" method="post">
<input type="hidden" name="command" value="flower_category_select"/>
<table class="list">
	<tr>
		<td colspan="6" style="border:white; text-align:right">
		<a href="FlowerServlet?command=flower_add_category_form">카테고리 추가</a></td>
	</tr>
	
	<tr>
		<th>메인메뉴</th><th>카테고리</th><th>사진</th><th>수정</th><th>삭제</th>
	</tr>
	
	<c:forEach var="categoryVO" items="${categoryList}">
		
		<tr class="record">
		
			<td><c:choose>
				<c:when test="${categoryVO.selected=='1'}">
					<input name="checkboxCounter" type="checkbox" value="${categoryVO.image}" checked onclick="return getCheckedCount(this)">
				</c:when>
				<c:otherwise>
					<input name="checkboxCounter" type="checkbox" value="${categoryVO.image}" onclick="return getCheckedCount(this)">
				</c:otherwise>
			</c:choose></td>
			
			<td>${categoryVO.category}</td>
			<td><c:choose>
							<c:when test="${empty categoryVO.image}">
								<img src="image/wheelwind.gif">
							</c:when>
							<c:otherwise>
								<img src="image/${categoryVO.image}">
							</c:otherwise>
						</c:choose></td>
			
			<td><a href="FlowerServlet?command=flower_add_category_form&category=${categoryVO.category}">카테고리 수정</a></td>
			<td><a href="FlowerServlet?command=flower_delete_category&category=${categoryVO.category}" onclick="return removeCheck()">카테고리 삭제</a></td>
		</tr>
		
	
	</c:forEach>
	<tr>
		<td colspan="6" style="border:white; text-align:left">
		<input type="submit" value="메인메뉴 저장"></td>
	</tr>
	
</table>	
</form>
</div>
<jsp:include page="/flower/footer.jsp"></jsp:include>
<script src="js/main.js"></script>
<script src="js/main100.js"></script>
</body>
</html>