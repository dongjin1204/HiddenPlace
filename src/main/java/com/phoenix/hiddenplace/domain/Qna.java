package com.phoenix.hiddenplace.domain;

public class Qna {

	private int qnaNum;
	private String title;
	private String content;
	private String userId;
	private String userNickname;
	private String QnaWriteDate;

	public String getQnaWriteDate() {
		return QnaWriteDate;
	}
	
	public void setQnaWriteDate(String qnaWriteDate) {
		QnaWriteDate = qnaWriteDate;
	}
	
	public int getQnaNum() {
		return qnaNum;
	}
	
	public void setQnaNum(int qnaNum) {
		this.qnaNum = qnaNum;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	public String getUserNickname() {
		return userNickname;
	}
	
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

}