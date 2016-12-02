package com.phoenix.hiddenplace.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.phoenix.hiddenplace.dao.MyHiddenPlaceDao;
import com.phoenix.hiddenplace.domain.MyHiddenPlace;

@Service
public class MyHiddenPlaceServiceImpl implements MyHiddenPlaceService {

	@Inject
	private MyHiddenPlaceDao dao;

	@Override
	public void insert(MyHiddenPlace myHiddenPlace) throws Exception {
		dao.insert(myHiddenPlace);		
	}


}
