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
function count(type)  {
  // 결과를 표시할 element
  const resultElement = document.getElementById('result');
  
  // 현재 화면에 표시된 값
  let number = resultElement.innerText;
  
  // 더하기/빼기
  if(type === 'plus') {
    number = parseInt(number) + 1;
  }else if(type === 'minus')  {
	if (number!=1)
    number = parseInt(number) - 1;
  }
  // 결과 출력
  resultElement.innerText = number;
}