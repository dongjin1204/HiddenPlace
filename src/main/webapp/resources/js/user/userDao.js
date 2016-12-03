//user dao 객체
function UserDao() {
	// 회원가입 메서드
	this.userInsert = function(newUser) {
		try {
			$.ajax({
				url : '/user/userInsertView', // 홈페이지 불러올 주소
				async : false, // false: 동기, true: 비동기
				type : 'post', // 요청방식 get or post
				data : {
					userId : newUser.userId,
					userPw : newUser.userPw,
					userNickname : newUser.userNickname,
					userPhoneNum : newUser.userPhoneNum
				},
				dataType : 'text', // 서버에서 보내오는 데이터 타입
				success : function(data) { // 서버에서 보내오는 데이터

					alert(data);
					isSuccess = data;

				}
			});
		} catch (e) {
			console.log('userDao 객체 : userInsert 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;
	};

	// 회원가입 닉네임 중복확인
	this.nicknameCheck = function(nickname) {

		try {

			$.ajax({
				url : '/user/nicknameCheck', // 닉네임 중복 체크할 곳
				async : false, // false: 동기, true: 비동기
				type : 'post',
				data : {
					nickname : nickname
				},
				dataType : 'text', // 서버에서 보내오는 데이터 타입
				success : function(data) { // 서버에서 보내오는 데이터 // data = success
					isSuccess = data;
					
				}
			});
		} catch (e) {
			console.log('userDao 객체 : nickNameCheck 메서드에서 예외 발생');
			console.log(e.message);
		}
		return isSuccess;
	};

	// 이메일로 인증코드 발송
	this.emailSend = function(email, certificationNum) {

		alert("dao까지 왔음");
		try {
			$.ajax({
				url : '/', // ㅁㅍ
				type : 'POST',
				data : {
					email : email,
					certificationNum : certificationNum
				// 메일로 보낼 인증번호
				},
				success : function(data) {
					$("#email_alert").hide();

					if (data == 'emailCheckOK') {
						alert("이메일이 전송되었습니다.")
						isSuccess = true;
					} else if (data == 'emailCheckFail') {
						alert("중복된 이메일 입니다. 다른 이메일을 입력하여주십시오.")
					}
				}
			});
		} catch (e) {
			console.log('userDao 객체 : emailSend 메서드에서 예외 발생');
			console.log(e.message);
		}
		return isSuccess;

	};

	// 이메일로 인증코드 확인
	this.emailCheck = function(userInputNum, certificationNum) {

		try {
			$.ajax({
				url : '/seoulmate/member/regist/emailcheck',
				data : {
					userInputNum : userInputNum,
					certificationNum : certificationNum
				},
				type : 'POST',
				success : function(data) {

					if (data == 'emailCheckSuccess') {
						alert("이메일 인증에 성공하였습니다.");
						/* emailInput(); */
						$('#email_join').attr("readonly", "readonly");
						$('#email_confirm').attr("readonly", "readonly");

						// $('#emailSend').attr("disabled", true);
						// $('#emailCheckSuccess').attr("disabled", true);
						$('#emailSend').attr("class", "btn disabled");
						$('#emailCheckSuccess').attr("class", "btn disabled");

						isEmailCheck = true;

					} else if (data == 'emailCheckFail') {
						alert("이메일 인증에 실패하였습니다. 인증번호를 확인하여주십시오.");
					}
				}
			});
		} catch (e) {
			console.log('userDao 객체 : userLogin 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isEmailCheck;
	};

	// 로그인
	this.userLogin = function(user) {

		try {

			$.ajax({
				url : '/', // 홈페이지 불러올 주소
				async : false, // false: 동기, true: 비동기
				type : 'post', // 요청방식 get or post
				data : {
					userId : user.uesrId,
					userPw : user.userPw
				},
				dataType : 'xml', // 서버에서 보내오는 데이터 타입
				success : function(data) { // 서버에서 보내오는 데이터

					var messageValue = $(data).find('message').text(); // 여기 나중에 수정
					isSuccess = eval('(' + messageValue + ')');

				}
			});
		} catch (e) {
			console.log('userDao 객체 : userLogin 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;

	};

	// 정보수정
	this.updateDao = function(user) {

		var update_myInfo;

		try {
			alert("수정Dao 도착");
			$.ajax({
				url : '/modify',
				async : false,
				type : 'get',
				data : {
					userNickname : user.userNickname,
					userPw : user.userPw
				},
				dataType : 'xml', // 서버에서 보내오는 데이터 타입
				success : function(data) {

					var messageValue = $(data).find('message').text(); // 여기 나중에 수정
					isSuccess = eval('(' + messageValue + ')');

				}
			});

		} catch (e) {
			console.log('ArticleDao 객체 : selectUpdateDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;

	};

	// 회원탈퇴
	this.test = function(delete_pw) {

		var isSuccess;

		try {
			$.ajax({
				url : '/deleteUser',
				async : false,
				type : 'get',
				dataType : 'json', // 서버에서 보내오는 데이터 타입
				data : ({
					userPw : delete_pw
				}),
				success : function(data) {
					console.log(data);
					var messageValue = $(data).find('message').text();
					console.log(messageValue + ", " + typeof (messageValue));
					isSuccess = eval('(' + messageValue + ')');
					console.log(isSuccess + ", " + typeof (isSuccess));
				}
			});

		} catch (e) {
			console.log("userDao 객체: userDao메서드에서 예외 발생");
			console.log(e.message);
		}

	};
}