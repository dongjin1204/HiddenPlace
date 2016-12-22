package com.phoenix.hiddenplace.domain;

import java.util.Date;

public class User {

	private String userId; // 아이디
	private String userPw; // 비밀번호
	private String userNickname; // 닉네임
	private String userPhoneNum; // 전화번호
	private Date userStartDate; // 가입일시
	private Date userEndDate; // 탈퇴일시
	private int userLeaveIdCode; // 탈퇴구분코드 1일시 탈퇴 상태

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserPhoneNum() {
		return userPhoneNum;
	}

	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}

	public Date getUserStartDate() {
		return userStartDate;
	}

	public void setUserStartDate(Date userStartDate) {
		this.userStartDate = userStartDate;
	}

	public Date getUserEndDate() {
		return userEndDate;
	}

	public void setUserEndDate(Date userEndDate) {
		this.userEndDate = userEndDate;
	}

	public int getUserLeaveIdCode() {
		return userLeaveIdCode;
	}

	public void setUserLeaveIdCode(int userLeaveIdCode) {
		this.userLeaveIdCode = userLeaveIdCode;
	}

}