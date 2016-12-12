package com.phoenix.hiddenplace.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BookMarkDaoImpl implements BookMarkDao {

	@Inject	
	private SqlSession session;

	private static String namespace = "com.phoenix.hiddenplace.mapper.BookMarkMapper";


	@Override
	public void bookMarkDelete(String nums) throws Exception {
		System.out.println("Dao출력");
		session.delete(namespace + ".bookMarkDelete", nums);

		
	}

}
