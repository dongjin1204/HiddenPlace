package com.phoenix.hiddenplace.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.hiddenplace.domain.User;
import com.phoenix.hiddenplace.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class MyhiddenPlaceControllerRest {

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
			checkNickname = service.nicknameCheck(nickname); // 사용가능한 닉네임, 불가능하다면 null
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

}
