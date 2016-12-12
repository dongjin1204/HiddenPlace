package com.phoenix.hiddenplace.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.hiddenplace.domain.MyHiddenPlace;
import com.phoenix.hiddenplace.domain.PageMaker;
import com.phoenix.hiddenplace.service.MyHiddenPlaceService;

@RestController
@RequestMapping(value = "/myhiddenplace")
public class MyhiddenPlaceControllerRest {

	@Inject
	private MyHiddenPlaceService service;

	//페이지 전환
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<PageMaker> listPage(PageMaker pageMaker) throws Exception {
		
		ResponseEntity<PageMaker> entity = null;
		
		try {
			
			pageMaker.setTotalCount(service.listCount(pageMaker));
			System.out.println(pageMaker.getEndPage());
			entity = new ResponseEntity<PageMaker>(pageMaker, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<PageMaker>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}	
	
	//내알못 목록
	@RequestMapping(value = "/myhiddenplaceSelectAll", method = RequestMethod.GET)
	public ResponseEntity<List<MyHiddenPlace>> hiddenplaceSelectAll(PageMaker pageMaker) throws Exception {
		
		ResponseEntity<List<MyHiddenPlace>> entity = null;
		
		try {
			entity = new ResponseEntity<List<MyHiddenPlace>>(service.list(pageMaker), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("목록보기에서 오류");
			entity = new ResponseEntity<List<MyHiddenPlace>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}	
	
	
	//내알못 베스트 3
	@RequestMapping(value = "/bestMHP", method = RequestMethod.GET)
	public ResponseEntity<List<MyHiddenPlace>> bestMHP(MyHiddenPlace myHiddenPlace) throws Exception {
		
		ResponseEntity<List<MyHiddenPlace>> entity = null;
		
		String userId = myHiddenPlace.getUserId();
		
		try {
			
			entity = new ResponseEntity<List<MyHiddenPlace>>(service.bestMHP(userId), HttpStatus.OK);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("best3 목록보기에서 오류");
			entity = new ResponseEntity<List<MyHiddenPlace>>(HttpStatus.BAD_REQUEST);
			
		}
		
		return entity;
	}	
	
	
	// 내알못 등록 
	   @RequestMapping(value = "/insertMHP", method = RequestMethod.POST)
	   public ResponseEntity<String> insert(MyHiddenPlace myHiddenPlace) {
		   
	      ResponseEntity<String> entity = null;

	      try {
	    	  service.insert(myHiddenPlace);
	         entity = new ResponseEntity<String>("success", HttpStatus.OK);
	      } catch (Exception e) {
	         e.printStackTrace();
	         entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	      }

	      return entity;
	   }
	   
	   
	   // 내알못 조회
	   @RequestMapping(value = "/selectOneMHP", method = RequestMethod.GET)
	   public ResponseEntity<MyHiddenPlace> selectOne(int num) {
		   
	      ResponseEntity<MyHiddenPlace> entity = null;
	      
	      try {
	    	  
	         entity = new ResponseEntity<MyHiddenPlace>(service.selectOne(num), HttpStatus.OK);
	      } catch (Exception e) {
	         e.printStackTrace();
	         entity = new ResponseEntity<MyHiddenPlace>(HttpStatus.BAD_REQUEST);
	      }

	      return entity;
	   }
	   
	 //즐겨찾기 현재 로그인한 유저의 즐겨찾기 목록
		@RequestMapping(value = "/bookmarkAll", method = RequestMethod.GET)
		public ResponseEntity<List<MyHiddenPlace>> bookmarkAll(MyHiddenPlace myHiddenPlace) throws Exception {
			
			ResponseEntity<List<MyHiddenPlace>> entity = null;
			
			String userId = myHiddenPlace.getUserId();
			
			try {
				
				entity = new ResponseEntity<List<MyHiddenPlace>>(service.bookmarkAll(userId), HttpStatus.OK);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				System.out.println("즐겨찾기(홈페이지) 목록보기에서 오류");
				entity = new ResponseEntity<List<MyHiddenPlace>>(HttpStatus.BAD_REQUEST);
				
			}
			
			return entity;
		}
		
		// 내알못 베스트 업데이트
		@RequestMapping(value = "/bestUpdateMHP", method = RequestMethod.GET)
		public ResponseEntity<String> bestUpdateMHP() throws Exception {
			
			ResponseEntity<String> entity = null;		
			
			try {
				service.bestUpdateMHP();
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("목록보기에서 오류");
				entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
			return entity;
		}
	   
	}   


