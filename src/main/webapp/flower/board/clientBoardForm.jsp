<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 고객 게시판</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/bouquet.css">
<link rel="stylesheet" href="css/slick.css">
</head>
<body>
	<jsp:include page="/flower/header.jsp"></jsp:include>
	<main class="container">
			<ul class="category">
				<li>고객 게시판</li>
				<li><a href="notice.html">리뷰 게시판</a></li>
				<li><a href="notice01.html">리뷰 작성</a></li>
			</ul>

			<div class="title">
				<h2>리뷰 게시판</h2>
			</div>
			<form>
				<table border="" class="main">
					<tr>
						<th></th>
					</tr>
				</table>
			</form>

			<button>
				<a href="notice01.html">글쓰기</a>
			</button>
		</main>
		<jsp:include page="/flower/footer.jsp"></jsp:include>
		<script src="js/main.js"></script>
</body>
</html>