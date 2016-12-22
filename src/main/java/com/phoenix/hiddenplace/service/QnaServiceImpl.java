package com.phoenix.hiddenplace.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.phoenix.hiddenplace.dao.QnaDao;
import com.phoenix.hiddenplace.domain.Qna;

@Service
public class QnaServiceImpl implements QnaService {

	@Inject
	private QnaDao dao;

	@Override
	public void insertQNA(Qna qna) throws Exception {
		
		dao.insertQNA(qna);
	}

	@Override
	public List<Qna> listQNA(Qna qna) throws Exception {

		return dao.selectAllQNA(qna);
	}

	@Override
	public Qna selectOneQNA(int num) throws Exception {

		return dao.selectOneQNA(num);
	}

	@Override
	public void deleteQNA(int num) throws Exception {
		
		dao.deleteQNA(num);
	}

	@Override
	public void updateQNA(Qna qna) throws Exception {
		
		dao.updateQNA(qna);
	}

}