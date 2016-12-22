package com.phoenix.hiddenplace.dao;

import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.phoenix.hiddenplace.domain.Qna;

@Repository
public class QnaDaoImpl implements QnaDao {

	@Inject
	private SqlSession sqlSession;

	private static String namespace = "com.phoenix.hiddenplace.mapper.qnaMapper";

	@Override
	public void insertQNA(Qna qna) throws Exception {

		sqlSession.insert(namespace + ".insertQNA", qna);
	}

	@Override
	public List<Qna> selectAllQNA(Qna qna) throws Exception {

		return sqlSession.selectList(namespace + ".listQNA", qna);
	}

	@Override
	public Qna selectOneQNA(int num) throws Exception {

		return sqlSession.selectOne(namespace + ".selectOneQNA", num);
	}

	@Override
	public void deleteQNA(int num) throws Exception {

		sqlSession.delete(namespace + ".deleteQNA", num);
	}

	@Override
	public void updateQNA(Qna qna) throws Exception {
		
		sqlSession.update(namespace + ".updateQNA", qna);
	}

}