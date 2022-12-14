<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/slick.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/boardForm.css">
<link rel="stylesheet" href="css/footer.css">
</head>
<body>
	<jsp:include page="/flower/header.jsp"></jsp:include>

	<div id="wrap" align="center">

		<h1>상품코드 : ${code }, 상품명: ${name } 의 이미지</h1>
		<table class="list">
			<tr>
				<td style="border: white; text-align: right"></td>
			</tr>

			<tr>
				<th>이미지</th>
			</tr>


			<tr>
				<td>
					<section class="slider00">

						<div class="sliderImage">

							<c:forEach var="image" items="${imageList}">
								<div>
									<img src="image/${image}">
								</div>
							</c:forEach>

						</div>


						<div class="prevBtn">
							<i class="fa fa-chevron-left" aria-hidden="true"></i>
						</div>
						<div class="nextBtn">
							<i class="fa fa-chevron-right" aria-hidden="true"></i>
						</div>



					</section>
				</td>
			</tr>


		</table>
		<form method="post" enctype="multipart/form-data" name="frm"
			action="FlowerServlet?command=flower_add_product_image">
			<input type="hidden" name="code" value="${code }"> <input
				type="file" name="uploadFile"> <input type="submit"
				value="추가" onclick="return productImageCheck()"><input type="button" value="목록으로"
				onclick="location.href='FlowerServlet?command=flower_product_list'">

		</form>

	</div>

	<jsp:include page="/flower/footer.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script src="js/slick.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>