package com.phoenix.hiddenplace.dao;

import java.util.List;
import com.phoenix.hiddenplace.domain.MyHiddenPlace;
import com.phoenix.hiddenplace.domain.PageMaker;

public interface MyHiddenPlaceDao {
	public void insert(MyHiddenPlace myHiddenPlace)throws Exception;
	
	public MyHiddenPlace selectOne(int num)throws Exception;  //내알못 조회
	 
	public void updateReadCount(int num)throws Exception; //조회수 증가

	List<MyHiddenPlace> list(PageMaker pageMaker) throws Exception;//내알못 목록
	
	List<MyHiddenPlace> bestMHP() throws Exception;//내알못 베스트 3
	
	public int listCount(PageMaker pageMaker);
	
	List<MyHiddenPlace> bookmarkAll(String userId) throws Exception;//현재 로그인 유저의 즐겨찾기 목록
	
	public void bestUpdateMHP() throws Exception; // 내알못 베스트 업데이트
}
