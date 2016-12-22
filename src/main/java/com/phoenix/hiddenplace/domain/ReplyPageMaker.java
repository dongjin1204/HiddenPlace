package com.phoenix.hiddenplace.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class ReplyPageMaker {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int page = 1;	
	private int perPageNum = 10;
	private int themeCode = 0;
	private int displayPageNum = 10;
	private String keyWord;
	private String userId;
	private int num;
	
	public ReplyPageMaker() {
		
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.calcData();
	}

	private void calcData() { //페이징계산
		this.endPage = (int)(Math.ceil(getPage() / (double)displayPageNum ) * displayPageNum);
		this.startPage = (endPage - displayPageNum) + 1;
		int tempEndPage = (int)(Math.ceil(totalCount / (double)getPerPageNum()));
		
		if(endPage > tempEndPage){
			this.endPage = tempEndPage;
		}

		this.prev = startPage == 1 ? false : true;
		this.next = endPage * getPerPageNum() >= totalCount ? false : true;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public String makeQuery(int page){
		UriComponents uriComponents =
	            UriComponentsBuilder.newInstance()
	            .queryParam("page", page)
	            .queryParam("perPageNum", getPerPageNum())
	            .build();	            
		
		return uriComponents.toUriString();
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}	
	
	public void setPage(int page){
		this.page = page;
	}

	public void setPerPageNum(int perPageNum){
		if(perPageNum <= 0 || perPageNum > 100){
			this.perPageNum = 12;
			return;
		}

		this.perPageNum = perPageNum;
	}

	public int getPage() {
		return page;
	}	

	//method for MyBatis SQL Mapper - 
	public int getPageStart() {
		return (this.page -1)* perPageNum;
	}

	//method for MyBatis SQL Mapper 
	public int getPerPageNum(){
		return this.perPageNum;
	}
	
	public int getThemeCode() {
		return themeCode;
	}

	public void setThemeCode(int themeCode) {
		this.themeCode = themeCode;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}