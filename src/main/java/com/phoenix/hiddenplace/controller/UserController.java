package com.phoenix.hiddenplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	//회원가입 페이지 요청
	@RequestMapping(value = "/userInsertView")
	public String userInsert() throws Exception {
		
		return "/views/user/userInsertView";
	}

	//로그인 페이지 요청
	@RequestMapping(value = "/loginView")
	public String userLogin() throws Exception {
		
		return "/views/user/loginView";
	}

	//비밀번호 찾기 페이지 요청
	@RequestMapping(value = "/forgetPwView")
	public String forgetPw() throws Exception {

		return "/views/user/forgetPwView";
	}

	//비밀번호 찾기(변경) 페이지 요청 + 이메일 파라미터에 담아오기
	@RequestMapping(value = "/forgetPwUpdateView/{email}")
	public String forgetPwUpdateGET() throws Exception {

		return "/views/user/forgetPwUpdateView";
	}

	//마이페이지(회원정보관리) 페이지 요청
	@RequestMapping(value = "/mypageView")
	public String mypage() throws Exception {

		return "/views/user/mypageView";
	}

}