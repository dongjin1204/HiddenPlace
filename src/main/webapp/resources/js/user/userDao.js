//user dao 객체
function UserDao() {

   var isSuccess;

   // 회원가입
   this.userInsert = function(newUser) {

      try {
         $.ajax({
            url : '/user/insert', // 홈페이지 불러올 주소
            async : false, // false: 동기, true: 비동기
            type : 'post', // 요청방식 get or post
            data : {
               userId : newUser.userId,
               userPw : newUser.userPw,
               userNickname : newUser.userNickname,
               userPhoneNum : newUser.userPhoneNum
            // user : newUser
            },
            dataType : 'text', // 서버에서 보내오는 데이터 타입
            success : function(data) { // 서버에서 보내오는 데이터
               isSuccess = data;
            }
         });
         
      } catch (e) {
         console.log('userDao 객체 : userInsert 메서드에서 예외 발생');
         console.log(e.message);
      }

      return isSuccess;
   };

   // 닉네임 중복확인
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

   // 이메일로 인증코드 전송
   this.emailSend = function(email, certificationNum) {

      try {
         $.ajax({
            url : '/user/emailSend',
            async : false, // false: 동기, true: 비동기
            type : 'post',
            data : {
               email : email,
               certificationNum : certificationNum
            },
            dataType : 'text', // 서버에서 보내오는 데이터 타입
            success : function(data) {
               isSuccess = data;
            }
         });
         
      } catch (e) {
         console.log('userDao 객체 : emailSend 메서드에서 예외 발생');
         console.log(e.message);
      }
      
      return isSuccess;
   };

   // 비밀번호 찾기 (변경)
   this.forgetPwUpdate = function(email, newPw) {
	   
      try {
         $.ajax({
            url : '/user/forgetPwUpdateView',
            async : false, // false: 동기, true: 비동기
            type : 'post',
            data : {
               email : email,
               newPw : newPw
            },
            dataType : 'text', // 서버에서 보내오는 데이터 타입
            success : function(data) {
               isSuccess = data; // success
            }
         });
         
      } catch (e) {
         console.log('userDao 객체 : forgetPw 메서드에서 예외 발생');
         console.log(e.message);
      }

      return isSuccess;
   };

   // 비밀번호 찾기 이메일 인증번호 전송
   this.forgetEmailSend = function(email, certificationNum) {

      try {
         $.ajax({
            url : '/user/forgetEmailSend',
            async : false, // false: 동기, true: 비동기
            type : 'post',
            data : {
               email : email,
               certificationNum : certificationNum
            },
            dataType : 'text', // 서버에서 보내오는 데이터 타입
            success : function(data) {
               isSuccess = data;
            }
         });
         
      } catch (e) {
         console.log('userDao 객체 : forgetEmailSend 메서드에서 예외 발생');
         console.log(e.message);
      }
      
      return isSuccess;
   }

   // 로그인
   this.login = function(user) {

      try {
         $.ajax({
            url : '/user/login',
            async : false,
            type : 'post',
            data : {
               userPw : user.userPw,
               userId : user.userId
            },
            dataType : 'text',
            success : function(data) {
               isSuccess = data; // 로그인 성공시 dest(다시 요청해줄 페이지), idFail, pwFail
            }
         });
         
      } catch (e) {
         console.log('userDao 객체 : login 메서드에서 예외 발생');
         console.log(e.message);
      }

      return isSuccess;
   };

   // 로그아웃
   this.logout = function(userId) {

      try {
         $.ajax({
            url : '/user/logout',
            async : false,
            type : 'post',
            data : {
               userId : userId
            },
            dataType : 'text',
            success : function(data) {
               isSuccess = data; // success
            }
         });
         
      } catch (e) {
         console.log('userDao 객체 : logout 메서드에서 예외 발생');
         console.log(e.message);
      }

      return isSuccess;
   }

   // 회원정보 수정 (닉네임만 변경)
   this.userUpdateN = function(email, nowPw, newNickname) {
	   
      try {
         $.ajax({
            url : '/user/userUpdate',
            async : false,
            type : 'post',
            data : {
               email : email,
               nowPw : nowPw,
               newNickname : newNickname
            },
            dataType : 'text', // 서버에서 보내오는 데이터 타입
            success : function(data) {
               isSuccess = data; // success or fail
            }
         });

      } catch (e) {
         console.log('ArticleDao 객체 : userUpdate 메서드에서 예외 발생');
         console.log(e.message);
      }

      return isSuccess;
   };

   // 회원정보 수정(패스워드)
   this.userUpdateP = function(email, nowPw, newPw, newNickname) {

      try {
         $.ajax({
            url : '/user/userUpdate',
            async : false,
            type : 'post',
            data : {
               email : email,
               nowPw : nowPw,
               newPw : newPw,
               newNickname : newNickname
            },
            dataType : 'text', // 서버에서 보내오는 데이터 타입
            success : function(data) {
               isSuccess = data; // success or fail
            }
         });

      } catch (e) {
         console.log('ArticleDao 객체 : userUpdate 메서드에서 예외 발생');
         console.log(e.message);
      }

      return isSuccess;
   };

   // 마이페이지 접근권한
   this.mypageAuth = function(userId) {

      try {
         $.ajax({
            url : '/user/mypageAuth',
            async : false,
            type : 'post',
            data : {
               userId : userId
            },
            dataType : 'text', // 서버에서 보내오는 데이터 타입
            success : function(data) {
               isSuccess = data; // success, fail
            }
         });

      } catch (e) {
         console.log('ArticleDao 객체 : mypageView 메서드에서 예외 발생');
         console.log(e.message);
      }

      return isSuccess;
   }

   // 회원탈퇴
   this.userDelete = function(email, pw) {

      try {
         $.ajax({
            url : '/user/userDelete',
            async : false,
            type : 'post',
            data : {
               userId : email,
               userPw : pw
            },
            dataType : 'text', // 서버에서 보내오는 데이터 타입
            success : function(data) {
               isSuccess = data; // success or fail
            }
         });
         
      } catch (e) {
         console.log("userDao 객체: userDelete 메서드에서 예외 발생");
         console.log(e.message);
      }

      return isSuccess;
   };

   // 회원 닉네임 가져오기
   this.getNickname = function(userId) {

      var nickname;

      try {
         $.ajax({
            url : '/user/getNickname',
            async : false,
            type : 'post',
            data : {
               userId : userId
            },
            dataType : 'json', // 서버에서 보내오는 데이터 타입
            success : function(data) { // user
               user = data; // nickname
               nickname = user.userNickname;
            }
         });
         
      } catch (e) {
         console.log("userDao 객체: getNickname 메서드에서 예외 발생");
         console.log(e.message);
      }
      
      return nickname;
   }

   // Facebook login dao
   this.FBLoginDao = function() {
	   
      var user;
      var result;
      
      // 페이스북 로그인 API
      FB.login(function(response) {
         if (response.status === 'connected') { // 로그인되면
            facebookAPI();
         } else if (response.status === 'not_authorized') {
         } 
      }, {
         scope : 'public_profile, email'
      });

   };

   function facebookAPI() {

      var result;
      FB.api('/me?fields=email, first_name, last_name', function(response) {

         var user = {
            userId : response.email,
            userNickname : response.last_name + response.first_name
         };

         $.ajax({
            type : 'post',
            url : '/user/externalLogin',
            headers : {
               "Content-Type" : "application/json",
               "X-HTTP-Method-Override" : "POST"
            },
            data : JSON.stringify(user),
            dataType : 'text', // 서버에서 보내오는 데이터 타입
            async : false,
            success : function(data) { // dest, fail
               result = data;
               if (result === "fail") {
                  alert("페이스북 계정 로그인에 오류가 발생하였습니다.");
               } else if (result === "success"){
                  alert("페이스북 계정으로 로그인하셨습니다.")
                  localStorage.setItem('userId', user.userId); // 로그인 성공시 로컬세션에 로그인 성공한 ID를 저장시킴
                  window.location.reload(); // 새로고침
               }
            }
         });
      });
   }

   // facebook API
   window.fbAsyncInit = function() {
      FB.init({
         appId : '916384101825169',
         status : true,
         cookie : true, // enable cookies to allow the server to access the session
         xfbml : true, // parse social plugins on this page
         version : 'v2.8' // use graph api version 2.8
      });

      FB.getLoginStatus(function(response) {
         statusChangeCallback(response);
      });

   };

   (function(d, s, id) {
      var js, fjs = d.getElementsByTagName(s)[0];
      if (d.getElementById(id))
         return;
      js = d.createElement(s);
      js.id = id;
      js.src = "//connect.facebook.net/ko_KR/sdk.js";
      fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));

   function checkLoginState() {
      FB.getLoginStatus(function(response) {
         statusChangeCallback(response);
      });
   }

   function statusChangeCallback(response) {
      console.log('statusChangeCallback');
      console.log(response);
   }

}