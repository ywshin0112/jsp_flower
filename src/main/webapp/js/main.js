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




