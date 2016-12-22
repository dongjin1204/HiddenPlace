package com.phoenix.hiddenplace.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.phoenix.hiddenplace.dao.UserDao;
import com.phoenix.hiddenplace.domain.Login;
import com.phoenix.hiddenplace.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDao dao;

	@Override
	public void create(User user) throws Exception {

		dao.create(user);
	}

	@Override
	public String nicknameCheck(String nickname) throws Exception {

		return dao.nicknameCheck(nickname);
	}

	@Override
	public User login(Login login) throws Exception {

		return dao.login(login);
	}

	@Override
	public void logout(Login login) throws Exception {

		dao.logout(login);
	}

	@Override
	public void loginConnect(User user) throws Exception {

		dao.loginConnect(user);
	}

	@Override
	public void loginConnectF(User user) throws Exception {

		dao.loginConnectF(user);
	}

	@Override
	public String emailCheck(String email) throws Exception {

		return dao.emailCheck(email);
	}

	@Override
	public void update(User user) throws Exception {

		dao.update(user);
	}

	@Override
	public int mypageAuth(String userId) throws Exception {

		return dao.mypageAuth(userId);
	}

	@Override
	public void delete(User user) throws Exception {

		dao.delete(user);
	}

	@Override
	public User getNickname(String userId) throws Exception {

		return dao.getNickname(userId);
	}

	@Override
	public User externalLogin(User user) throws Exception {

		return dao.externalLogin(user);
	}

}