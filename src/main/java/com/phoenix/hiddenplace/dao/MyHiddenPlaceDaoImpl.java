package com.phoenix.hiddenplace.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.phoenix.hiddenplace.domain.MyHiddenPlace;

@Repository
public class MyHiddenPlaceDaoImpl implements MyHiddenPlaceDao {

	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.phoenix.hiddenplace.mapper.Mapper";
	
	@Override
	public void insert(MyHiddenPlace myHiddenPlace) throws Exception {
		sqlSession.insert(namespace + ".insert", myHiddenPlace);
	}

	@Override
	public MyHiddenPlace selectOne(Integer num) throws Exception {
		return sqlSession.selectOne(namespace + ".selectOne", num);
	}
}
