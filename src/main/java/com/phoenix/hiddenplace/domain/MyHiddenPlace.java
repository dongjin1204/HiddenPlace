package com.phoenix.hiddenplace.domain;

import java.util.Date;

public class MyHiddenPlace {

	private Integer num;
	private String userId;
	private int regionTownCode;
	private int themeCode;
	private String title;
	private String content;
	private Date writeDate;
	private int upCount;
	private int readCount;
	private String storeName;
	private int code;
	private double latitude;
	private double longitude;
	private String detailAddress;
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getRegionTownCode() {
		return regionTownCode;
	}
	public void setRegionTownCode(int regionTownCode) {
		this.regionTownCode = regionTownCode;
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
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
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
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	@Override
	public String toString() {
		return "Domain [num=" + num + ", userId=" + userId + ", regionTownCode=" + regionTownCode + ", themeCode="
				+ themeCode + ", title=" + title + ", content=" + content + ", writeDate=" + writeDate + ", upCount="
				+ upCount + ", readCount=" + readCount + ", storeName=" + storeName + ", code=" + code + ", latitude="
				+ latitude + ", longitude=" + longitude + ", detailAddress=" + detailAddress + "]";
	}
	
	
	
}
