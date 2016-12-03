
function HiddenPlaceHomeDao() {

	this.selectedSearch = function(search) {

		try {
			$.ajax({
				url: '/search', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post              
				data: {
					search : search
				},
				dataType: 'json', //서버에서 보내오는 데이터 타입
				success: function (data) {
					
				}
			});

		} catch(e) {
			console.log('HiddenPlaceHomeDao 객체 : selectedSearch 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;

	};




}
