//myHiddenPlace dao 객체
function MyRouteDao() {

//	나만의루트 best 3 요청 dao 메서드
	this.bestMR = function() {
		
		var myRoutes = [];
		
		try{

	/*		$.ajax({
				url: '/myroute/bestMR' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
				
					$(data).find('myRoute').each(function() {
						var myRoute = {
							num:$(this).find('num').text(), //글번호
							userNickname:$(this).find('userNickname').text(), //작성자
							writeDate:$(this).find('writeDate').text(), //작성일자
							readCount:$(this).find('readCount').text(), //추천수
							imageUrl:$(this).find('imageUrl').text(), //이미지경로
							title:$(this).find('title').text() //글제목
						}					
						
						myRoutes.push(myRoute);
					});
				}
			});*/
			
			var myRoute1 = {
					num:1, //글번호 hidden으로할거임
					userNickname:"이동진", //유저닉네임
					writeDate:20161206, //작성일자
					readCount:1, //조회수
					imageUrl:"../../../resources/customize/images/camera.jpeg", //이미지 경로
					title:"ㅎㅎㅎ" //글제목
			}
			
			var myRoute2 = {
					num:2, //글번호 hidden으로할거임
					userNickname:"이동진", //유저닉네임
					writeDate:20161206, //작성일자
					readCount:1, //조회수
					imageUrl:"../../../resources/customize/images/camera.jpeg", //이미지 경로
					title:"ㅎㅎㅎ" //글제목
			}
			
			var myRoute3 = {
					num:3, //글번호 hidden으로할거임
					userNickname:"이동진", //유저닉네임
					writeDate:20161206, //작성일자
					readCount:1, //조회수
					imageUrl:"../../../resources/customize/images/camera.jpeg", //이미지 경로
					title:"ㅎㅎㅎ" //글제목
			}
			
			myRoutes.push(myRoute1);
			myRoutes.push(myRoute2);
			myRoutes.push(myRoute3);
			
		} catch(e) {
			console.log('bestMR Dao 객체 : bestMR Dao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return myRoutes;
		
	};
	
this.myRouteSelectAll = function() {
		
		alert("나만의 루트 리스트 클라이언트dao 도착");
		var myRouteAll = [];

		try{

			/*$.ajax({
				url: '/' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: { //보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
					
					title : title,
					userNickName : userNickName,
					writeDate : writeDate,
					readCount : readCount,
					titleImgURL : titleImgURL,
					themeCode : themeCode, //테마별 정렬용
					userId : userId //로그인 상태 확인
					
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
					$(data).find('myHiddenPlace').each( function(){
						var myHiddenPlace = {
								title:$(this).find('title').text(), //글제목
								userNickName:$(this).find('userNickName').text(), //작성자 닉네임
								writeDate:$(this).find('writeDate').text(), //작성일자
								readCount:$(this).find('readCount').text(), //조회수
								titleImgURL:$(this).find('titleImgURL').text(), //이미지경로
								themeCode:$(this).find('themeCode').text(), //테마별 정렬용
								userId:$(this).find('userId').text() //로그인 상태 확인
								
						}					
						myHiddenPlaceAll.push(myHiddenPlace);
					});	

				}
			});*/
			var myRoute = {
					
					num: 1,
					title: "걷기좋은 데이트코스", //글제목
					userNickName: "toolbee", //작성자 닉네임
					writeDate: "2016-12-08", //작성일자
					readCount: 5635, //조회수
					titleImgURL: "images/face2.jpg", //이미지경로
					themeCode: 1, //테마별 정렬용
					userId:"toobee", //로그인 상태 확인
					bookmark: 1
					
			}
var myRoute2 = {
					
					num: 1,
					title: "걷기좋은 데이트코스", //글제목
					userNickName: "toolbee", //작성자 닉네임
					writeDate: "2016-12-08", //작성일자
					readCount: 5635, //조회수
					titleImgURL: "images/face2.jpg", //이미지경로
					themeCode: 1, //테마별 정렬용
					userId:"toobee", //로그인 상태 확인
					bookmark: 1
					
			}
			
			myRouteAll.push(myRoute);
			myRouteAll.push(myRoute2);
			


		} catch(e) {
			console.log('나만의 루트 Dao 객체 : 나만의 루트 리스트 메서드에서 예외 발생');
			console.log(e.message);
		}

		return myRouteAll;

	};

//	내알못 로그인한 유저의 즐겨찾기 목록 요청 dao 메서드
	this.bookmarkAll = function(nowLoginId) {
		
		var bookmarkAll = [];

		try{

//			$.ajax({
//				url: '/myroute/bookmarkAll' , //홈페이지 불러올 주소
//				async : false, //false: 동기, true: 비동기
//				type: 'get', //요청방식 get or post      
//				data: {
//					userId : nowLoginId//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
//				},
//				dataType: 'json', //서버에서 보내오는 데이터 타입
//				success: function (data) { //서버에서 보내오는 데이터
//				
//						bookmarkAll = data;
//				
//				}
//				
//			});
			
			var bookmark1 = {
					num:"2" //글번호 hidden으로할거임
			}
			
			var bookmark2 = {
					num:"3"
			}
			
			var bookmark3 = {
					num:"4"
			}
			
			bookmarkAll.push(bookmark1);
			bookmarkAll.push(bookmark2);
			bookmarkAll.push(bookmark3);
		
		} catch(e) {
			console.log('myRouteDao 객체 : bookmarkAll Dao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return bookmarkAll;
		
	};
	
}