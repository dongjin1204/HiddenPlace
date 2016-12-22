package com.phoenix.hiddenplace.service;

import java.util.List;
import com.phoenix.hiddenplace.domain.Qna;

public interface QnaService {
	public void insertQNA(Qna qna)throws Exception;
	
	List<Qna> listQNA(Qna qna) throws Exception; 
	
	public Qna selectOneQNA(int num) throws Exception;
	
	public void deleteQNA(int num) throws Exception;
	
	public void updateQNA(Qna qna)throws Exception;
}
