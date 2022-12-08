/**
 * 
 */
 function open_win(url, name){
	window.open(url, name, "width=450, height=250");
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

// 회원가입 조건 확인
function updateCheck() {
	// 정규식 모음
	let passLimit = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/g;
	let nameLimit = /^[a-zA-Zㄱ-ㅎ가-힣]{0,30}$/g;
	let emailLimit = /^([\w\.\_\-])*[a-zA-Z0-9]+([\w\.\_\-])*([a-zA-Z0-9])+([\w\.\_\-])+@([a-zA-Z0-9]+\.)+[a-zA-Z0-9]{2,8}$/g;


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







