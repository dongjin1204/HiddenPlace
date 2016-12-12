//myHiddenPlace dao 객체
function MyHiddenPlaceDao() {

//	내알못 best 3 요청 dao 메서드
	this.bestMHP = function() {
		
		var myHiddenPlaces = [];

		try{

//			$.ajax({
//				url: '/myhiddenplace/bestMHP' , //홈페이지 불러올 주소
//				async : false, //false: 동기, true: 비동기
//				type: 'get', //요청방식 get or post      
//				data: {
//					//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
//				},
//				dataType: 'json', //서버에서 보내오는 데이터 타입
//				success: function (data) { //서버에서 보내오는 데이터
//				
//						myHiddenPlaces = data;
//				
//				}
//			});
			
			var myHiddenPlace1 = {
					num:1, //글번호 hidden으로할거임
					userNickname:"이동진", //유저닉네임
					writeDate:20161206, //작성일자
					readCount:1, //조회수
					imageUrl:"../../../resources/customize/images/camera.jpeg", //이미지 경로
					title:"#여기" //글제목
			}
			
			var myHiddenPlace2 = {
					num:2,
					userNickname:"이동진",
					writeDate:20161206,
					readCount:1,
					imageUrl:"../../../resources/customize/images/beer.jpeg",
					title:"#부천 #북카페"
			}
			
			var myHiddenPlace3 = {
					num:3,
					userNickname:"이동진",
					writeDate:20161206,
					readCount:1,
					imageUrl:"../../../resources/customize/imagesg/bookcafe.jpeg",
					title:"#가산디지털단지 #여기는 어디인가요"
			}
			
			myHiddenPlaces.push(myHiddenPlace1);
			myHiddenPlaces.push(myHiddenPlace2);
			myHiddenPlaces.push(myHiddenPlace3);
			
		} catch(e) {
			console.log('bestMHP Dao 객체 : bestMHP Dao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return myHiddenPlaces;
		
	};
	
//	내알못 조회 dao 메서드
	this.selectOneMHP = function(num) {

		var myHiddenPlace;
		
		try{

			$.ajax({
				url: '/myhiddenplace/selectOneMHP',
				async : false,
				type: 'get',     
				data:{
					num: num	
				},
				dataType: 'json', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
					//alert(JSON.stringify(data));
					myHiddenPlace = data;
				}	
					});	
					
				}catch(e) {
					console.log('selectOneMHP 객체 : selectOneDao 메서드에서 예외 발생');
					console.log(e.message);
				}
				
				return myHiddenPlace;

			};

	

//	추천(좋아요) dao 메서드
	this.upCount = function(upCountCode) {
		alert("dao 도착");
		var isSuccess;
		try {
			$.ajax({
				url: '/', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post              
				data: {
					upCountCode : upCountCode
				},
				dataType: 'json', //서버에서 보내오는 데이터 타입
				success: function (data) {
					
					var messageValue =$(data).find('message').text();
					isSuccess = eval('(' + messageValue + ')');
					
				}
			});
			
		} catch(e) {
			console.log('ArticleDao 객체 : saveDao 메서드에서 예외 발생');
			console.log(e.message);
		}
		if(upCountCode==0){
			isSuccess = false;	
		} else {
			isSuccess = true;	
		}
		alert(isSuccess);
		return isSuccess;
		
	};
	
	
//	댓글 추가 dao 메서드
	this.replyInsert = function(nickName, comment) {
		alert("Insertdao 도착");
		var isSuccess;
		try{
			
			$.ajax({
				url: '/' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					nickName : nickName,
					comment : comment
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
					
					$(data).find('myHiddenPlace').each( function(){
						
						var messageValue =$(data).find('message').text();
						isSuccess = eval('(' + messageValue + ')');
						
						});					
						
					}
					
				});
				
		} catch(e) {
			console.log('reply Dao 객체 : replyInsert 메서드에서 예외 발생');
			console.log(e.message);
		}
		
		return isSuccess;
	};
	
	
	//댓글 목록 dao 메서드
	this.replySelectAll = function(num) {
		alert("SelectAlldao 도착");
		var replies = [];	
		try{
			
			$.ajax({
				url: '/' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					num: num
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
					
					$(data).find('replies').each( function(){
						var reply = {
							replyNum:$(this).find('userNickname').text(),
							userNickname:$(this).find('userNickname').text(),
							comment:$(this).find('comment').text()
						}					
						
						replies.push(reply);
					});	
					
				}
			});
			
				
		} catch(e) {
			console.log('replies 객체 : replySelectAll 메서드에서 예외 발생');
			console.log(e.message);
		}

		return replies;
	};
	
	
	//댓글삭제 dao
	this.replyDelete = function(num, replyNum) {
		alert("replyDeleteDao 도착");
		var isSuccess;
		try{

			$.ajax({
				url: '/',
				async : false,
				type: 'get',               
				data: {
					num : num,
					replyNum : replyNum
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) {
					var messageValue =$(data).find('message').text();
					isSuccess = eval('(' + messageValue + ')');
				}
			});

		}catch(e) {
			console.log('ArticleDao 객체 : selectOneDao 메서드에서 예외 발생');
			console.log(e.message);
		}   

		return isSuccess;
	};
		

	//댓글 수정 dao
	this.replyUpdte = function(num, replyNum, updateComment) {
		alert("replyUpdteDao 도착");
		var isSuccess;
		try{

			$.ajax({
				url: '/',
				async : false,
				type: 'get',               
				data: {
					num : num,
					replyNum : replyNum,
					updateComment : updateComment
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) {
					var messageValue =$(data).find('message').text();
					isSuccess = eval('(' + messageValue + ')');
				}
			});

		}catch(e) {
			console.log('replyUpdteDao 객체 : replyUpdteDao 메서드에서 예외 발생');
			console.log(e.message);
		}   

		return isSuccess;
	};
	
	
//	내알못 글쓰기 dao
	this.myHiddenPlaceInsert = function(content,latitude, longitude,mhpStoreName,mhpTitle,mhpThema,mhpTitleImg) {
		
		var isSuccess;
			try {
				$.ajax({
					url : '/myhiddenplace/insertMHP', // 홈페이지 불러올 주소
					async : false, // false: 동기, true: 비동기
					type : 'post', // 요청방식 get or post
					data : {
						
						content : content,
						latitude : latitude,
						longitude : longitude,
						storeName : mhpStoreName,
						title : mhpTitle,
						themeCode : mhpThema,
						titleImgUrl : mhpTitleImg
						
					},
					dataType: 'text', //서버에서 보내오는 데이터 타입
					success: function (data) {

						isSuccess = data; // success
						
					}
				});

			}catch(e) {
				console.log('ArticleDao 객체 : selectOneDao 메서드에서 예외 발생');
				console.log(e.message);
			}   
			
			alert(isSuccess);
			return isSuccess;
		};
		

//		내알못 로그인한 유저의 즐겨찾기 목록 요청 dao 메서드
		this.bookmarkAll = function(nowLoginId) {
			
			var bookmarkAll = [];

			try{

//				$.ajax({
//					url: '/myhiddenplace/bookmarkAll' , //홈페이지 불러올 주소
//					async : false, //false: 동기, true: 비동기
//					type: 'get', //요청방식 get or post      
//					data: {
//						userId : nowLoginId//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
//					},
//					dataType: 'json', //서버에서 보내오는 데이터 타입
//					success: function (data) { //서버에서 보내오는 데이터
//					
//							bookmarkAll = data;
//					
//					}
//					
//				});
				
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
				console.log('myHiddenPlaceDao 객체 : bookmarkAll Dao 메서드에서 예외 발생');
				console.log(e.message);
			}

			return bookmarkAll;
			
		};
		
		
		//내알못 베스트 업데이트
		this.updateBestMHP = function() {

			try{

				$.ajax({
					url: '/myhiddenplace/bestUpdateMHP' , //홈페이지 불러올 주소
					async : false, //false: 동기, true: 비동기
					type: 'get', //요청방식 get or post      
					data: {
						//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
					},
					dataType: 'text', //서버에서 보내오는 데이터 타입
					success: function (data) { //서버에서 보내오는 데이터
									
						alert(data);

					}
				});
			} catch (e) {
				console.log('updateBestMHP 객체 : updateBestMHP 메서드에서 예외 발생');
				console.log(e.message);
			}
		};

}