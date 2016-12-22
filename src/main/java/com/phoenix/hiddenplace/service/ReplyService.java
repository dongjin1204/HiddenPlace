package com.phoenix.hiddenplace.service;

import java.util.List;
import com.phoenix.hiddenplace.domain.Reply;
import com.phoenix.hiddenplace.domain.ReplyPageMaker;

public interface ReplyService {
	public void insert(Reply reply)throws Exception;

	List<Reply> listMHP(ReplyPageMaker replyPage) throws Exception; 
	
	public int listCount(ReplyPageMaker replyPage) throws Exception;
	
	List<Reply> listMR(int myRouteNum) throws Exception;
	
	public void modifyReply(Reply reply) throws Exception;
	
	public void romeveReply(Reply reply) throws Exception;
}
