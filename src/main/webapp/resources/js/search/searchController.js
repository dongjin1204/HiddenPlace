$('head').append('<script src=\'/resources/js/search/searchDao.js\'><\/script>');

function SearchController() {

	var dao = new SearchDao();	

	//검색했을 시
	this.requestSearch = function(themeCode, page, keyWord) {
		var myHiddenPlaceAll  = dao.search(themeCode, page, keyWord);
		return myHiddenPlaceAll;
	};

}