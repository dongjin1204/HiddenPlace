package com.phoenix.hiddenplace.controller;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.hiddenplace.domain.Login;
import com.phoenix.hiddenplace.domain.User;
import com.phoenix.hiddenplace.service.UserService;
import com.phoenix.hiddenplace.util.Email;
import com.phoenix.hiddenplace.util.EmailSender;

@RestController
@RequestMapping(value = "/user")
public class UserControllerRest {

	@Inject
	private UserService service;
	@Inject
	private Email email;
	@Inject
	private EmailSender emailSender;
	@Inject
	private PasswordEncoder passwordEncoder;

	// 회원가입
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<String> insert(User user) {

		ResponseEntity<String> entity = null;

		try {
			user.setUserPw(passwordEncoder.encode(user.getUserPw()));
			service.create(user); // 유저 테이블에 정보 insert, 로그인 테이블에 정보 insert
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// 닉네임 중복확인
	@RequestMapping(value = "/nicknameCheck")
	public ResponseEntity<String> nicknameCheck(String nickname) {

		ResponseEntity<String> entity = null;
		String checkNickname = null;

		try {
			checkNickname = service.nicknameCheck(nickname); // 사용가능한 닉네임, 불가능하다면 null
			
			if (checkNickname == null) {
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	// 이메일 인증번호 발송
	@RequestMapping(value = "/emailSend", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> emailSend(HttpServletRequest request, @RequestParam("email") String reqEmail,
			@RequestParam("certificationNum") String certificationNum) {

		ResponseEntity<String> entity = null;
		
		try {
			String checkEmail = service.emailCheck(reqEmail);

			if (checkEmail == null) {
				String content = "인증 번호 : " + certificationNum; // 인증번호
				String reciver = reqEmail; // 수신자 이메일
				email.setSubject("HiddenPlace 회원가입 이메일 인증 확인 메일입니다.");
				email.setContent(content);
				email.setReciver(reciver);
				emailSender.SendEmail(email);
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	// 비밀번호 찾기 이메일 인증번호 발송
	@RequestMapping(value = "/forgetEmailSend", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> forgetEmailSend(HttpServletRequest request, @RequestParam("email") String reqEmail,
			@RequestParam("certificationNum") String certificationNum) {

		ResponseEntity<String> entity = null;
		
		try {
			String checkEmail = service.emailCheck(reqEmail);

			if (checkEmail != null && checkEmail.equals(reqEmail)) {
				String content = "인증 번호 : " + certificationNum; // 인증번호
				String reciver = reqEmail; // 수신자 이메일
				email.setSubject("HiddenPlace 비밀번호 찾기 이메일 인증 확인 메일입니다.");
				email.setContent(content);
				email.setReciver(reciver);
				emailSender.SendEmail(email);
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	// 비밀번호 찾기 (변경)
	@RequestMapping(value = "/forgetPwUpdateView", method = RequestMethod.POST)
	public ResponseEntity<String> forgetPwUpdate(String email, String newPw) {

		ResponseEntity<String> entity = null;
		
		try {
			Login login = new Login();
			login.setUserId(email); // 현재 로그온 상태의 아이디
			User searchUser = service.login(login); // 비밀번호를 변경하려는 아이디의 유저 정보를 가져옴(id,pw) 없다면 null

			searchUser.setUserPw(passwordEncoder.encode(newPw)); // 변경할 비밀번호
			service.update(searchUser);

			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(Login login) {

		ResponseEntity<String> entity = null;

		try {
			User searchUser = service.login(login); // 입력한 아이디가 존재하는지 확인

			if (searchUser != null && passwordEncoder.matches(login.getUserPw(), searchUser.getUserPw())) { // 아이디, 비밀번호 모두 일치
				service.loginConnect(searchUser); // 로그인 테이블에 로그인 상태, 계정 상태 update(일반회원)
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
			} else if (searchUser == null) { // 아이디 불일치
				entity = new ResponseEntity<String>("idFail", HttpStatus.OK);
			} else if (!passwordEncoder.matches(login.getUserPw(), searchUser.getUserPw())) { // 비밀번호 불일치
				entity = new ResponseEntity<String>("pwFail", HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST); // HttpStatus.BAD_REQUEST == 400
		}
		
		return entity;
	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<String> logout(Login login) {

		ResponseEntity<String> entity = null;
		System.out.println(login);
		try {
			service.logout(login); // 로그인 테이블에 로그아웃 상태 update
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	// 회원수정
	@RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
	public ResponseEntity<String> userUpdate(String email, String nowPw, String newPw, String newNickname) {

		ResponseEntity<String> entity = null;
		
		try {
			Login login = new Login();
			login.setUserId(email); // 현재 로그온 상태의 아이디
			
			User searchUser = service.login(login); // 현재 로그인한 아이디의 유저 정보를 가져옴(id,pw) 없다면 null

			if (searchUser != null && passwordEncoder.matches(nowPw, searchUser.getUserPw())) { // 비밀번호 일치
				if (newPw == null) { // 닉네임만 변경
					searchUser.setUserNickname(newNickname); // 현재 입력되어 있는 닉네임
					service.update(searchUser);
				} else if (newNickname == null) { // 비밀번호만 변경
					service.update(searchUser);
				} else { // 닉네임, 비밀번호 변경
					searchUser.setUserNickname(newNickname); // 현재 입력되어 있는 닉네임
					searchUser.setUserPw(passwordEncoder.encode(newPw)); // 변경할 비밀번호
					service.update(searchUser);
				}
				
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
				
			} else { // 비밀번호 불일치
				entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	// 마이페이지 화면 요청
	@RequestMapping(value = "/mypageAuth", method = RequestMethod.POST)
	public ResponseEntity<String> mypageAuth(String userId) {

		ResponseEntity<String> entity = null;
		int loginConnectCode = 0;
		
		try {
			loginConnectCode = service.mypageAuth(userId);

			if (loginConnectCode == 1) { // 일반계정
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
			} else if (loginConnectCode == 2) { // 페이스북 계정
				entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	// 회원탈퇴
	@RequestMapping(value = "/userDelete", method = RequestMethod.POST)
	public ResponseEntity<String> deleteUser(User user) {

		ResponseEntity<String> entity = null;
		
		try {
			Login login = new Login();
			login.setUserId(user.getUserId()); // 현재 로그온 상태의 아이디
			User searchUser = service.login(login); // 현재 로그인한 아이디의 유저 정보를 가져옴(id,pw) 없다면 null
			// 검색한 유저 정보가 존재 AND 검색한 유저의 비밀번호와 입력한 비밀번호가 일치하는지
			
			if (searchUser != null && passwordEncoder.matches(user.getUserPw(), searchUser.getUserPw())) { // 비밀번호 일치
				service.delete(searchUser); // id와 입력한 비밀번호가 일치하는 컬럼을 삭제(회원탈퇴)
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
			} else { // 비밀번호 불일치
				entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	// 닉네임 가져오기
	@RequestMapping(value = "/getNickname", method = RequestMethod.POST)
	public ResponseEntity<User> getNickname(String userId) {

		ResponseEntity<User> entity = null;
		User user = new User();
		
		try {
			user = service.getNickname(userId);
			entity = new ResponseEntity<User>(user, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	@RequestMapping(value = "/state", method = RequestMethod.GET)
	public String requestNaverLoginState(HttpSession session) {

		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString(32); // 토큰을 생성합니다.
		session.setAttribute("state", state); // 세션에 토큰을 저장합니다.

		return state;
	}

	// 페이스북 로그인
	@RequestMapping(value = "/externalLogin", method = RequestMethod.POST)
	public ResponseEntity<String> externalLogin(@RequestBody User user) {

		ResponseEntity<String> entity = null;
		User fbUser = user;

		try {
			fbUser = service.externalLogin(user); // 페이스북 계정이 이미 존재하는 회원인지 확인 (신규회원이라면 null)

			if (fbUser == null) { // 신규 회원이면 DB에 회원 정보 저장
				service.create(user);
				service.loginConnectF(user); // 로그인 테이블에 로그인 상태, 계정 상태 update(페이스북)
			} else {
				service.loginConnectF(user); // 로그인 테이블에 로그인 상태, 계정 상태 update(페이스북)
			}
			
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

}