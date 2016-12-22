package com.phoenix.hiddenplace.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.hiddenplace.domain.Reply;
import com.phoenix.hiddenplace.domain.ReplyPageMaker;
import com.phoenix.hiddenplace.service.ReplyService;

@RestController
@RequestMapping(value = "/reply/*")
public class ReplyControllerRest {

	@Inject
	private ReplyService service;

	//내알못 댓글 등록 
	@RequestMapping(value = "/insertReplyMHP", method = RequestMethod.POST)
	public ResponseEntity<String> insert(Reply reply) {

		ResponseEntity<String> entity = null;

		try {
			service.insert(reply);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	//내알못 댓글 목록
	@RequestMapping(value = "/selectAllReplyMHP", method = RequestMethod.GET)
	public ResponseEntity<List<Reply>> hiddenplaceSelectAll(ReplyPageMaker replyPage) throws Exception {

		ResponseEntity<List<Reply>> entity = null;

		try {
			entity = new ResponseEntity<List<Reply>>(service.listMHP(replyPage), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<Reply>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}   

	//댓글 페이지 목록
	@RequestMapping(value = "/replyPage", method = RequestMethod.GET)
	public ResponseEntity<ReplyPageMaker> selectOneReplyPage(ReplyPageMaker replyPage) throws Exception {

		ResponseEntity<ReplyPageMaker> entity = null;

		try {
			replyPage.setTotalCount(service.listCount(replyPage));
			entity = new ResponseEntity<ReplyPageMaker>(replyPage, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<ReplyPageMaker>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}   

	//댓글 삭제
	@RequestMapping(value = "/deleteReplyMHP", method = RequestMethod.POST)
	public ResponseEntity<String> deleteReply(Reply reply) {

		ResponseEntity<String> entity = null;
		
		try {
			service.romeveReply(reply);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}


	//댓글 수정
	@RequestMapping(value = "/updateReplyMHP", method = RequestMethod.POST)
	public ResponseEntity<String> updateReply(Reply reply) throws Exception {

		ResponseEntity<String> entity = null;
		
		try {
			service.modifyReply(reply);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

}