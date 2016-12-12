$('head').append('<script src=\'/resources/js/myhiddenplace/myHiddenPlaceDao.js\'><\/script>');

//myHiddenPlace controller 객체
function MyHiddenPlaceController() {

   var dao = new MyHiddenPlaceDao();   

// 내알못 best 3 요청 controller 메서드
   this.requestBestMHP = function() {

	  var myHiddenPlaces  = dao.bestMHP();
      
      return myHiddenPlaces;

   };
	
// 글 조회(홈페이지에서 클릭이벤트) controller 메서드
	this.requestSelectOneMHP = function(num) {
		
		var myHiddenPlace = dao.selectOneMHP(num);
		var requestUrl = 'myHiddenPlaceSelectOne.html/num=' + num;
		
		document.location = requestUrl;
		
		return myHiddenPlace
	};
	
// 글 목록 페이지요청 controller 메서드
	this.requestMHPUrl = function() {
		
		var requestUrl = 'myHiddenPlaceSelectAll.html';
		
		document.location = requestUrl;
		
	};
	
//	내알못 추천 메서드
	this.requestUpcount = function(upCountCode) {

		var isSuccess = dao.upCount(upCountCode);

		return isSuccess;

	};

//	내알못 댓글추가 메서드
	this.requestReplyInsert = function(nickName, comment) {

		var isSuccess = dao.replyInsert(nickName, comment);
		return isSuccess;

	};

//	내알못 댓글목록 메서드
	this.requestReplySelectAll = function(num) {

		var replies = dao.replySelectAll(num);
		return replies;

	};

//	내알못 댓글수정 메서드
	this.requestReplyUpdate = function(num, replyNum, updateComment) {

		var isSuccess = dao.replyUpdte(num, replyNum, updateComment);
		return isSuccess;
	};
	

//	내알못 댓글삭제 메서드
	this.requestReplyDelete = function(num, replyNum) {

		var isSuccess = dao.replyDelete(num, replyNum);
		return isSuccess;
	};
	
	
//내알못 글쓰기 메서드
	this.requestInsertMHP = function(content,latitude, longitude,mhpStoreName,mhpTitle,mhpThema,mhpTitleImg) {
		
		var isSuccess  = dao.myHiddenPlaceInsert(content,latitude, longitude,mhpStoreName,mhpTitle,mhpThema,mhpTitleImg);

		var requestUrl = '/myhiddenplace/myHiddenPlaceSelectAll';

		if (isSuccess == true){
			  document.location = requestUrl;
		}else {
			return;
		}

	};
	
	// 내알못 리스트 controller 메서드
	   this.requestHiddenPlaceSelectAll = function() {

	      var myHiddenPlaceAll  = dao.hiddenPlaceSelectAll();
	      return myHiddenPlaceAll;

	   };
	   
		// 테마 카테고리 요청 controller 메서드
	   this.requestThemeCategory = function() {

	      var themeCategoryAll  = dao.themeCategory();
	      return themeCategoryAll;

	   };
	
//홈페이지 현재 로그인 유저의 내알못 즐겨찾기 목록	
	this.requestBookmarkAllMHP = function(nowLoginId) {
		
		var bookmarkAll = dao.bookmarkAll(nowLoginId);
		
		return bookmarkAll;
		
	}
}