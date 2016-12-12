function PageDao() {

	//최초의 페이지 번호 불러오기
	this.pageIng = function(page) {
		
		var pageMaker;
		var pageNum = page;
		try{

			$.ajax({
				url: '/myhiddenplace/page' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					page : pageNum
				},
				dataType: 'json', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
					pageMaker = data;
				}
			});
			
		} catch(e) {
			console.log('bestMR Dao 객체 : bestMR Dao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return pageMaker;
		
	};
	
	//페이지 클릭 이벤트 발생시 페이지 번호와 목록 불러오기
	this.MhpPageingSelectAll = function(page) {
		
		var myHiddenPlaceAll = [];
		var pageNum = page;
		try{

			$.ajax({
				url: '/myhiddenplace/myhiddenplaceSelectAll' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					page : pageNum
				},
				dataType: 'json', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
					myHiddenPlaceAll = data;
				}
			});
			
		} catch(e) {
			console.log('bestMR Dao 객체 : bestMR Dao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return myHiddenPlaceAll;
		
	};
	

}