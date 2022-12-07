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

		<h1>카테고리<c:choose>
			<c:when test="${empty param.category}">추가</c:when>
			<c:otherwise>수정</c:otherwise>
			</c:choose></h1>
		<form method="post" enctype="multipart/form-data" name="frm"
			action="FlowerServlet?command=flower_add_category">
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

			<input type="submit" value="확인"> <input type="reset"
				value="취소"> <input type="button" value="목록으로"
				onclick="location.href='FlowerServlet?command=flower_category_list'">
		</form>




	</div>
	<jsp:include page="/flower/footer.jsp"></jsp:include>
	<script src="js/main.js"></script>
</body>
</html>