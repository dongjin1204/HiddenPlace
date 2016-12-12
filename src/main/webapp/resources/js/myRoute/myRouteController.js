$('head').append('<script src=\'../../../resources/js/myroute/myRouteDao.js\'><\/script>');

//myHiddenPlace controller 객체
function MyRouteController() {

	var dao = new MyRouteDao();	

// 나만의루트 best 3 요청 controller 메서드
	this.requestBestMR = function() {

		var myRoutes  = dao.bestMR();
	      
		return myRoutes;

	};
	
// 글 조회(홈페이지에서 클릭이벤트) controller 메서드
	this.requestSelectOneMR = function(num) {
		
		var requestUrl = 'myRouteSelectOne.html/num=' + num;
		
		document.location = requestUrl;
		
	};
	
// 글 목록 페이지요청 controller 메서드
	this.requestMRUrl = function() {
		
		var requestUrl = 'myRouteSelectAll.html';
		
		document.location = requestUrl;
		
	};
	
//홈페이지 현재 로그인 유저의 내알못 즐겨찾기 목록	
	this.requestBookmarkAllMR = function(nowLoginId) {
		
		var bookmarkAll = dao.bookmarkAll(nowLoginId);
		
		return bookmarkAll;
		
	}

}