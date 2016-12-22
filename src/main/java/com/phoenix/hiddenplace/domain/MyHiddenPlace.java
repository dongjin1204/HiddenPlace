package com.phoenix.hiddenplace.domain;

public class MyHiddenPlace {

	private int num; //글번호
	private String userId;//회원아이디
	private int themeCode;//테마 코드
	private String title;//제목
	private String content;//내용
	private String writeDate;//글쓴 날짜
	private int upCount;//추천수
	private int readCount;//조회수
	private String storeName;//상호명
	private int mhpBestCode;//베스트코드
	private String userNickname; //닉네임 유저
	private String titleImgURL; //타이틀이미지 URL
	private int upCountCode; //추천수 코드
	private String address; //검색한 주소
	
	public int getUpCountCode() {
		return upCountCode;
	}
	
	public void setUpCountCode(int upCountCode) {
		this.upCountCode = upCountCode;
	}
	
	public String getTitleImgURL() {
		return titleImgURL;
	}
	
	public void setTitleImgURL(String titleImgURL) {
		this.titleImgURL = titleImgURL;
	}
	
	public String getUserNickname() {
		return userNickname;
	}
	
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public int getThemeCode() {
		return themeCode;
	}
	
	public void setThemeCode(int themeCode) {
		this.themeCode = themeCode;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	public int getUpCount() {
		return upCount;
	}
	
	public void setUpCount(int upCount) {
		this.upCount = upCount;
	}
	
	public int getReadCount() {
		return readCount;
	}
	
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public int getMhpBestCode() {
		return mhpBestCode;
	}
	
	public void setMhpBestCode(int mhpBestCode) {
		this.mhpBestCode = mhpBestCode;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
}