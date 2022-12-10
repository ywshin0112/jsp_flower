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

		<h1>상품 수정</h1>
			
		<form method="post" name="frm" action="FlowerServlet?command=flower_update_product">
		<input type="hidden" name="constCode" value="${pvo.code }">
			<table>
				<tr>
					<th>카테고리</th>
					<td>
						<select name="category">
							<c:forEach var="categoryVO" items="${categoryList}">
								<option value="${categoryVO.category }" <c:if test="${categoryVO.category == pvo.category }">selected</c:if> >${categoryVO.category }</option>
							</c:forEach>							
						</select>
					</td>
				</tr>
				<tr>
					<th>상품코드</th>
					<td><input type="text" name="code" value="${pvo.code }" onchange="productCodeCheck(${codeList }, this)"></td>
				</tr>
				<tr>
					<th> </th>
					<td><input id="codeCheckValue" type="hidden" value="0">
					<span id="codeCheck" style="color:green;">사용 가능한 상품코드 입니다.</span></td>
					

				</tr>
				<tr>
					<th>상품명</th>
					<td><input type="text" name="name" value="${pvo.name }"></td>

				</tr>
				<tr>
					<th>가격</th>
					<td><input type="text" name="price" value="${pvo.price }"></td>

				</tr>
				<tr>
					<th>상품안내</th>
					<td> <textarea rows="5" cols="50" name="information">${pvo.information }</textarea> </td>

				</tr>
				
				<tr>
					<th>추가문구1 사용</th>
					<td><input type="checkbox" name="text1" value="1" <c:if test="${pvo.text1 == 1 }">checked</c:if>></td>
					

				</tr>
				<tr>
				<th>추가문구2 사용</th>
					<td><input type="checkbox" name="text2" value="1" <c:if test="${pvo.text1 == 1 }">checked</c:if>></td>
				</tr>
			
			

			</table>
			<input type="submit" value="수정" onclick="return productUpdateSubmit()">
			 <input type="reset"
				value="취소"> <input type="button" value="목록으로"
				onclick="location.href='FlowerServlet?command=flower_product_list'">
		</form>



	</div>
	<jsp:include page="/flower/footer.jsp"></jsp:include>
	<script src="js/main.js"></script>
</body>
</html>