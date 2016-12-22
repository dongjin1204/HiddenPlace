package com.phoenix.hiddenplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phoenix.hiddenplace.domain.Qna;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	//QNA 글쓰기 컨트롤러
	@RequestMapping(value ="/qnaInsert", method = RequestMethod.GET)
	public String insertQNA(Qna qna, RedirectAttributes rttr) throws Exception {

		return "/views/qna/qnaInsert";
	}

	//request QNA 목록 컨트롤러
	@RequestMapping(value ="/qnaSelectAll", method = RequestMethod.GET)
	public String selectAllQNA(Qna qna, RedirectAttributes rttr) throws Exception {

		return "/views/qna/qnaSelectAll";
	}

	//request QNA 조회 컨트롤러
	@RequestMapping(value ="/qnaSelectOne", method = RequestMethod.GET)
	public String selectOneQNA() throws Exception {

		return "/views/qna/qnaSelectOne";
	}

	//request QNA 수정 컨트롤러
	@RequestMapping(value ="/qnaUpdate", method = RequestMethod.GET)
	public String updateQNA() throws Exception {

		return "/views/qna/qnaUpdate";
	}

}