package com.phoenix.hiddenplace.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.phoenix.hiddenplace.dao.UserDao;
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
	public User readMyPage(String userId) throws Exception {
		
		return dao.readMyPage(userId);
		
	}

	@Override
	public void modify(User user) throws Exception {

		dao.update(user); // userNickName, userPw 수정

	}

	@Override
	public void delete(String userPw) throws Exception {

		dao.delete(userPw);

	}
	
	@Override
	   public User login(User user) throws Exception {
			
	      return dao.loginPro(user);
	   }

}
