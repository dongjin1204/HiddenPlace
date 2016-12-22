package com.phoenix.hiddenplace.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.phoenix.hiddenplace.dao.BookmarkDao;
import com.phoenix.hiddenplace.domain.Bookmark;
import com.phoenix.hiddenplace.domain.BookmarkPageMaker;
import com.phoenix.hiddenplace.domain.MyHiddenPlace;

@Service
public class BookmarkServiceImpl implements BookmarkService {

	@Inject
	private BookmarkDao dao;

	@Override
	public void bookmarkDelete(String nums) throws Exception {

		dao.bookmarkDelete(nums);
	}

	//즐겨찾기 등록(홈페이지)
	@Override
	public void bookmarkInsertMHP(MyHiddenPlace myHiddenPlace) throws Exception {

		dao.bookmarkInsertMHP(myHiddenPlace);
	}

	//즐겨찾기 해제(홈페이지)
	@Override
	public void bookmarkDeleteMHP(MyHiddenPlace myHiddenPlace) throws Exception {
		
		dao.bookmarkDeleteMHP(myHiddenPlace);
	}
	
	@Override
	public List<Bookmark> bookmarkMHPAll(BookmarkPageMaker pageMaker) throws Exception {

		return dao.bookmarkMHPAll(pageMaker);
	}
	
	@Override
	public List<Bookmark> bookmarkMRAll(String userId) throws Exception {

		return dao.bookmarkMRAll(userId);
	}

	@Override
	public int listCount(BookmarkPageMaker pageMaker) {

		return dao.listCount(pageMaker);
	}

}