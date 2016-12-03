package com.phoenix.hiddenplace.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.phoenix.hiddenplace.service.MainHomeService;

@Controller
public class MainHomeController {

	@Inject
	private MainHomeService service;
	
	//검색 메서드
	@RequestMapping(value ="/search", method = RequestMethod.GET)
	public void search(@RequestParam("search") String search) throws Exception {
		
		System.out.println("컨트롤러");
		service.search(search);
		
	}



}
