$('head').append('<script src=\'/resources/js/qna/qnaDao.js\'><\/script>');

function QnaController() {

	var dao = new QnaDao();

	//qna 조회 메서드
	this.requestQnaInsertPage = function() {

		var requestUrl = 'qnaInsert';
		document.location = requestUrl;
	}

	//qna 추가 메서드
	this.requestQnaInsert = function(title, content, userId) {

		var qnaInsert = dao.InsertQNA(title, content, userId);
		var requestUrl = 'qnaSelectAll';
		
		if(qnaInsert == 'success') {
			document.location = requestUrl;
		}
	};

	//qna 목록 메서드
	this.requestQnaSelectAllUrl = function(userId) {

		var qnaBoard = dao.SelectAllQNA(userId);
		return qnaBoard;
	};

	//qna 조회 넘버 메서드
	this.requestQnaSelectOnePage = function(num) {

		var requestUrl = '/qna/qnaSelectOne?num='+num;
		document.location = requestUrl;
	};

	//qna 조회 메서드
	this.requestQnaSelectOne = function(num) {

		var qnaSearch = dao.selectOneQNA(num);
		return qnaSearch;
	}

	//qna 삭제 메서드
	this.requestQnaDelete = function(num) {

		var isSuccess = dao.deleteQNA(num);
		return isSuccess;
	}

	//qna 수정 메서드
	this.requestQnaUpdate = function(num, title, content) {

		var isSuccess  = dao.updateQNA(num,title,content);
		var requestUrl = '/qna/qnaSelectOne?num=' + num;

		if (isSuccess == "success"){
			alert("정상");
			document.location.href = requestUrl;    
		}
	};

	//qna 수정 호출
	this.requestQnaUpdatePage = function(num) {

		var requestUrl = '/qna/qnaUpdate?num='+num;
		document.location = requestUrl;
	};

}