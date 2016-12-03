package com.phoenix.hiddenplace.controller;

import javax.inject.Inject;

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
@RequestMapping("/myhiddenplace/*")
public class MyHiddenPlaceController {

	private static final Logger logger = LoggerFactory.getLogger(MyHiddenPlaceController.class);

	@Inject
	private MyHiddenPlaceService service;

	//request 내알못 목록 컨트롤러
	@RequestMapping(value ="/myHiddenPlaceSelectAll", method = RequestMethod.GET)
	public String selectAllMHP(MyHiddenPlace myHiddenPlace, RedirectAttributes rttr) throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceSelectAll";

	}
	
//	//request insert 컨트롤러 get 메서드
//	@RequestMapping(value ="/insert", method = RequestMethod.GET)
//	public void insertGET(MyHiddenPlace myHiddenPlace, Model model) throws Exception {
//
//		logger.info("insert get ............");
//
//	}
//
//
//	//request insert 컨트롤러 post 메서드
//	@RequestMapping(value ="/insert", method = RequestMethod.POST)
//	public String insertPOST(MyHiddenPlace myHiddenPlace, RedirectAttributes rttr) throws Exception {
//
//		logger.info("insert post ............");
//		logger.info(myHiddenPlace.toString());
//
//		service.insert(myHiddenPlace);
//
//		//		model.addAttribute("result", "success");
//		rttr.addFlashAttribute("msg", "SUCCESS");
//
//		//		return "/board/success";
//		return "/views/myhiddenplace/hiddenPlaceSelectAll";
//
//	}
	
}
