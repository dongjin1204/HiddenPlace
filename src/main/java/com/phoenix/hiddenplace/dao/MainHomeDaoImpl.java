package com.phoenix.hiddenplace.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.phoenix.hiddenplace.domain.MyHiddenPlace;

@Repository
public class MainHomeDaoImpl implements MainHomeDao {

	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.phoenix.hiddenplace.mapper.MainHomeMapper";

	@Override
	public String selectSearch(String search) throws Exception {
		
		System.out.println(search);
		return sqlSession.selectOne(namespace + ".search", search);
	}

}



	


	

