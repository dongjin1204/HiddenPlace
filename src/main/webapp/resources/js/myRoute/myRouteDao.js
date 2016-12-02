//myHiddenPlace dao 객체
function MyRouteDao() {
	
// 즐겨찾기 나만의루트 dao 메서드
	this.bookmarkMRDao = function() {
		
		try{

			var myRoutes = [];
			
			$.ajax({
				url: '/' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
					
					$(data).find('myRoute').each( function(){
						var myRoute = {
							title:$(this).find('title').text(), //글제목
							writer:$(this).find('writer').text(), //작성자
							writeDate:$(this).find('writeDate').text(), //작성일자
							imageUrl:$(this).find('imageUrl').text(), //이미지경로
							nowLoginId:$(this).find('nowLoginId').text() //현재로그인한 사용자아이디
						}					
						
						myRoutes.push(myRoute);
					});	
					
				}
			});

		} catch(e) {
			console.log('bookmarkMRDao 객체 : bookmarkMRDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return myRoutes;
		
	};
	
}

