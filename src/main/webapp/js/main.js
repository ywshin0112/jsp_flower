document.querySelector(".asideButton").addEventListener("click", function() {
	document.querySelector(".mainAside").classList.toggle("active");
	document.querySelector(".asideButton").classList.toggle("active");
});

$(".slider").slick({
	arrows: true,
	prevArrow: $(".prevBtn"),
	nextArrow: $(".nextBtn"),
	autoplay: true,
	slidesToShow: 2,
	pauseOnHover: true,
	responsive: [ // 반응형 웹 구현 옵션

		{
			breakpoint: 700, //화면 사이즈
			settings: {
				slidesToShow: 1
			}
		}
	]
});


$(".sliderImage").slick({
	arrows: true,
	prevArrow: $(".prevBtn"),
	nextArrow: $(".nextBtn"),
	autoplay: true,
	slidesToShow: 4,
	pauseOnHover: true,
	variableWidth: true,
});


$(".box2_slider").slick({
	arrows: false,
	autoplay: true,
	slidesToShow: 5,
	responsive: [ // 반응형 웹 구현 옵션
		{
			breakpoint: 900, //화면 사이즈
			settings: {
				slidesToShow: 3
			}
		},
		{
			breakpoint: 700, //화면 사이즈
			settings: {
				slidesToShow: 1
			}
		}
	]
});
$('.photoBig').slick({
	slidesToShow: 1,
	slidesToScroll: 1,
	arrows: false,
	fade: true,
});
$('.smallPhoto').slick({
	//slidesToShow: 5,
	slidesToScroll: 1,
	asNavFor: '.photoBig',
	focusOnSelect: true,
	variableWidth: true,
	//centerMode: true,
	arrows: false,
});
// 회원가입
// 회원가입 동의
function checkSelectAll() {
	const checkboxes = document.querySelectorAll('input[name="ckBox"]');
	const checked = document.querySelectorAll('input[name="ckBox"]:checked');
	const selectAll = document.querySelector('input[name="allCkBox"]');

	if (checkboxes.length === checked.length) {
		selectAll.checked = true;
	} else {
		selectAll.checked = false;
	}
}

function selectAll(selectAll) {
	const checkboxes = document.getElementsByName('ckBox');
	checkboxes.forEach((checkbox) => {
		checkbox.checked = selectAll.checked
	})
}

// 회원가입 동의 안하면 안 넘어감
function agreementCheck() {
	const checkbox = document.getElementById('agree');
	const is_checked = checkbox.checked;
	if (is_checked == false) {
		alert("이용약관 확인 후 동의하셔야 회원가입 하실 수 있습니다.");
		return false;
	}
}




// 전화번호 자동 하이픈 생성
function test(e) {
	var number = e.value.replace(/[^0-9]/g, "");
	var phone = "";

	if (number.length < 4) {
		return number;
	} else if (number.length < 7) {
		phone += number.substr(0, 3);
		phone += "-";
		phone += number.substr(3);
	} else if (number.length < 10) {
		phone += number.substr(0, 2);
		phone += "-";
		phone += number.substr(2, 3);
		phone += "-";
		phone += number.substr(5);
	} else if (number.length < 11) {
		phone += number.substr(0, 3);
		phone += "-";
		phone += number.substr(3, 3);
		phone += "-";
		phone += number.substr(6);
	} else {
		phone += number.substr(0, 3);
		phone += "-";
		phone += number.substr(3, 4);
		phone += "-";
		phone += number.substr(7, 4);
	}

	e.value = phone;
}



// 아이디 중복 체크
// id 중복 체크 모듈
function idCheck() {
	let idLimit = /^(?=.*[A-Za-z])(?=.*[0-9])[a-z0-9]{3,12}$/g;

	if (document.frm.id.value == "") {
		alert("아이디를 입력해주세요");
		document.frm.id.focus();
		return;
	} if (!idLimit.test(document.frm.id.value)) {
		alert("아이디는 영문, 숫자를 포함하여 4~12자 사이로 공백 없이 작성해 주세요.");
		return false;
	}

	// 중복 확인 팝업창
	var url = "FlowerServlet?command=id_Ck&id=" + document.frm.id.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no,   width=450, height=200")

	// 중복체크 value 값 지정(가입버튼 비활성화 느낌(?)만 줌)
	var Myelement = document.querySelector('input[name="checked_id"]');
	console.log(Myelement.value);
	Myelement.value = "Y";
	console.log(Myelement.value);
}

function idok() {

	// opener 부모창 > 회원가입창
	opener.frm.id.value = document.frm.id.value;
	// reid 히든값 다시 확인
	opener.frm.reid.value = document.frm.id.value;
	self.close();
}

// 비번 문구
function pwCheck() {
	let passLimit = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/g;
	if (!passLimit.test(document.frm.pass.value)) {
		document.querySelector("#pwCk").innerHTML = 'X 8~16자리 영문/숫자/특수문자 조합';
		document.querySelector("#pwCk").style.color = 'red';
		//document.querySelector("#pwCkValue").value = '1';
		return;
	} else {
		document.querySelector("#pwCk").innerHTML = '✔ 8~16자리 영문/숫자/특수문자 조합'
		document.querySelector("#pwCk").style.color = 'green';
		//document.querySelector("#phoneCkValue").value = '0';
	}
}

// 비번 일치 체크 문구
function pwReCheck() {
	let passLimit = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/g;
	if (document.frm.pass.value != document.frm.passCk.value) {
		document.querySelector("#pwReCk").innerHTML = '비밀번호가 일치하지 않습니다.';
		document.querySelector("#pwReCk").style.color = 'red';
		return;
	} else {
		document.querySelector("#pwReCk").innerHTML = '✔ 비밀번호가 일치합니다.'
		document.querySelector("#pwReCk").style.color = 'green';
	}
}

// 전화번호 중복시 문구
function phoneCheck(phoneList, target) {
	let phoneLimit = /^\d{2,3}-\d{3,4}-\d{4}$/;
	for (var i = 0; i < phoneList.length; i++) {
		if (phoneList[i] === target.value) {
			document.querySelector("#phoneCk").innerHTML = '가입된 전화번호가 있습니다.';
			document.querySelector("#phoneCk").style.color = 'red';
			document.querySelector("#phoneCkValue").value = '1';
			return;
		} else if (!phoneLimit.test(document.frm.phone.value)) {
			document.querySelector("#phoneCk").innerHTML = '전화번호를 다시 확인해 주세요.';
			document.querySelector("#phoneCk").style.color = 'red';
			document.querySelector("#phoneCkValue").value = '1';
			return;
		}
		else {
			document.querySelector("#phoneCk").innerHTML = '✔ 사용 가능한 전화번호입니다.'
			document.querySelector("#phoneCk").style.color = 'green';
			document.querySelector("#phoneCkValue").value = '0';
		}
	};
}

// 이메일 중복시 문구
function emailCheck(emailList, target) {
	let emailLimit = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	for (var i = 0; i < emailList.length; i++) {
		if (emailList[i] === target.value) {
			document.querySelector("#emailCk").innerHTML = '가입된 이메일이 있습니다.';
			document.querySelector("#emailCk").style.color = 'red';
			document.querySelector("#emailCkValue").value = '1';
			return;
		} else if (!emailLimit.test(document.frm.email.value)) {
			document.querySelector("#emailCk").innerHTML = '이메일을 다시 확인해 주세요.'
			document.querySelector("#emailCk").style.color = 'red';
			document.querySelector("#emailCkValue").value = '1';
		} else {
			document.querySelector("#emailCk").innerHTML = '✔ 사용 가능한 이메일입니다.'
			document.querySelector("#emailCk").style.color = 'green';
			document.querySelector("#emailCkValue").value = '0';
		}
	};
}

// 회원가입 유효성 검사
function joinCheck() {
	// 정규식 모음
	let idLimit = /^(?=.*[A-Za-z])(?=.*[0-9])[a-z0-9]{3,12}$/g;
	let passLimit = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/g;
	let nameLimit = /^[a-zA-Zㄱ-ㅎ가-힣]{0,30}$/g;
	let phoneLimit = /^\d{2,3}-\d{3,4}-\d{4}$/;
	let emailLimit = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

	// 아이디 조건
	if (document.frm.checked_id.value != 'Y') {
		alert("아이디 중복체크를 해주세요.");
		return false;
	} if (document.frm.id.value == '') {
		alert("아이디를 입력하세요.");
		return false;
	} if (!idLimit.test(document.frm.id.value)) {
		alert("아이디는 영문, 숫자를 포함하여 4~12자 사이로 공백 없이 작성해 주세요.");
		return false;
	}

	// 비밀번호 조건
	if (document.frm.pass.value == '') {
		alert("비밀번호를 입력하세요.");
		return false;
	} if (!passLimit.test(document.frm.pass.value)) {
		alert("비밀번호는 영문, 숫자, 특수문자를 포함하여 8~16자 사이로 공백 없이 작성해 주세요.");
		return false;
	}

	// 비밀번호 중복 조건
	if (document.frm.passCk.value == '') {
		alert("비번 확인을 입력해 주세요.");
		return false;
	} if (document.frm.pass.value != document.frm.passCk.value) {
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}

	// 성명 조건
	if (document.frm.name.value == '') {
		alert("성함을 입력하세요.");
		return false;
	} if (!nameLimit.test(document.frm.name.value)) {
		alert("공백 없이 한글 성함 혹은 영문 성함으로 작성해 주세요.");
		return false;
	}

	// 전화번호 조건
	if (document.frm.phone.value == '') {
		alert("전화번호를 입력하세요.");
		return false;
	} if (!phoneLimit.test(document.frm.phone.value)) {
		alert("전화번호를 확인해 주세요.");
		return false;
	} if (document.querySelector("#phoneCkValue").value == '1') {
		alert("가입된 전화번호가 있습니다.");
		document.frm.phone.focus();
		return false;
	}

	// 이메일 조건
	if (document.frm.email.value == '') {
		alert("이메일을 입력하세요.");
		return false;
	} if (!emailLimit.test(document.frm.email.value)) {
		alert("이메일을 확인해 주세요.");
		return false;
	} if (document.querySelector("#emailCkValue").value == '1') {
		alert("가입된 이메일이 있습니다.");
		document.frm.phone.focus();
		return false;
	}

	// 주소 조건
	if (document.frm.checked_zip_code.value != 'Y') {
		alert("우편번호 찾기를 확인해 주세요");
		return false;
	}
	if (document.frm.detailed_address.value == '') {
		alert("상세주소를 입력하세요.");
		return false;
	}
	return true;
}

function sample6_execDaumPostcode() {
	// value 값 지정(가입버튼 비활성화 느낌(?)만 줌)
	var Myelement = document.querySelector('input[name="checked_zip_code"]');
	Myelement.value = "Y";
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
				document.getElementById("sample6_extraAddress").value = extraAddr;

			} else {
				document.getElementById("sample6_extraAddress").value = '';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('sample6_postcode').value = data.zonecode;
			document.getElementById("sample6_address").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("sample6_detailAddress").focus();
		}
	}).open();
}


// 삭제 확인
function removeCheck() {
	if (confirm("정말 삭제하시겠습니까??") == true) {

		return true;

	} else {

		return false;

	}

}

// 코드 중복시 문구
function productCodeCheck(codeList, target) {
	for (var i = 0; i < codeList.length; i++) {
		if (codeList[i] === target.value) {
			document.querySelector("#codeCheck").innerHTML = '사용이 가능하지 않은 상품코드 입니다.';
			document.querySelector("#codeCheck").style.color = 'red';
			document.querySelector("#codeCheckValue").value = '1';
			return;
		} else {
			document.querySelector("#codeCheck").innerHTML = '사용 가능한 상품코드 입니다.'
			document.querySelector("#codeCheck").style.color = 'green';
			document.querySelector("#codeCheckValue").value = '0';
		}
	};
}

// 상품 등록시 확인조건
function productAddUpdateSubmit() {
	if (document.querySelector(".code").value == "") {
		alert("상품코드를 입력하세요");
		document.frm.code.focus();
		return false;
	}
	if (document.querySelector("#codeCheckValue").value == '1') {
		alert("상품코드가 중복입니다.");
		document.frm.code.focus();
		return false;
	}
	if (document.querySelector(".name").value == "") {
		alert("상품명을 입력하세요");
		document.frm.name.focus();
		return false;
	}
	if (document.querySelector(".price").value == "") {
		alert("가격을 입력하세요");
		document.frm.price.focus();
		return false;
	}
	if (isNaN(document.querySelector(".price").value)) {
		alert("가격은 숫자로 입력하세요");
		document.frm.price.focus();
		return false;
	}

	return true;

}

// 상품이미지 등록시 사진 선택 안할경우
function productImageCheck() {

	if (document.frm.uploadFile.value.length === 0) {
		alert("이미지를 선택하세요");
		return false;
	} else {
		return true;
	}

}

function productImageUpdate(code, image, main) {
	if (confirm("메인으로 등록하겠습니까?") == true) {
		return true;

	} else {

		return false;

	}
}

function productImageDelete(code, image) {
	if (confirm("정말 삭제하시겠습니까?") == true) {
		return true;

	} else {

		return false;

	}
}

function getCheckedCount(target) {
	// 선택된 목록 가져오기
	const query = 'input[name="checkboxCounter"]:checked';
	const selectedElements = document.querySelectorAll(query);

	// 선택된 목록의 갯수 세기
	const count = selectedElements.length;

	if (count > 5) {
		alert('6개 이상 체크할 수 없습니다.')
		target.checked = false;
		return false;
	}
}


// select태그 중복 제거
function selectOption(target) {
	const query = 'select[name="order"]';
	const selectedElements = document.querySelectorAll(query);


	const temValue = target.value;
	for (let i = 0; i < selectedElements.length; i++) {



		if (selectedElements[i].value === target.value) {
			selectedElements[i].value = "8";
		}

		target.value = temValue;
	}


}

function alarm() {
	alert('꽝! 다음기회에~');
	return false;
}