package com.phoenix.hiddenplace.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.phoenix.hiddenplace.dao.ReplyDao;
import com.phoenix.hiddenplace.domain.Reply;
import com.phoenix.hiddenplace.domain.ReplyPageMaker;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDao dao;

	@Override
	public void insert(Reply reply) throws Exception {

		dao.insert(reply);
	}

	@Override
	public List<Reply> listMHP(ReplyPageMaker replyPage) throws Exception {

		return dao.selectAllMHP(replyPage);
	}

	@Override
	public int listCount(ReplyPageMaker replyPage) throws Exception {
		
		return dao.listCount(replyPage);
	}

	@Override
	public List<Reply> listMR(int myRouteNum) throws Exception {
		
		return dao.selectAllMR(myRouteNum);
	}

	@Override
	public void modifyReply(Reply reply) throws Exception {
		
		dao.update(reply);
	}

	@Override
	public void romeveReply(Reply reply) throws Exception {
		
		dao.delete(reply);
	}

}