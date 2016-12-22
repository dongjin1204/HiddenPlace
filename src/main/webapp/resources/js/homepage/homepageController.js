function HomepageController() {

	//where 홈페이지
	this.requestHomepageUrl = function() {
		var requestUrl = "/";
		document.location = requestUrl;
	};

	//where 글목록
	this.requestSelectAllUrl = function() {
		var requestUrl = '/myhiddenplace/myHiddenPlaceSelectAll';
		document.location = requestUrl;
	};

	//where 즐겨찾기
	this.requestBookmarkUrl = function() {
		var requestUrl = "/bookmark/userBookmarkView";
		document.location = requestUrl;
	};

	//where 로그인페이지
	this.requestLoginUrl = function() {
		var requestUrl = "/user/loginView";
		document.location = requestUrl;
	};

	//qna 목록
	this.requestQnaSelectAllUrl = function() {
		var requestUrl = "/qna/qnaSelectAll";
		document.location = requestUrl;
	};

}