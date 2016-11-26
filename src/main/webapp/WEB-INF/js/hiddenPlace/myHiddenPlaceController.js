$('head').append('<script src=\'/myHiddenPlaceDao.js\'><\/script>');


//myHiddenPlace controller 객체
function myHiddenPlaceController() {

	var dao = new myHiddenPlaceDao();	

//	홈페이지 controller 메서드
	this.requestHomepage = function(myHiddenPlace) {

		var myHiddenPlaces  = dao.homepageDao(myHiddenPlace);
		
		return myHiddenPlaces;

	};

// 즐겨찾기 controller 메서드
	this.requestBookmarkMHP = function() {
		
		var myHiddenPlaces  = dao.bookmarkDao(myHiddenPlace);
		
		return myHiddenPlaces;
		
	}
	
	
	
/*	
//	 controller 메서드
	this.requestWriteView = function() {
		document.location = "writeView.html";
	};



//	글목록 controller 메서드
	this.requestSelectAll = function() {

		var articles = dao.selectAllDao();
		return articles;

	};

//	글조회 controller 메서드
	this.requestSelectOne = function(num) {

		var article = dao.selectOneDao(num);
	
		var requestUrl = 'selectOneView.html';
		requestUrl = requestUrl + '?num=' + article.num;
		requestUrl = requestUrl + '&title=' + escape(article.title);
		requestUrl = requestUrl + '&content=' + escape(article.content);
		requestUrl = requestUrl + '&writer=' + escape(article.writer);
		requestUrl = requestUrl + '&readCount=' + article.readCount;		

		document.location = requestUrl;

	};

//	글목록뷰 controller 메서드
	this.requestSelectAllView = function() {

		document.location = 'selectAllView.html';

	};

//	글수정뷰 controller 메서드
	this.requestUpdate = function(article) {

		var isSuccess = dao.updateDao(article);
		return isSuccess;

	};

	// 선택 글 삭제 Controller 메서드   
	this.requestSelectedDelete = function(delete_nums) {

		var isSuccess = dao.selectedDeleteDao(delete_nums);

		if(isSuccess === true) {
		} else {
			alert('선택 글 삭제 실패');
		}

	};

//	글삭제 컨드롤러
	this.requestDelete = function(num) {

		var isSuccess = dao.deleteDao(num);

		if(isSuccess === true) {
		} else {
			alert('글 삭제 실패');
		}

		document.location = 'selectAllView.html';

	};
*/
	
}

//controller 객체(static)
var Controllers = function() {	

};

Controllers.articleController = new ArticleController();

Controllers.getArticleController = function() {

	return Controllers.articleController;

};

