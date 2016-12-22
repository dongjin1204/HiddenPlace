package com.phoenix.hiddenplace.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.phoenix.hiddenplace.domain.MyHiddenPlace;
import com.phoenix.hiddenplace.domain.PageMaker;
import com.phoenix.hiddenplace.domain.Theme;

public interface MyHiddenPlaceService {
	public void insert(MyHiddenPlace myHiddenPlace)throws Exception;

	List<MyHiddenPlace> list(PageMaker pageMaker) throws Exception; //내알못 목록
	
	List<MyHiddenPlace> bestMHP() throws Exception; //내알못 베스트 3

	int listCount(PageMaker pageMaker) throws Exception;

	String store(MultipartFile file) throws Exception;
	
	List<Theme> themeList() throws Exception;

	public MyHiddenPlace selectOne(int num) throws Exception; //내알못 조회
	
	List<MyHiddenPlace> bookmarkAll(String userId) throws Exception; //내알못 로그인한 유저의 즐겨찾기 목록 불러오기(홈페이지)
	
	public void delete(int num) throws Exception; //내알못 삭제
	
	public Integer upCountCheck(MyHiddenPlace myHiddenPlace)throws Exception; //추천코드 뽑기
	
	public void upCount(MyHiddenPlace myHiddenPlace) throws Exception; //추천수 증가 및 저장
	
	public void updateMHP(MyHiddenPlace myHiddenPlace)throws Exception; //내알못 수정

	public void updateBestMHP() throws Exception; //내알못 베스트 초기화 및 업데이트
}
