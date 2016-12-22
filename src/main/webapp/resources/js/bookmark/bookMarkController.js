$('head').append('<script src=\'../../../resources/js/bookmark/bookmarkDao.js\'><\/script>');

//bookmark controller 객체
function BookmarkController() {

	var dao = new BookmarkDao();	

	//선택 글삭제 controller 메서드
	this.requestSelectedDeleteMHP = function(delete_nums) {
		dao.selectedDeleteMHP(delete_nums);
	};

	//내알못 즐겨찾기 리스트 controller 메서드
	this.requestHiddenPlaceBookmarkSelectAll = function(userId, page) {
		var myHiddenPlace  = dao.hiddenPlaceBookmarkSelectAll(userId, page);
		return myHiddenPlace;
	};	
	
	//나만의 루트 즐겨찾기 리스트 controller 메서드
	this.requestMyRouteBookmarkSelectAll = function(userId) {
		var myHiddenPlaceAll  = dao.myRoutebookmarkSelectAll(userId);
		return myHiddenPlaceAll;
	};	

}