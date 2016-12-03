$('head').append('<script src=\'../../../resources/js/myroute/myRouteDao.js\'><\/script>');

//myHiddenPlace controller 객체
function MyRouteController() {

	var dao = new MyRouteDao();	

// 즐겨찾기 controller 메서드
	this.requestBookmarkMR = function() {
		
		var myRoutes  = dao.bookmarkMRDao();
		
		return myRoutes;
		
	};
	
}