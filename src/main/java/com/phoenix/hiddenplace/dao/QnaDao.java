package com.phoenix.hiddenplace.dao;

import java.util.List;
import com.phoenix.hiddenplace.domain.Qna;

public interface QnaDao {
	public void insertQNA(Qna qna)throws Exception;

	public List<Qna> selectAllQNA(Qna qna) throws Exception;

	public Qna selectOneQNA(int num)throws Exception;

	public void deleteQNA(int num) throws Exception;

	public void updateQNA(Qna qna)throws Exception;
}