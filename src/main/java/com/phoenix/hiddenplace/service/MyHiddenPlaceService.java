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

	public MyHiddenPlace selectOne(int num) throws Exception;
	
	List<MyHiddenPlace> bookmarkAll(String userId) throws Exception;

}
