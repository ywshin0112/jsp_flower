<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h1>상품 추가/수정, 삭제</h1>
		<table>
			<tr>
				<th>카테고리</th>
				<td><a href="FlowerServlet?command=flower_category_list">목록보기</a></td>
			</tr>
			<tr>
				<th>상품</th>
				<td>목록보기</td>
			</tr>
	
		</table>



	</div>
	<jsp:include page="/flower/footer.jsp"></jsp:include>
	<script src="js/main.js"></script>
</body>
</html>