
//myHiddenPlace dao 객체
function PageDao() {

//	내알못 페이지 요청 dao 메서드
	this.pageDao = function(onPage) {
		
		var pageMaker = [];
		
						try{
							$.ajax({
								url: '/myhiddenplace/page' , //홈페이지 불러올 주소
								async : false, //false: 동기, true: 비동기
								type: 'get', //요청방식 get or post      
								data: {
									page : onPage
								},
								dataType: 'json', //서버에서 보내오는 데이터 타입
								success: function (data) { //서버에서 보내오는 데이터
									pageMaker = data;
								}
							});
								
						} catch(e) {
							console.log('ArticleDao 객체 : saveDao 메서드에서 예외 발생');
							console.log(e.message);
						}			

		return pageMaker;
		
	};
	
}

