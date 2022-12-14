<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 상품문의</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/slick.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/buyTest.css">
<link rel="stylesheet" href="css/boardForm.css">
</head>
<body>
	<jsp:include page="/flower/header.jsp"></jsp:include>
	<main class="container">
		<section class="mainTop">
			<form method="post" name="frm"
			action="FlowerServlet?command=flower_inquiry_action&code=${productList.code}&id=${flowerClient.id}">
				<input type="hidden" name="code" value="${productList.code}" />
				<h3 style="padding: 25px 0;">상품 문의</h3>
				<table>
					<tr>
						<td>상품명 : <c:out value="${productList.code}" />
						<input type="hidden" name="code" value="${inquiryList.code}"> <c:out
								value="${productList.name}" /></td>
						<td>상품 가격 : <c:out value="${productList.price} 원" />
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<th>작성자</th>
						<td><c:out value="${flowerClient.id}" />
						<input type="hidden" name="id" value="${flowerClient.id}"></td>
					</tr>
					<tr>
						<th>비밀글</th>
						<td ><label><input type="radio" name="secret" value="B" checked> 공개 
								&nbsp;</label> 
							<label><input type="radio" name="secret" value="A"> 비공개</label></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" size="100%"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea id="txtContent" rows="10" cols="100" name="contents"
								style="width: 100%;"></textarea></td>
					</tr>

				</table>
				<input type="submit" value="등록" onclick="save();" />
			</form>
		</section>
	</main>
	<jsp:include page="/flower/footer.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script src="js/slick.min.js"></script>
	<script src="js/main.js"></script>
	<script src="js/buy.js"></script>
	<!-- 네이버 스마트에디터  -->
	<script type="text/javascript" src="se2/js/service/HuskyEZCreator.js"
		charset="utf-8"></script>
	<script type="text/javascript"
		src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script>
		function save() {
			// 빈값일 때 return false 하려 했으나 외부 모듈이라 실패함
			oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", []);
			//스마트 에디터 값을 텍스트컨텐츠로 전달
			var content = document.getElementById("smartEditor").value;
			//alert(document.getElementById("txtContent").value);
			alert("상품문의 작성이 완료되었습니다.");
			// 값을 불러올 땐 document.get으로 받아오기
			return;
		}
	</script>
	<script id="smartEditor" type="text/javascript">
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "txtContent", //textarea ID 입력
			sSkinURI : "se2/SmartEditor2Skin.html", //martEditor2Skin.html 경로 입력
			fCreator : "createSEditor2",
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음) 
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음) 
				bUseVerticalResizer : false,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음) 
				bUseModeChanger : false
			}
		});
	</script>
</body>
</html>