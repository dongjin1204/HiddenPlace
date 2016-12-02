package com.phoenix.hiddenplace.dao;

import com.phoenix.hiddenplace.domain.MyHiddenPlace;

public interface MyHiddenPlaceDao {

	public void insert(MyHiddenPlace myHiddenPlace)throws Exception;
	
	public MyHiddenPlace selectOne(Integer num)throws Exception;
	
	
}
