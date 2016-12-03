package com.phoenix.hiddenplace.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.phoenix.hiddenplace.dao.MainHomeDao;

@Service
public class MainHomeServiceImpl implements MainHomeService {

	@Inject
	private MainHomeDao dao;

	@Override
	public String search(String search) throws Exception {
		
		return dao.selectSearch(search);
		
	}


}
