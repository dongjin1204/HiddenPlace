package com.phoenix.hiddenplace.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.phoenix.hiddenplace.dao.BookMarkDao;

@Service
public class BookMarkServiceImpl implements BookMarkService {

	@Inject
	private BookMarkDao dao;

	

	@Override
	public void bookMarkDelete(String nums) throws Exception {
		System.out.println("서비스출력");
		dao.bookMarkDelete(nums);
	}

}
