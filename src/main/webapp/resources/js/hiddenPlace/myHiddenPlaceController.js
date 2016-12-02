$('head').append('<script src=\'../../../resources/js/hiddenPlace/myHiddenPlaceDao.js\'><\/script>');

//myHiddenPlace controller 객체
function MyHiddenPlaceController() {

   var dao = new MyHiddenPlaceDao();   

//   내알못 best 3 요청 controller 메서드
   this.requestBestMHP = function() {

	  alert("컨트롤 도착");
	   
      var myHiddenPlaces  = dao.bestMHP();
      
      return myHiddenPlaces;

   };
   
// 내알못 리스트 controller 메서드
   this.requestHiddenPlaceSelectAll = function() {

      var myHiddenPlaces  = dao.hiddenPlaceSelectAll();
      
      return myHiddenPlaces;

   };
   
// 즐겨찾기 controller 메서드
	this.requestBookmarkMHP = function() {
		
		var myHiddenPlaces  = dao.bookmarkMHPDao();
		
		return myHiddenPlaces;
		
	}
}