//bookmarkDao 객체
function BookmarkDao() {

	this.selectedDeleteMHP = function(delete_nums) {

		try {
			$.ajax({
				url: '/bookmark/selectedDeleteMHP', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post              
				data: {
					nums : delete_nums
				},
				dataType: 'json', //서버에서 보내오는 데이터 타입
				success: function (data) {
				}
			});
		} catch(e) {
			console.log('BookMarkDao 객체 : selectedDeleteDao 메서드에서 예외 발생');
			console.log(e.message);
		}
		
		return true;
	};

	//내알못 북마크 리스트 dao 메서드
	this.hiddenPlaceBookmarkSelectAll = function(userId, page) {

		var myHiddenPlace = [];

		try{
			$.ajax({
				url: '/bookmark/bookmarkMHPAll', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: { //보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
					userId : userId, //유저아이디 보내야함...
					page : page
				},
				dataType: 'json', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
					myHiddenPlace = data;
				}
			});			
			
		} catch(e) {
			console.log('내알못Dao 객체 : 내알못 리스트 메서드에서 예외 발생');
			console.log(e.message);
		}
		
		return myHiddenPlace;
	};

	//마이루트 북마크 리스트 dao 메서드
	this.myRoutebookmarkSelectAll = function(userId) {

		var myRouteAll = [];

		try{
			$.ajax({
				url: '/bookmark/bookmarkMRAll', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: { //보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
					userId : userId//유저아이디 보내야함...
				},
				dataType: 'json', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
					myRouteAll = data;
				}
			});

		} catch(e) {
			console.log('내알못Dao 객체 : 내알못 리스트 메서드에서 예외 발생');
			console.log(e.message);
		}
		
		return myRouteAll;
	};

}