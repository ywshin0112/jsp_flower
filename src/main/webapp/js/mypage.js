/**
 * 
 */
 function open_win(url, name){
	window.open(url, name, "width=480, height=210");
}

function WinClose(){
	window.open('','_self').close();   
	url = "FlowerServlet?command=FlowerServlet?command=flower_main";  
}

 function passCk(){
	if(document.frm.pass.value.length==0){
		alert("비밀번호를 입력해 주세요");
		return false;
	}
}

// 전화번호 중복시 문구
function phoneCheck(phoneList, target) {
	let phoneLimit = /^\d{2,3}-\d{3,4}-\d{4}$/;
	for (var i = 0; i < phoneList.length; i++) {
		if (phoneList[i] === target.value) {
			document.querySelector("#phoneCkValue").value = '1';
			return;
		} else if (!phoneLimit.test(document.frm.phone.value)) {
			document.querySelector("#phoneCkValue").value = '1';
			return;
		}
		else {
			document.querySelector("#phoneCkValue").value = '0';
		}
	};
}

// 이메일 중복시 문구
function emailCheck(emailList, target) {
	let emailLimit = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	for (var i = 0; i < emailList.length; i++) {
		if (emailList[i] === target.value) {
			document.querySelector("#emailCkValue").value = '1';
			return;
		} else if (!emailLimit.test(document.frm.email.value)) {
			document.querySelector("#emailCkValue").value = '1';
		} else {
			document.querySelector("#emailCkValue").value = '0';
		}
	};
}

// 회원가입 조건 확인
function updateCheck() {
	// 정규식 모음
	let passLimit = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/g;
	let nameLimit = /^[a-zA-Zㄱ-ㅎ가-힣]{0,30}$/g;
	let phoneLimit = /^\d{2,3}-\d{3,4}-\d{4}$/;
	let emailLimit = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;


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







