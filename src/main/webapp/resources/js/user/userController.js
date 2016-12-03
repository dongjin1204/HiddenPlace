$('head').append('<script src=\'../../../resources/js/user/userDao.js\'><\/script>');

//user controller 객체
function UserController() {

	var dao = new UserDao();

	// 회원가입
	this.requestUserInsert = function(newUser) {
		var isSuccess = dao.userInsert(newUser);

		if (isSuccess) {
			alert("회원가입 성공");
		} else {
			alert("회원가입 실패");
		}

	};

	// 닉네임 중복확인
	this.requestNicknameCheck = function(nickname) {

		var nicknameCheck = dao.nicknameCheck(nickname);
		var isSuccess;
		if (nicknameCheck === 'success') {
			alert("사용가능한 닉네임입니다.");
			isSuccess = true;
		}
		if (nicknameCheck === 'fail') {
			alert("이미 사용중인 닉네임입니다.");
			isSuccess = false;
		}

		return isSuccess;
	}

	// 이메일 인증 1
	this.requestEmailSend = function(email, certificationNum) {

		var isSuccess = dao.emailSend(email, certificationNum);

		return isSuccess;

	}
	// 이메일 인증 2
	this.requestEmailCheck = function(userInputNum, certificationNum) {

		var isEmailCheck = dao.emailCheck(userInputNum, certificationNum);

		return isEmailCheck;

	}
	//	로그인 controller 메서드
	this.requestLogin = function(user) {

		var isSuccess = dao.userLoginDao(user);
		return isSuccess;

	};

	// 회원정보 수정
	this.requestUpdate = function(user) {

		var isSuccess = dao.updateDao(user);

		return isSuccess;

	};

	// 회원탈퇴
	this.requestDelete = function(delete_pw) {

		var isSuccess = dao.test(delete_pw);
		return isSuccess;

	};

}