package com.phoenix.hiddenplace.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.phoenix.hiddenplace.domain.MyHiddenPlace;

@Repository
public class MyHiddenPlaceDaoImpl implements MyHiddenPlaceDao {

	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.phoenix.hiddenplace.mapper.MyHiddenPlaceMapper";
	
	@Override
	public void insert(MyHiddenPlace myHiddenPlace) throws Exception {
		sqlSession.insert(namespace + ".insert", myHiddenPlace);
	}

	@Override
	public MyHiddenPlace selectOne(Integer num) throws Exception {
		return sqlSession.selectOne(namespace + ".selectOne", num);
	}
	
	@Override
	public List<MyHiddenPlace> list(String strPage) throws Exception {
		int page = Integer.parseInt(strPage);
		if(page <= 0) {
			page = 1;
		}
		
		page = (page - 1) * 10;
		
		return sqlSession.selectList(namespace + ".list" , page);
	}

	@Override
	public int listCount(String page) {
		
		return sqlSession.selectOne(namespace + ".listCount", page);
	}

	@Override
	public List<MyHiddenPlace> bestMHP() throws Exception {
		return sqlSession.selectList(namespace + ".bestMHP");
	}
	
}
