<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꽃궁 | 회원가입</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/membership1.css">
<link rel="stylesheet" href="css/slick.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container">
        <ul class="category">
            <li>로그인</li>
            <li><a href="FlowerServlet?command=login_page">로그인</a></li>
            <li><a href="FlowerServlet?command=membership_page">회원가입</a></li>
        </ul>

        <div class="title"><h1>회원가입</h1></div>

        <!-- 가입 내용 -->

        <div class="main">
            
            <form method="post" name="frm" action="FlowerServlet">
            <input type="hidden" name="command" value="membership_write">
            <div class="mainBox">
                <ul>
                    <li>01 약관동의</li>
                    <li>02 개인정보 입력</li>
                    <li>03 가입완료</li>
                </ul>

                <br>
                <p>이용약관 : <span>[필수]</span></p>
                <ul>
                    <li>전자상거래(인터넷사이버몰) 표준약관 제1조(목적)<br>이 약관은 "꽃궁" 회사(전자상거래 사업자)가 운영하는 "꽃궁" 사이버 몰(이하 "몰"이라 한다)에서 제공하는
                        인터넷 관련 서비스(이하 "서비스"라 한다)를 이용함에 있어 사이버 몰과 이용자의 권리ㆍ의무 및 책임사항을 규정함을 목적으로 합니다. ※「PC통신, 무선 등을 이용하는
                        전자상거래에 대해서도 그 성질에 반하지 않는 한 이 약관을 준용합니다」
                    </li>
                </ul>
                <label><input type="checkbox" name="ckBox" onclick='checkSelectAll()'>이용약관에 동의합니다.</label>
				<br>
                <p>고객약관동의 : <span>[필수]</span></p>
                <ul>
                    <li>고객약관 제1조 (목적)<br>이 약관은 "꽃궁"(이하 "회사"라 함)이 운영하는 "꽃궁" 에서 제공하는 상품판매 관련 서비스의 이용에 있어 회사와 고객의 권리,
                        의무 및 책임 사항을 규정함에 그 목적이 있습니다.
                    </li>
                </ul>
                <label><input type="checkbox" name="ckBox" onclick='checkSelectAll()'>고객약관에 동의합니다.</label>
				<br>
                <p>개인정보취급방침 : <span>[필수]</span></p>
                <ul>
                    <li>1. 수집하는 개인정보 항목<br>가.수집항목 : 성명, 전자메일(E-mail), 주소, 전화번호, 핸드폰번호, 희망ID(회원가입의 경우), 비밀번호(회원가입의 경우),
                        이메일 주소, 받는분 성명, 받는분 연락처, 받는분 주소, 접속정보, 접속IP 나.개인정보 수집방법 : 쇼핑몰 회원가입, 질문과 답변(Q&A), 상품구매 주문서, 설문조사나
                        이벤트 행사.
                    </li>
                </ul>

                <label><input type="checkbox" name="ckBox" onclick='checkSelectAll()'>개인정보취급방침에 동의합니다.</label>

                <br><br><label><input type="checkbox" name="allCkBox" id="agree" value="Bike" onclick='selectAll(this)'><span style="color: black;">[전체동의]</span>
                해당 약관에 모두 동의합니다.</label>
                </div>

            <br><br>
            <div class=btnSet>
            <input type="submit" value="동의하기" class="button" onclick="return agreementCheck()">
            <input type="button" value="동의안함" class="button" onclick="location.href='FlowerServlet?command=flower_main'">
            </div>
            </form>
        </div>
    </main>
    <jsp:include page="footer.jsp"></jsp:include>
	<script src="js/main.js"></script>
</body>
</html>