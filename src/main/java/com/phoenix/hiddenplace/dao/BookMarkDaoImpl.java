package com.phoenix.hiddenplace.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.phoenix.hiddenplace.domain.Bookmark;
import com.phoenix.hiddenplace.domain.BookmarkPageMaker;
import com.phoenix.hiddenplace.domain.MyHiddenPlace;

@Repository
public class BookmarkDaoImpl implements BookmarkDao {

	@Inject	
	private SqlSession sqlSession;

	private static String namespace = "com.phoenix.hiddenplace.mapper.bookmarkMapper";

	@Override
	public void bookmarkDelete(String nums) throws Exception {

		sqlSession.delete(namespace + ".bookmarkDelete", nums);
	}
	
	//즐겨찾기 등록(홈페이지)
	@Override
	public void bookmarkInsertMHP(MyHiddenPlace myHiddenPlace) throws Exception {
		
		sqlSession.insert(namespace + ".bookmarkInsertMHP", myHiddenPlace);
	}
	
	//즐겨찾기 해제(홈페이지)
	@Override
	public void bookmarkDeleteMHP(MyHiddenPlace myHiddenPlace) throws Exception {
		
		sqlSession.delete(namespace + ".bookmarkDeleteMHP", myHiddenPlace);
	}
	
	@Override
	public List<Bookmark> bookmarkMHPAll(BookmarkPageMaker pageMaker) throws Exception {
		
		int page = pageMaker.getPage();
		
		if(page <= 0) {
			page = 1;
		}
		
		page = (page - 1) * 6;
		pageMaker.setPage(page);
		return sqlSession.selectList(namespace + ".bookmarkMHPAll", pageMaker);
	}

	@Override
	public List<Bookmark> bookmarkMRAll(String userId) throws Exception {

		return sqlSession.selectList(namespace + ".bookmarkMRAll", userId);
	}

	@Override
	public int listCount(BookmarkPageMaker pageMaker) {
		
		return sqlSession.selectOne(namespace + ".listCount", pageMaker);
	}

}