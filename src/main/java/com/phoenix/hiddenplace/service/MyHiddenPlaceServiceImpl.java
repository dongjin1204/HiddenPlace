package com.phoenix.hiddenplace.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.phoenix.hiddenplace.dao.MyHiddenPlaceDao;
import com.phoenix.hiddenplace.domain.MyHiddenPlace;
import com.phoenix.hiddenplace.domain.PageMaker;

@Service
public class MyHiddenPlaceServiceImpl implements MyHiddenPlaceService {

	@Inject
	private MyHiddenPlaceDao dao;

	@Override
	public void insert(MyHiddenPlace myHiddenPlace) throws Exception {
		dao.insert(myHiddenPlace);		
	}
	@Override
	public List<MyHiddenPlace> list(PageMaker pageMaker) throws Exception {

		return dao.list(pageMaker); 
	}

	@Override
	public int listCount(PageMaker pageMaker) throws Exception {

		return dao.listCount(pageMaker);
	}

	@Override
	public List<MyHiddenPlace> bestMHP(String userId) throws Exception {
		return dao.bestMHP(userId); 
	}
	
	@Override
	public String store(MultipartFile file) throws Exception {
		
		String a = "a";
		return a;
	}
	
	@Transactional
	@Override
	public MyHiddenPlace selectOne(int num) throws Exception {
		
		dao.updateReadCount(num);
		return dao.selectOne(num);
	}
	
	@Override
	public List<MyHiddenPlace> bookmarkAll(String userId) throws Exception {
		return dao.bookmarkAll(userId); 
	}
	
	//내알못 베스트 업데이트
	@Override
	public void bestUpdateMHP() throws Exception {
		
		dao.bestUpdateMHP();
	}

}
