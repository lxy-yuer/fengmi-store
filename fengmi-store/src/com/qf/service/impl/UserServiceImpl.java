package com.qf.service.impl;

import java.util.List;

import com.qf.dao.UserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.entity.User;
import com.qf.service.UserService;

public class UserServiceImpl implements UserService {
	private final UserDao userDao = new UserDaoImpl();

	@Override
	public int addUser(User user) {
		User user1 = userDao.getUserByName(user.getUsername());
		if (user1 == null) {
			System.out.println("user == null");
			int i = userDao.addUser(user);
			return i;
		} else {
			return -1;
		}

	}

	@Override
	public int getUserByName(String username) {
		User user= userDao.getUserByName(username);
		if (user != null) {
			//存在
			return -1;
		} else {
			//不存在
			return 1;
		}
	}

	@Override
	public User QueryUser(String username) {
		User user= userDao.getUserByName(username);
		if (user != null) {
			//存在
			return user;
		} else {
			//不存在
			return null;
		}
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> getUserList() {
		List<User> userList = userDao.getUserList();
		return userList;
	}

	@Override
	public User getUserByUid(int uid) {
		// TODO Auto-generated method stub
		return null;
	}
}
