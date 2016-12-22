package com.phoenix.hiddenplace.dao;

import com.phoenix.hiddenplace.domain.Login;
import com.phoenix.hiddenplace.domain.User;

public interface UserDao {
	//회원가입
	public void create(User user) throws Exception;

	//닉네임 중복확인
	public String nicknameCheck(String nickname) throws Exception;

	//이메일 중복확인
	public String emailCheck(String email) throws Exception;

	//로그인
	public User login(Login login) throws Exception;

	//로그아웃
	public void logout(Login login) throws Exception;

	//로그인 테이블에 로그인 상태, 계정 상태 update(일반회원)
	public void loginConnect(User user) throws Exception;

	//로그인 테이블에 로그인 상태, 계정 상태 update(페이스북)
	public void loginConnectF(User user) throws Exception;

	//회원정보 수정
	public void update(User user) throws Exception;

	//마이페이지 접근 권한
	public int mypageAuth(String userId) throws Exception;

	//회원탈퇴
	public void delete(User user) throws Exception;

	//닉네임 가져오기
	public User getNickname(String userId) throws Exception;

	//페이스북 로그인
	public User externalLogin(User user) throws Exception;
}