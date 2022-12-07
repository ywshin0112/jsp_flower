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
			breakpoint: 700, //화면 사이즈 768px
			settings: {
				slidesToShow: 1
			}
		}
	]
});

$(".box2_slider").slick({
	arrows: false,
	autoplay: true,
	slidesToShow: 5,
	responsive: [ // 반응형 웹 구현 옵션
		{
			breakpoint: 900, //화면 사이즈 768px
			settings: {
				slidesToShow: 3
			}
		},
		{
			breakpoint: 700, //화면 사이즈 768px
			settings: {
				slidesToShow: 1
			}
		}
	]
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
function idCheck(){
	if(document.frm.id.value==""){
		alert("아이디를 입력해주세요");
		document.frm.id.focus();
		return;
	}
	//중복 확인 팝업창
	var url = "FlowerServlet?command=id_Ck&id="+document.frm.id.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no,   width=450, height=200")
}

function idok(){
	
	// opener 부모창 > 회원가입창
	opener.frm.id.value = document.frm.id.value;
	// reid 히든값 다시 확인
	opener.frm.reid.value = document.frm.id.value;
	self.close();
}

// 회원가입 조건 확인
function joinCheck() {
	// 정규식 모음
	let idLimit = /^(?=.*[A-Za-z])(?=.*[0-9])[a-z0-9]{3,11}$/g;
	let passLimit = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/g;
	let nameLimit = /^[a-zA-Zㄱ-ㅎ가-힣]{0,30}$/g;
	let emailLimit = /^([\w\.\_\-])*[a-zA-Z0-9]+([\w\.\_\-])*([a-zA-Z0-9])+([\w\.\_\-])+@([a-zA-Z0-9]+\.)+[a-zA-Z0-9]{2,8}$/g;

	// 아이디 조건
	if (document.frm.id.value == '') {
		alert("아이디를 입력하세요.");
		return false;
	}if (!idLimit.test(document.frm.id.value)) {
		alert("아이디는 영문, 숫자를 포함하여 4~12자 사이로 공백 없이 작성해 주세요.");
		return false;
	}

	// 비밀번호 조건
	if (document.frm.pass.value == '') {
		alert("비밀번호를 입력하세요.");
		return false;
	}if (!passLimit.test(document.frm.pass.value)) {
		alert("비밀번호는 영문, 숫자, 특수문자를 포함하여 8~16자 사이로 공백 없이 작성해 주세요.");
		return false;
	}

	// 비밀번호 중복 조건
	if (document.frm.passCk.value == '') {
		alert("비번 확인을 입력해 주세요.");
		return false;
	}if (document.frm.pass.value != document.frm.passCk.value) {
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}

	// 성명 조건
	if (document.frm.name.value == '') {
		alert("성함을 입력하세요.");
		return false;
	}if (!nameLimit.test(document.frm.name.value)) {
		alert("공백 없이 한글 성함 혹은 영문 성함으로 작성해 주세요.");
		return false;
	}

	// 전화번호 조건
	if (document.frm.phone.value == '') {
		alert("전화번호를 입력하세요.");
		return false;
	}

	// 인증번호 조건

	// 이메일 조건
	if (document.frm.email.value == '') {
		alert("이메일을 입력하세요.");
		return false;
	}if (!emailLimit.test(document.frm.email.value)) {
		alert("이메일을 확인해 주세요.");
		return false;
	}
	
	// 주소 조건
	if (document.frm.address.value == '') {
		alert("주소를 입력하세요.");
		return false;
	}
	return true;
}






