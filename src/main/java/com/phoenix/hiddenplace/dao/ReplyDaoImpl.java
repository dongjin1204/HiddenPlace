package com.phoenix.hiddenplace.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.phoenix.hiddenplace.domain.Reply;
import com.phoenix.hiddenplace.domain.ReplyPageMaker;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	@Inject
	private SqlSession sqlSession;

	private static String namespace = "com.phoenix.hiddenplace.mapper.replyMapper";

	@Override
	public List<Reply> selectAllMHP(ReplyPageMaker replyPage) throws Exception {
		
		int page = replyPage.getPage();
		if(page <= 0) {
			page = 1;
		}

		page = (page - 1) * 10;
		replyPage.setPage(page);
		return sqlSession.selectList(namespace + ".listMHP", replyPage);
	}

	@Override
	public int listCount(ReplyPageMaker replyPage) {
		
		return sqlSession.selectOne(namespace + ".listCount", replyPage);
	}

	@Override
	public List<Reply> selectAllMR(int myRouteNum) throws Exception {

		return sqlSession.selectList(namespace + ".listMR", myRouteNum);
	}

	@Override
	public void insert(Reply reply) throws Exception {

		sqlSession.insert(namespace + ".insert", reply);
	}

	@Override
	public void update(Reply reply) throws Exception {

		sqlSession.update(namespace + ".update", reply);	
	}

	@Override
	public void delete(Reply reply) throws Exception {

		sqlSession.delete(namespace + ".delete", reply);
	}

}