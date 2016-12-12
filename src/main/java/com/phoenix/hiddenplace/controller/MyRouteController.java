//1
package com.phoenix.hiddenplace.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phoenix.hiddenplace.service.MyHiddenPlaceService;

@Controller
@RequestMapping("/myroute/*")
public class MyRouteController {

	private static final Logger logger = LoggerFactory.getLogger(MyRouteController.class);

	@Inject
	private MyHiddenPlaceService service;

	//나만의 루트 조회 메서드
	@RequestMapping(value="/myRouteSelectOne")
	   public String myRouteSelectOne() {
		   
	      return "/views/myroute/myRouteSelectOne";
	   }

}
