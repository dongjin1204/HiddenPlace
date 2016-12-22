package com.phoenix.hiddenplace.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.hiddenplace.domain.Qna;
import com.phoenix.hiddenplace.service.QnaService;

@RestController
@RequestMapping(value = "/qna/*")
public class QnaControllerRest {

	@Inject
	private QnaService service;

	//qna 등록
	@RequestMapping(value = "/insertQNA", method = RequestMethod.POST)
	public ResponseEntity<String> insertQna(Qna qna) {

		ResponseEntity<String> entity = null;

		try {
			service.insertQNA(qna);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	//qna 목록
	@RequestMapping(value = "/selectAllQNA", method = RequestMethod.GET)
	public ResponseEntity<List<Qna>> SelectAllQna(Qna qna) throws Exception {

		ResponseEntity<List<Qna>> entity = null;

		try {
			entity = new ResponseEntity<List<Qna>>(service.listQNA(qna), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<Qna>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	//qna 조회
	@RequestMapping(value = "/selectOneQNA", method = RequestMethod.GET)
	public ResponseEntity<Qna> selectOneQna(int num) {
		
		ResponseEntity<Qna> entity = null;

		try {
			entity = new ResponseEntity<Qna>(service.selectOneQNA(num), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Qna>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	//qna 삭제
	@RequestMapping(value = "/deleteQNA", method = RequestMethod.GET)
	public ResponseEntity<String> deleteQNA(int num) {

		ResponseEntity<String> entity = null;
		
		try {
			service.deleteQNA(num);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	//qna 수정 
	@RequestMapping(value = "/updateQNA", method = RequestMethod.POST)
	public ResponseEntity<String> updateQNA(Qna qna) {
		
		ResponseEntity<String> entity = null;
		
		try {
			service.updateQNA(qna);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}