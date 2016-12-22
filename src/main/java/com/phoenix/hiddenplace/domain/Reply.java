package com.phoenix.hiddenplace.domain;

public class Reply {
	
	private int replyNum;
	private int num;
	private int routeNum;
	private String replyComment;
	private String userId;
	private String userNickname; //닉네임 유저
	private String writeDate;
	
	public int getReplyNum() {
		return replyNum;
	}
	
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public int getRouteNum() {
		return routeNum;
	}
	
	public void setRouteNum(int routeNum) {
		this.routeNum = routeNum;
	}
	
	public String getReplyComment() {
		return replyComment;
	}
	
	public void setReplyComment(String replyComment) {
		this.replyComment = replyComment;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserNickname() {
		return userNickname;
	}
	
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	
	public String getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
}