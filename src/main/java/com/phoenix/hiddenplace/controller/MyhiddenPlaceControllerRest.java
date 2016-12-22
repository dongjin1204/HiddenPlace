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
import com.phoenix.hiddenplace.domain.Theme;
import com.phoenix.hiddenplace.service.MyHiddenPlaceService;

@RestController
@RequestMapping(value = "/myhiddenplace")
public class MyhiddenPlaceControllerRest {

	@Inject
	private MyHiddenPlaceService service;

	//내알못 페이지 전환
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<PageMaker> listPage(PageMaker pageMaker) throws Exception {

		ResponseEntity<PageMaker> entity = null;

		try {
			pageMaker.setTotalCount(service.listCount(pageMaker));
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
			entity = new ResponseEntity<List<MyHiddenPlace>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	//테마 목록
	@RequestMapping(value = "/themeList", method = RequestMethod.GET)
	public ResponseEntity<List<Theme>> themeList() throws Exception {

		ResponseEntity<List<Theme>> entity = null;

		try {
			service.themeList();
			entity = new ResponseEntity<List<Theme>>(service.themeList(), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<Theme>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	//내알못 베스트 3
	@RequestMapping(value = "/bestMHP", method = RequestMethod.GET)
	public ResponseEntity<List<MyHiddenPlace>> bestMHP() throws Exception {

		ResponseEntity<List<MyHiddenPlace>> entity = null;

		try {
			entity = new ResponseEntity<List<MyHiddenPlace>>(service.bestMHP(), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<MyHiddenPlace>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	
	//내알못 등록
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

	
	//내알못 조회
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
			entity = new ResponseEntity<List<MyHiddenPlace>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	
	//추천코드 뽑아오기
	@RequestMapping(value = "/upCountCheck", method = RequestMethod.GET)
	public ResponseEntity<Integer> upCountCheck(MyHiddenPlace myHiddenPlace) throws Exception {

		ResponseEntity<Integer> entity = null;
		
		try {
			entity = new ResponseEntity<Integer>(service.upCountCheck(myHiddenPlace), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	
	//추천수 증가 저장하기
	@RequestMapping(value = "/upCount", method = RequestMethod.GET)
	public ResponseEntity<String> upcount(MyHiddenPlace myHiddenPlace) throws Exception {
		
		ResponseEntity<String> entity = null;
		
		try {
			service.upCount(myHiddenPlace);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	//내알못 수정 
    @RequestMapping(value = "/updateMHP", method = RequestMethod.POST)
    public ResponseEntity<String> update(MyHiddenPlace myHiddenPlace) {
      
       ResponseEntity<String> entity = null;

       try {
          service.updateMHP(myHiddenPlace);
          entity = new ResponseEntity<String>("success", HttpStatus.OK);
          
       } catch (Exception e) {
          e.printStackTrace();
          entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
       }

       return entity;
    }
    
	//내알못 삭제
	@RequestMapping(value = "/deleteMHP", method = RequestMethod.GET)
	public ResponseEntity<String> deleteMHP(int num) {

		ResponseEntity<String> entity = null;
		
		try {
				service.delete(num);
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
				
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	//내알못 베스트 업데이트
	   @RequestMapping(value = "/updateBestMHP", method = RequestMethod.GET)
	   public ResponseEntity<String> updateBestMHP() throws Exception {

	      ResponseEntity<String> entity = null;
	      
	      try {
	         service.updateBestMHP();
	         entity = new ResponseEntity<String>("success", HttpStatus.OK);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	      }

	      return entity;
	   }
    
}