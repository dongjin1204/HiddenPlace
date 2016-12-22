package com.phoenix.hiddenplace.dao;

import java.util.List;
import com.phoenix.hiddenplace.domain.MyHiddenPlace;
import com.phoenix.hiddenplace.domain.PageMaker;
import com.phoenix.hiddenplace.domain.Theme;

public interface MyHiddenPlaceDao {
	public void insert(MyHiddenPlace myHiddenPlace)throws Exception;
	
	public MyHiddenPlace selectOne(int num)throws Exception; //내알못 조회
	 
	public void updateReadCount(int num)throws Exception; //조회수 증가

	List<MyHiddenPlace> list(PageMaker pageMaker) throws Exception; //내알못 목록
	
	List<MyHiddenPlace> bestMHP() throws Exception; //내알못 베스트 3
	
	public int listCount(PageMaker pageMaker);
	
	public List<Theme> themeList() throws Exception; //목록페이지에 테마 버튼 호출
	
	List<MyHiddenPlace> bookmarkAll(String userId) throws Exception; //현재 로그인 유저의 즐겨찾기 목록
	
	public void delete(int num) throws Exception; //내알못 삭제
	
	public Integer upCountCheck(MyHiddenPlace myHiddenPlace) throws Exception; //추천코드
	
	public void upCountInsert(MyHiddenPlace myHiddenPlace) throws Exception; //추천한 사람 등록
	
	public void upCount(MyHiddenPlace myHiddenPlace) throws Exception; //추천수 증가
	
	public void updateMHP(MyHiddenPlace myHiddenPlace)throws Exception; //내알못 수정
	
    public void updateBestCode()throws Exception; //내알못 베스트코드 0초기화
   
    public String updateBestStoreName()throws Exception; //내알못 베스트선정 
   
    public void updateBestMHP(String storeNames)throws Exception; //내알못 베스트선정 후 코드 1로 변경
}