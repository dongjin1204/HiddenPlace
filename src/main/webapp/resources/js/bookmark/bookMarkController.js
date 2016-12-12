$('head').append('<script src=\'../../../resources/js/bookmark/bookMarkDao.js\'><\/script>');


//bookmark controller 객체
function BookMarkController() {

	var dao = new BookMarkDao();	

	
//	선택 글삭제 controller 메서드
	this.requestSelectedDeleteMHP = function(delete_nums) {
		alert(delete_nums);
		dao.selectedDeleteMHP(delete_nums);


	};
	

	
}
