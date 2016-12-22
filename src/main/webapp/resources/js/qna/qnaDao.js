
function QnaDao() {


	//qna 추가 dao 메서드
	this.InsertQNA = function(title, content, userId) {

		var isSuccess;
		
		try {
			$.ajax({
				url : '/qna/insertQNA', // 홈페이지 불러올 주소
				async : false, // false: 동기, true: 비동기
				type : 'post', // 요청방식 get or post
				data : {
					title : title,
					content : content,
					userId : userId
				},
				dataType : 'text', // 서버에서 보내오는 데이터 타입
				success : function(data) { // 서버에서 보내오는 데이터
					isSuccess = data;
				}
			});

		} catch (e) {
			console.log('reply Dao 객체 : replyInsert 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;
	};

	// 목록 dao 메서드
	this.SelectAllQNA = function(userId) {
		
		var qnaBoard = [];

		try {
			$.ajax({
				url : '/qna/selectAllQNA', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type : 'get', //요청방식 get or post      
				data : {
					userId: userId
				},
				dataType : 'json', //서버에서 보내오는 데이터 타입
				success : function(data) { //서버에서 보내오는 데이터
					qnaBoard = data;
				}
			});

		} catch (e) {
			console.log('replies 객체 : replySelectAll 메서드에서 예외 발생');
			console.log(e.message);
		}

		return qnaBoard;
	};

	//qna 조회 dao 메서드
	this.selectOneQNA = function(num) {

		var isSuccess;

		try {
			$.ajax({
				url : '/qna/selectOneQNA',
				async : false,
				type : 'GET',
				data : {
					num : num
				},
				dataType : 'json', //서버에서 보내오는 데이터 타입
				success : function(data) { //서버에서 보내오는 데이터
					isSuccess = data;
				}
			});

		} catch (e) {
			console.log('selectOneMHP 객체 : selectOneDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;
	};

	//qna삭제 메서드
	this.deleteQNA = function(num) {

		var isSuccess;
		
		try {
			$.ajax({
				url : '/qna/deleteQNA',
				async : false,
				type : 'GET',
				data : {
					num : num,
				},
				dataType : 'text', //서버에서 보내오는 데이터 타입
				success : function(data) {
					isSuccess = data;
				}
			});

		} catch (e) {
			console.log('ArticleDao 객체 : selectOneDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;
	};

	//qna 수정 dao
	this.updateQNA = function(num, title, content) {
		
		var isSuccess;
		
		try {
			$.ajax({
				url : '/qna/updateQNA',
				async : false,
				type : 'post',
				data : {
					qnaNum : num,
					title : title,
					content : content
				},
				dataType : 'text', //서버에서 보내오는 데이터 타입
				success : function(data) {
					isSuccess = data;
				}
			});

		} catch (e) {
			console.log('replyUpdteDao 객체 : replyUpdteDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;
	};
}