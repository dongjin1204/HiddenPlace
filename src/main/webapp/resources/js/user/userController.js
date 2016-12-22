$("head").append("<script src=\"/resources/js/user/userDao.js\"><\/script>");

//user controller 객체
function UserController() {

	var dao = new UserDao();

	//where 회원정보관리
	this.requestMypageUrl = function() {
		
		var userId = localStorage.getItem("userId");
		var requestUrl = "/user/mypageView";
		var isSuccess = dao.mypageAuth(userId);
		if (isSuccess === "success") {
			document.location = requestUrl;
		} else if (isSuccess === "fail") {
			alert("일반 회원가입 사용자만 회원 정보를 수정할 수 있습니다.");
		}
	};

	//로그아웃 controller 메서드
	this.requestLogout = function(userId) {
		
		var isSuccess = dao.logout(userId);
		return isSuccess;
	};

	//회원가입
	this.requestUserInsert = function(newUser) {
		
		var isSuccess = dao.userInsert(newUser);
		return isSuccess;
	};
	
	//회원가입
	this.requestUserInsertModal = function(newUser) {
		
		var isSuccess = dao.userInsert(newUser);
		if (isSuccess === "success") {
			alert("회원가입 성공");
			modalAnimate($formRegister, $formLogin); //회원가입 성공시 로그인 모달로 이동
		} else {
			alert("회원가입 실패");
		}
	};
	
	//닉네임 중복확인
	this.requestNicknameCheck = function(nickname) {
		
		var nicknameCheck = dao.nicknameCheck(nickname);
		var isSuccess = false;
		if (nicknameCheck === "success") {
			alert("사용가능한 닉네임입니다.");
			isSuccess = true;
		}
		if (nicknameCheck === "fail") {
			alert("이미 사용중인 닉네임입니다.");
			isSuccess = false;
		}
		
		return isSuccess;
	}

	//회원가입 이메일 인증번호 전송
	this.requestEmailSend = function(email, certificationNum) {
		
		var emailSendCheck = dao.emailSend(email, certificationNum);
		var isSuccess = false;
		if (emailSendCheck === "success") {
			alert("인증번호가 전송되었습니다.");
			isSuccess = true;
		} else if (emailSendCheck === "fail") {
			alert("이미 사용중인 이메일입니다.");
			isSuccess = false;
		}
		
		return isSuccess;
	}

	//비밀번호 찾기(변경) 페이지요청 controller 메서드
	this.requestForgetPwUpdateUrl = function(email) {
		
		var requestUrl = "forgetPwUpdateView/" + email;
		document.location = requestUrl;
	};

	//비밀번호 찾기 (변경)
	this.requestForgetPwUpdate = function(email, newPw) {
		
		var isSuccess = dao.forgetPwUpdate(email, newPw);
		if (isSuccess === "success") {
			alert("비밀번호가 변경되었습니다.");
			requestLoginUrl(); // 로그인 페이지로 이동
		} else {
			alert("비밀번호를 변경하는데 오류가 발생하였습니다.");
		}
	}

	//비밀번호 찾기(변경) 페이지요청 controller 메서드
	this.requestForgetPwUpdateModalUrl = function(email) {
		
		localStorage.setItem("email", email); //비밀번호 찾기 인증 성공시 다음 모달 페이지로 넘기는
		//이메일을 로컬세션에 저장
		modalAnimate($formLost, $formLostUpdate); //다음 모달 페이지로 전환
	};

	//비밀번호 찾기 (변경)
	this.requestForgetPwUpdateModal = function(newPw) {
		
		var email = localStorage.getItem("email"); //이전 페이지에서 가져오는 email
		var isSuccess = dao.forgetPwUpdate(email, newPw);
		if (isSuccess === "success") {
			alert("비밀번호가 변경되었습니다.");
			localStorage.removeItem('email');
			localStorage.clear();
			modalAnimate($formLostUpdate, $formLogin); //로그인 모달 페이지로 전환
		} else {
			alert("비밀번호를 변경하는데 오류가 발생하였습니다.");
		}
	}

	//비밀번호 찾기 이메일 인증번호 전송
	this.requestForgetPwEmailSend = function(email, certificationNum) {
		
		var emailSendCheck = dao.forgetEmailSend(email, certificationNum);
		var isSuccess = false;
		if (emailSendCheck === "success") {
			alert("인증번호가 전송되었습니다.");
			isSuccess = true;
		} else if (emailSendCheck === "fail") {
			alert("존재하지 않는 이메일입니다.");
			isSuccess = false;
		}
		return isSuccess;
	}

	//로그인
	this.requestLogin = function(user) {
		
		var isSuccess = dao.login(user);
		if (isSuccess === "idFail") {
			$("#pw").prop("value", "");
			$("#id").focus();
			alert("존재하지 않는 아이디입니다.");
		} else if (isSuccess === "pwFail") {
			$("#pw").prop("value", "");
			$("#pw").focus();
			alert("비밀번호가 일치하지 않습니다.");
		} else {
			alert("로그인 성공");
			localStorage.setItem("userId", user.userId); //로그인 성공시 로컬세션에 로그인
			//성공한 ID를 저장시킴
			document.location = isSuccess; //ex) user/mypageView
		}
	};
	
	//로그인
	this.requestLoginModal = function(user) {
		
		var isSuccess = dao.login(user);
		if (isSuccess === "idFail") {
			$("#pw").prop("value", "");
			$("#id").focus();
			alert("존재하지 않는 아이디입니다.");
		} else if (isSuccess === "pwFail") {
			$("#pw").prop("value", "");
			$("#pw").focus();
			alert("비밀번호가 일치하지 않습니다.");
		} else if (isSuccess === "success") {
			alert("로그인 성공");
			localStorage.setItem("userId", user.userId); //로그인 성공시 로컬세션에 로그인
			//성공한 ID를 저장시킴
			window.location.reload(); //페이지 새로고침
		}
	};
	
	//회원정보 수정 (닉네임만 변경)
	this.requestUserUpdateN = function(email, nowPw, newNickname) {
		
		var isSuccess = dao.userUpdateN(email, nowPw, newNickname);
		
		if (isSuccess === "success") {
			alert("회원 정보 수정이 완료되었습니다.");
			window.location.reload(); //페이지 새로고침
		} else if (isSuccess === "fail") {
			alert("회원님의 비밀번호가 일치하지 않습니다.");
			window.location.reload();
		}
		
		return isSuccess;
	};

	//회원정보 수정 (패스워드도 변경)
	this.requestUserUpdateP = function(email, nowPw, newPw, newNickname) {
		
		var isSuccess = dao.userUpdateP(email, nowPw, newPw, newNickname);
		if (isSuccess === "success") {
			alert("회원 정보 수정이 완료되었습니다.");
			//메인홈페이지 url 메서드
			window.location.reload(); //페이지 새로고침
		} else if (isSuccess === "fail") {
			alert("회원님의 비밀번호가 일치하지 않습니다.");
		}
		
		return isSuccess;
	};

	//회원탈퇴
	this.requestUserDelete = function(email, pw) {
		
		var isSuccess = dao.userDelete(email, pw);
		var requestUrl = "/";
		
		if (isSuccess === "success") {
			alert("회원 탈퇴가 완료되었습니다.");
			localStorage.clear(); // 세션 초기화
			document.location = requestUrl;
		} else if (isSuccess === "fail") {
			alert("회원님의 비밀번호가 일치하지 않습니다.");
		}
	};

	//서버에서 닉네임 가져오기
	this.requestGetNickname = function(userId) {
		
		var nickname = dao.getNickname(userId);
		return nickname;
	}

	//Facebook login controller
	this.requestFBLogin = function() {
		
		dao.FBLoginDao();
	};

	//Modal 페이지 전환을 위한 변수, 함수
	var $formLogin = $('#login-form');
	var $formLost = $('#lost-form');
	var $formLostUpdate = $('#lostUpdate-form');
	var $formRegister = $('#register-form');
	var $divForms = $('#div-forms');
	var $modalAnimateTime = 300;
	var $msgAnimateTime = 150;
	var $msgShowTime = 2000;
	
	function modalAnimate($oldForm, $newForm) {
		
		var $oldH = $oldForm.height();
		var $newH = $newForm.height();
		$divForms.css("height", $oldH);
		$oldForm.fadeToggle($modalAnimateTime, function() {
			$divForms.animate({
				height : $newH
			}, $modalAnimateTime, function() {
				$newForm.fadeToggle($modalAnimateTime);
			});
		});
	}

}