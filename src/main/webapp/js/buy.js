// $('.photoBig').slick({
//     slidesToShow: 1,
//     slidesToScroll: 1,
//     arrows: false,
//     fade: true,
// });
// $('.smallPhoto').slick({
//     slidesToShow: 5,
//     // slidesToScroll: 1,
//     asNavFor: '.photoBig',
//     //centerMode: true,
//     focusOnSelect: true,
//     //infinite: true,
//     arrows: false
// });

$('.photoBig').slick({
	slidesToShow: 1,
	slidesToScroll: 1,
	arrows: false,
	fade: true,
	// dots: true,
	// dotsClass : "slick-dots",
});

// flowerBuyPage.jsp 수량 증감식
function count(type, target, price) {
	// 결과를 표시할 element
	const resultElement = target.parentElement.firstElementChild.nextElementSibling;

	// 현재 화면에 표시된 값
	let number = resultElement.innerText;

	// 더하기/빼기
	if (type === 'plus') {
		number = parseInt(number) + 1;
	} else if (type === 'minus') {
		if (number != 1)
			number = parseInt(number) - 1;
	}
	// 결과 출력
	resultElement.innerText = number;
	
	// 상품별 개수 저장
	target.parentElement.previousElementSibling.value = number;
	
	// 상품별 총 가격
	target.parentElement.lastElementChild.value= number* parseInt(price);

	totalPrice();
}


function addOption(target) {

	data = JSON.parse(target.value);
	const information = data.information;
	const name = data.name;
	const code = data.code;
	const price = data.price;
	const text1 = data.text1;
	const text2 = data.text2;
	const num = text1 + text2

	if (num == 11) {
		create_pTag(2, name, information, price, code);
	} else if (text1 + text2 == 1) {
		create_pTag(1, name, information, price, code);
	} else if (text1 + text2 == 0) {
		create_pTag(0, name, information, price, code);
	}
}

function create_pTag(textField, name, information, price, code) {
	const area = document.getElementById('optionBlock');
	const newTag = document.createElement('div');
	newTag.setAttribute('class', 'addOptionBox')
	const htmlText1 = `<div class="optionList"><div class="deleteBtn" onClick="return deleteOption(this)">-</div>
						<div>추가 상품 : ${name} (+ <span name="totalOptionPrice">${price}</span>원/개당)</div>
						`
	const htmlText2 = `	<input type="hidden" class="optionCode" name="optionCode" value="${code}">
						<input type="hidden" class="optionQuantity" name="optionQuantity" value="1">
						<div align="right">
							수량 : 	<input type='button' onclick='count("minus", this, "${price}")' value='-' />
									<span id='result'>1</span> <input type='button'
										onclick='count("plus", this, "${price}")' value='+' />
										
							 &nbsp;&nbsp;&nbsp;&nbsp; <input type="hidden" class="eachPrice" name="eachPrice" value="${price}">
						</div>
					</div>`
	if (textField == 2) {
		newTag.innerHTML = htmlText1 +
			`<div>내용 1 : <input type="text" name="text1" size="16"> &nbsp; 내용 2 : <input type="text" name="text2" size="16"></div>`
			+ htmlText2;
	} else if (textField == 1) {
		newTag.innerHTML =
			htmlText1 +
			`<div>내용 &nbsp: <input type="text" name="text1" size="30"><input type="hidden" name="text2" value="0"></div>`
			+ htmlText2;
	} else if (textField == 0) {
		newTag.innerHTML =
			htmlText1 +
			`<div><input type="hidden" name="text1" value="0"><input type="hidden" name="text2" value="0"></div>`
			+ htmlText2;

	}



	area.appendChild(newTag);

	document.querySelector(".addBox").value = 100;

	totalPrice();
	
}

function deleteOption(target) {
	if (confirm("옵션을 삭제하시겠습니까??") == true) { 
		target.parentElement.parentElement.remove();
		totalPrice();
		return true;
	} else {   

		return false;

	}
	
	
}

function totalPrice() {
	const num = document.querySelectorAll(".eachPrice").length;
	let totalPrice = 0;
	for (let i = 0; i < num; i++) {
		totalPrice = totalPrice + parseInt(document.querySelectorAll(".eachPrice")[i].value)
	}
	document.querySelector("#total").innerText = totalPrice;
}

function reviewIdNoneCk() {
	alert("로그인이 필요합니다.");
	return false;
}


