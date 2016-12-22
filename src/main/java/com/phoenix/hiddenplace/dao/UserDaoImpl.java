package com.phoenix.hiddenplace.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.phoenix.hiddenplace.domain.Login;
import com.phoenix.hiddenplace.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Inject
	private SqlSession session;

	private static String namespace = "com.phoenix.hiddenplace.mapper.UserMapper";

	@Override
	public void create(User user) throws Exception {

		session.insert(namespace + ".userCreate", user);
		session.insert(namespace + ".loginCreate", user);
	}

	@Override
	public String nicknameCheck(String nickname) throws Exception {

		return session.selectOne(namespace + ".nicknameCheck", nickname);
	}

	public String emailCheck(String email) throws Exception {

		return session.selectOne(namespace + ".emailCheck", email);
	}

	@Override
	public User login(Login login) throws Exception {

		return session.selectOne(namespace + ".login", login);
	}

	@Override
	public void logout(Login login) throws Exception {

		session.update(namespace + ".logout", login);
	}

	@Override
	public void loginConnect(User user) throws Exception {

		session.update(namespace + ".loginConnect", user); // 로그인 계정 상태 변경
	}

	@Override
	public void loginConnectF(User user) throws Exception {

		session.update(namespace + ".loginConnectF", user); // 로그인 계정 상태 변경
	}

	@Override
	public void update(User user) throws Exception {

		session.update(namespace + ".update", user);
	}

	@Override
	public int mypageAuth(String userId) throws Exception {

		return session.selectOne(namespace + ".mypageAuth", userId);
	}

	@Override
	public void delete(User user) throws Exception {

		session.delete(namespace + ".delete", user);
	}

	@Override
	public User getNickname(String userId) throws Exception {

		return session.selectOne(namespace + ".getNickname", userId);
	}

	@Override
	public User externalLogin(User user) throws Exception {

		return session.selectOne(namespace + ".externalLogin", user);
	}

}