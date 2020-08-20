package com.qf.service;

import java.util.List;

import com.qf.entity.User;

public interface UserService {

	public int addUser(User user);
	public int getUserByName(String username);
	public User QueryUser(String username);
	public int updateUser(User user);
	public int deleteUser(int uid);
	public List<User>getUserList();
	public User getUserByUid(int uid);
}
