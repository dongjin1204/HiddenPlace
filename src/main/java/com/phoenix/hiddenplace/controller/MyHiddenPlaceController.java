package com.phoenix.hiddenplace.controller;

import javax.inject.Inject;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.phoenix.hiddenplace.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class MyHiddenPlaceController {

	@Inject
	private UserService service;

	@RequestMapping(value = "/userInsertView", method = RequestMethod.GET)
	public String insertGET() throws Exception {
		System.out.println("회원가입 컨트롤러 도착");

		return "/views/user/userInsertView";
	}

	// 회원탈퇴
	@RequestMapping(value = "/deleteUser")
	public void test1(@RequestParam("userPw") String userPw) {
		System.out.println("deleteUser 파일 호출");
		System.out.println(userPw);
		try {
			// service.delete(userPw);
		} catch (Exception e) {
			e.printStackTrace();
		}
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phoenix.hiddenplace.domain.MyHiddenPlace;
import com.phoenix.hiddenplace.service.MyHiddenPlaceService;

@Controller
@RequestMapping("/hiddenplace/*")
public class MyHiddenPlaceController {

	private static final Logger logger = LoggerFactory.getLogger(MyHiddenPlaceController.class);

	@Inject
	private MyHiddenPlaceService service;

	//request insert 컨트롤러 get 메서드
	@RequestMapping(value ="/insert", method = RequestMethod.GET)
	public void insertGET(MyHiddenPlace myHiddenPlace, Model model) throws Exception {

		logger.info("insert get ............");

	}


	//request insert 컨트롤러 post 메서드
	@RequestMapping(value ="/insert", method = RequestMethod.POST)
	public String insertPOST(MyHiddenPlace myHiddenPlace, RedirectAttributes rttr) throws Exception {

		logger.info("insert post ............");
		logger.info(myHiddenPlace.toString());

		service.insert(myHiddenPlace);

		//		model.addAttribute("result", "success");
		rttr.addFlashAttribute("msg", "SUCCESS");

		//		return "/board/success";
		return "redirect:/hiddenplace/hiddenPlaceSelectAll";

>>>>>>> refs/remotes/dongjin1204/master
	}

}
