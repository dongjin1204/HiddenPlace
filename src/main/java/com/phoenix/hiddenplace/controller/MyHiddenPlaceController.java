package com.phoenix.hiddenplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/myhiddenplace/*")
public class MyHiddenPlaceController {

	//request 내알못 목록 컨트롤러
	@RequestMapping(value ="/myHiddenPlaceSelectAll", method = RequestMethod.GET)
	public String selectAllMHP() throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceSelectAll";
	}
	
	//request 내알못 목록 컨트롤러
	@RequestMapping(value ="/selectAllKeyWordUrl/{keyWord}", method = RequestMethod.GET)
	public String selectAllKeyWordUrl() throws Exception {
		
		return "/views/myhiddenplace/myHiddenPlaceSelectAll";
	}

	//내알못 글쓰기 컨트롤러
	@RequestMapping(value ="/myHiddenPlaceInsert", method = RequestMethod.GET)
	public String inertMHP() throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceInsert";
	}

	//request 내알못 조회 컨트롤러
	@RequestMapping(value ="/myHiddenPlaceSelectOne", method = RequestMethod.GET)
	public String selectOneMHP() throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceSelectOne";
	}   
	
	//조회에 숫자 보내기
	@RequestMapping(value = "/myHiddenPlaceSelectOne/{num}")
	public String forgetPwUpdateGET() throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceSelectOne";
	} 
	
	//조회에 숫자 보내기
	@RequestMapping(value = "/myHiddenPlaceUpdate/{num}")
	public String updateMHP() throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceUpdate";
	} 
	
}