package com.phoenix.hiddenplace.dao;

import java.util.List;

import com.phoenix.hiddenplace.domain.Reply;
import com.phoenix.hiddenplace.domain.ReplyPageMaker;

public interface ReplyDao {
    public List<Reply> selectAllMHP(ReplyPageMaker replyPage) throws Exception;
   
    public int listCount(ReplyPageMaker replyPage);
	
    public List<Reply> selectAllMR(int myRouteNum) throws Exception;
	
	public void insert(Reply reply) throws Exception;
	
	public void update(Reply reply) throws Exception;
	
	public void delete(Reply reply) throws Exception;
}



	
	
	
	
	

