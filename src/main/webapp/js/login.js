/**
 * 
 */
 // 로그인
// 로그인 아이디 체크
function idCheck() {
	if (document.frm.id.value == '' || document.frm.id.value == '아이디') {
		alert("아이디를 입력하세요");
		return false;
	}

	if (document.frm.pass.value == '' || document.frm.pass.value == '비밀번호') {
		alert("비밀번호를 입력하세요");
		return false;
	}
	return true;
}