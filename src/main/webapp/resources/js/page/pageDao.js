function PageDao() {

	//최초의 내알못 페이지 번호 불러오기
	this.pageIng = function(themeCode, page, keyWord) {

		var pageMaker;
		var pageNum = page;

		try{

			$.ajax({
				url: '/myhiddenplace/page' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					page : pageNum,
					themeCode : themeCode,
					keyWord : keyWord
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

	//최초의 즐겨찾기 페이지 번호 불러오기
	this.bookmarkPage = function(page, userId) {

		var pageMaker;
		var pageNum = page;
		
		try {
			$.ajax({
				url: '/bookmark/bookmarkPage' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					page : pageNum,
					userId : userId
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

	//최초의 댓글 페이지 번호 불러오기
	this.replyPage = function(num, page) {

		var pageMaker;
		var pageNum = page;

		try{
			$.ajax({
				url: '/reply/replyPage' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					num : num,
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

}