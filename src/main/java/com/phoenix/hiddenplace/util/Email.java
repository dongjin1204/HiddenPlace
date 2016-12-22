package com.phoenix.hiddenplace.util;

public class Email {

	private String subject; // 메일 제목
	private String content; // 메일 내용
	private String reciver; // 메일 수신자

	public String getReciver() {

		return reciver;
	}

	public void setReciver(String reciver) {

		this.reciver = reciver;
	}

	public String getSubject() {

		return subject;
	}

	public void setSubject(String subject) {

		this.subject = subject;
	}

	public String getContent() {

		return content;
	}

	public void setContent(String content) {

		this.content = content;
	}

}