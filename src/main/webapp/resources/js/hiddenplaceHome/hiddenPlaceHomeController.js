$('head').append('<script src=\'../../../resources/js/hiddenplaceHome/hiddenPlaceHomeDao.js\'><\/script>');

//myHiddenPlace controller 객체
function HiddenPlaceHomeController() {

	var dao = new HiddenPlaceHomeDao();   

	this.requestSearch = function(search) {

		dao.selectedSearch(search);
	};



}
