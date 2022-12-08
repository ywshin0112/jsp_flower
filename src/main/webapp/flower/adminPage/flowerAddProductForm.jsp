<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<h1>상품 <c:choose>
			<c:when test="${empty param.code}">추가</c:when>
			<c:otherwise>수정</c:otherwise>
			</c:choose></h1>
			
		<form method="post" enctype="multipart/form-data" name="frm"
			<c:choose>
			<c:when test="${empty param.category}">action="FlowerServlet?command=flower_add_category"</c:when>
			<c:otherwise>action="FlowerServlet?command=flower_update_category"</c:otherwise>
			</c:choose>
			>
			<input type="hidden" name="updateName" value="${param.category }">
			<table>
				<tr>
					<th>카테고리</th>
					<td><input type="text" name="category"
						value="${param.category}"></td>
				</tr>
				<tr>
					<th>이미지</th>
					<td><input type="file" name="uploadFile"></td>

				</tr>

			</table>
			<c:choose>
			<c:when test="${empty param.category}"><input type="submit" value="추가"></c:when>
			<c:otherwise><input type="submit" value="수정"></c:otherwise>
			</c:choose>
			 <input type="reset"
				value="취소"> <input type="button" value="목록으로"
				onclick="location.href='FlowerServlet?command=flower_category_list'">
		</form>




	</div>
	<jsp:include page="/flower/footer.jsp"></jsp:include>
	<script src="js/main.js"></script>
</body>
</html>