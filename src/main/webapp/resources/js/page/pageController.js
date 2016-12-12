$('head').append('<script src=\'/resources/js/page/pageDao.js\'><\/script>');

function PageController() {

	var dao = new PageDao();	

	//최초의 페이지 번호 불러오기
	this.requestPage = function(page) {

		var pageMaker  = dao.pageIng(page);
	      
		return pageMaker;

	};
	
	//페이지 클릭 이벤트 발생시 페이지 번호와 목록 불러오기
	this.requestMhpPageingSelectAll = function(page) {

		var myHiddenPlaceAll  = dao.MhpPageingSelectAll(page);
	      
		return myHiddenPlaceAll;

	};
	
}