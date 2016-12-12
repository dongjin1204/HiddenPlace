package com.phoenix.hiddenplace.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/myroute")
public class MyRouteControllerRest {
/* 나중에 만들겠음
	@Inject
	private MyRouteService service;

	//나만의루트 베스트 3
	@RequestMapping(value = "/bestMR", method = RequestMethod.GET)
	public ResponseEntity<List<MyRoute>> bestMHP() throws Exception {
		
		ResponseEntity<List<MyRoute>> entity = null;
		
		try {
			
			entity = new ResponseEntity<List<MyRoute>>(service.bestMR(), HttpStatus.OK);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("MR best3 목록보기에서 오류");
			entity = new ResponseEntity<List<MyRoute>>(HttpStatus.BAD_REQUEST);
			
		}
		
		return entity;
	}	*/
	
}   