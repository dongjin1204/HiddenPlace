$('head').append('<script src=\'../../../resources/js/bookmark/bookMarkDao.js\'><\/script>');


//bookmark controller 객체
function BookMarkController() {

	var dao = new BookMarkDao();	

	
//	선택 글삭제 controller 메서드
	this.requestSelectedDeleteMHP = function(delete_nums) {

		var isSuccess = dao.selectedDeleteMHP(delete_nums);

		if(isSuccess === true) {
		} else {
			alert('선택 글 삭제 실패');
		}

	};
	
	this.requestSelectedDeleteMR = function(delete_nums) {

		var isSuccess = dao.selectedDeleteMR(delete_nums);

		if(isSuccess === true) {
		} else {
			alert('선택 글 삭제 실패');
		}

	};
	
}
