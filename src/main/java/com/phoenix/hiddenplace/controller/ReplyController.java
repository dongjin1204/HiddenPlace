package com.phoenix.hiddenplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.phoenix.hiddenplace.domain.Reply;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	//내알못 댓글 목록 컨트롤러
	@RequestMapping(value ="/replySelectAllMHP", method = RequestMethod.GET)
	public String selectAllMHP(Reply reply, RedirectAttributes rttr) throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceSelectOne";
	}

	//나만의 루트 댓글 목록 컨트롤러
	@RequestMapping(value ="/replySelectAllMR", method = RequestMethod.GET)
	public String selectAllMR(Reply reply, RedirectAttributes rttr) throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceSelectOne";
	}

	//내알못 댓글쓰기 컨트롤러
	@RequestMapping(value ="/replyInsert", method = RequestMethod.GET)
	public String replyInsert(Reply reply, RedirectAttributes rttr) throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceSelectOne";
	}

	//내알못 댓글수정 컨트롤러
	@RequestMapping(value ="/replyUpdate", method = RequestMethod.GET)
	public String replyUpdate(Reply reply, RedirectAttributes rttr) throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceSelectOne";
	}

}