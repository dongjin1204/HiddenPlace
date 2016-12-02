
//bookmark dao 객체
function BookMarkDao() {

	this.selectedDeleteMHP = function(delete_nums) {

		var isSuccess;
		
		alert("MHPDao 도착");

		try {
			$.ajax({
				url: '/selectedDeleteMHP', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post              
				data: {
					nums : delete_nums
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) {
					var messageValue =$(data).find('message').text();
					isSuccess = eval('(' + messageValue + ')');
				}
			});

		} catch(e) {
			console.log('BookMarkDao 객체 : selectedDeleteDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;

	};
	
	this.selectedDeleteMR = function(delete_nums) {

		var isSuccess;
		
		alert("MRDao 도착");

		try {
			$.ajax({
				url: '/', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post              
				data: {
					nums : delete_nums
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) {
					var messageValue =$(data).find('message').text();
					isSuccess = eval('(' + messageValue + ')');
				}
			});

		} catch(e) {
			console.log('BookMarkDao 객체 : selectedDeleteDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;

	};


}

