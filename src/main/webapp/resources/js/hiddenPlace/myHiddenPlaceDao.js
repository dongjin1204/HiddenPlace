
//myHiddenPlace dao 객체
function MyHiddenPlaceDao() {

//	내알못 best 3 요청 dao 메서드
	this.bestMHP = function() {
		
		var myHiddenPlaces = [];
		
		try{

			$.ajax({
				url: '/myhiddenplace/bestMHP' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
				},
				dataType: 'json', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
					myHiddenPlaces = data;
				}
			});

		} catch(e) {
			console.log('ArticleDao 객체 : saveDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return myHiddenPlaces;
		
	};

//	내알못 리스트 dao 메서드
	this.hiddenPlaceSelectAll = function() {
		
		var myHiddenPlaces = [];
		
		try{
			
			$.ajax({
				url: '/myhiddenplace/myhiddenplaceSelectAll' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
				},
				dataType: 'json', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
					myHiddenPlaces = data;
				}
			});
			
				
		} catch(e) {
			console.log('ArticleDao 객체 : saveDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return myHiddenPlaces;
		
	};
	
//	내알못 페이징 리스트 dao 메서드
	this.pageingSelectAll = function(onPage) {
		
		var myHiddenPlaces = [];
		
		try{
			
			$.ajax({
				url: '/myhiddenplace/myhiddenplaceSelectAll' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					page : onPage
				},
				dataType: 'json', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
					myHiddenPlaces = data;
				}
			});
			
				
		} catch(e) {
			console.log('ArticleDao 객체 : saveDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return myHiddenPlaces;
		
	};
	
// 즐겨찾기 내알못 dao 메서드
	this.bookmarkMHPDao = function() {
		
		var myHiddenPlaces = [];
		
		try{

			$.ajax({
				url: '/' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
					
					$(data).find('myHiddenPlace').each( function(){
						var myHiddenPlace = {
							title:$(this).find('title').text(), //글제목
							writer:$(this).find('writer').text(), //작성자
							writeDate:$(this).find('writeDate').text(), //작성일자
							upCount:$(this).find('upCount').text(), //추천수
							imageUrl:$(this).find('imageUrl').text(), //이미지경로
							nowLoginId:$(this).find('nowLoginId').text() //현재로그인한 사용자아이디
						}					
						
						myHiddenPlaces.push(myHiddenPlace);
					});	
					
				}
			});

		} catch(e) {
			console.log('bookmarkMHPDao 객체 : bookmarkMHPDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return myHiddenPlaces;
		
	};
	
	
//	글목록 dao 메서드
	this.selectAllDao = function() {

		var articles = [];

		try{
			$.ajax({
				url: '/kgs_20161031_08/louter.jsp',
				async : false,
				type: 'get',     
				data : {
					requestCommand : 'selectall'
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) {
					$(data).find('article').each( function(){
						var article = {
							num:$(this).find('num').text(),
							title:$(this).find('title').text(),
							writer:$(this).find('writer').text(),
							readCount:$(this).find('readcount').text()
						}						
						articles.push(article);
					});					
				}
			});
		} catch(e) {
			console.log('ArticleDao 객체 : selectAllDao 메서드에서 예외 발생');
			console.log(e.message);
		}	

		return articles;

	};

//	글조회 dao 메서드
	this.selectOneDao = function(num) {

		var article;

		try{

			$.ajax({
				url: '/kgs_20161031_08/louter.jsp',
				async : false,
				type: 'get',     
				data:{
					requestCommand : 'selectone',
					num: num	
				},

				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) {

					$(data).find('article').each( function(){

						article = {

								num:$(this).find('num').text(),
								title:$(this).find('title').text(),
								content:$(this).find('content').text(),
								writer:$(this).find('writer').text(),
								readCount:$(this).find('readcount').text()
								
						}

						
					});
				}
			});

		} catch(e) {
			console.log('ArticleDao 객체 : selectOneDao 메서드에서 예외 발생');
			console.log(e.message);
		}	
		return article;

	};

//	글수정 dao 메서드
	this.updateDao = function(article) {

		var update_article;

		try{

			$.ajax({
				url: '/kgs_20161031_08/louter.jsp',
				async : false,
				type: 'get',               
				data: {
					requestCommand : 'update',
					num : article.num,
					title : article.title,
					content : article.content,
					writer : article.writer
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) {
					console.log(data);
					var messageValue =$(data).find('message').text();
					console.log(messageValue + ", " + typeof(messageValue));
					isSuccess = eval('(' + messageValue + ')');
					console.log(isSuccess + ", " + typeof(isSuccess));
				}
			});

		} catch(e) {
			console.log('ArticleDao 객체 : selectUpdateDao 메서드에서 예외 발생');
			console.log(e.message);
		}	

		return isSuccess;

	};

	// 선택 글 삭제 dao 메서드
	this.selectedDeleteDao = function(delete_nums) {

		var isSuccess;

		try {
			$.ajax({
				url: '/kgs_20161031_08/louter.jsp',
				async : false,
				type: 'get',               
				data: {
					requestCommand : 'selectDelete',
					nums : delete_nums
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) {
					console.log(data);
					var messageValue =$(data).find('message').text();
					console.log(messageValue + ", " + typeof(messageValue));
					isSuccess = eval('(' + messageValue + ')');
					console.log(isSuccess + ", " + typeof(isSuccess));
				}
			});

		} catch(e) {
			console.log('ArticleDao 객체 : selectedDeleteDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;

	};

	//글삭제 dao
	this.deleteDao = function(num) {

		var isSuccess;

		try{

			$.ajax({
				url: '/kgs_20161031_08/louter.jsp',
				async : false,
				type: 'get',               
				data: {
					requestCommand : 'delete',
					num : num
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) {
					console.log(data);
					var messageValue =$(data).find('message').text();
					console.log(messageValue + ", " + typeof(messageValue));
					isSuccess = eval('(' + messageValue + ')');
					console.log(isSuccess + ", " + typeof(isSuccess));
				}
			});

		}catch(e) {
			console.log('ArticleDao 객체 : selectOneDao 메서드에서 예외 발생');
			console.log(e.message);
		}   

		return isSuccess;
	};

}

