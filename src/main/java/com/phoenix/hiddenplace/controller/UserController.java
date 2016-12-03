package com.phoenix.hiddenplace.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.hiddenplace.domain.User;
import com.phoenix.hiddenplace.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Inject
	private UserService service;

	// 회원가입
	@RequestMapping(value = "/userInsertView", method = RequestMethod.POST)
	public ResponseEntity<String> insert(User user) {

		System.out.println("회원가입 컨트롤러RESTFUL");
		System.out.println(user.toString());
		ResponseEntity<String> entity = null;

		try {
			service.create(user);
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

		System.out.println("닉네임 중복확인 컨트롤러RESTFUL");
		ResponseEntity<String> entity = null;
		String checkNickname = null;
		try {
			checkNickname = service.nicknameCheck(nickname); // 사용가능한 닉네임,
																// 불가능하다면 null
			System.out.println(checkNickname);
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

	// 회원탈퇴
	@RequestMapping(value = "/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam("userPw") String userPw) {

		System.out.println("deleteUser 파일 호출");
		ResponseEntity<String> entity = null;

		try {
			service.delete(userPw);

			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//로그인 logic 처리 필요함
	@RequestMapping(value="/login") //session에서 아이디 가져옴, 패스워드 처리하기 
	   public User login(User user) throws Exception{
	      
	      System.out.println(user.getUserId());
	      System.out.println(user.getUserPw());
	      User user1 = service.login(user); //로직 처리 : 패스워드 일치      
	      
	      System.out.println(user1.getUserId());
	      System.out.println(user1.getUserPw());
	      return user1;
	}
	
}
