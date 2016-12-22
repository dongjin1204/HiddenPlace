$('head').append('<script src=\'/resources/js/page/pageDao.js\'><\/script>');

function PageController() {

	var dao = new PageDao();	

	//최초의 내알못 페이지 번호 불러오기
	this.requestPage = function(themeCode, page, keyWord) {
		var pageMaker  = dao.pageIng(themeCode, page, keyWord);
		return pageMaker;
	};

	//최초의 즐겨찾기 페이지 번호 불러오기
	this.requestBookmarkPage = function(page, userId) {
		var pageMaker  = dao.bookmarkPage(page, userId);
		return pageMaker;
	};

	//최초의 댓글 페이지 번호 불러오기
	this.requestReplyPage = function(num, page) {
		var pageMaker  = dao.replyPage(num, page);
		return pageMaker;
	};

}