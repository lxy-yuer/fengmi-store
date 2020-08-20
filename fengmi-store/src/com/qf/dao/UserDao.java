package com.qf.dao;

import java.util.List;

import com.qf.entity.User;

public interface UserDao {
	public int addUser(User user);
	public User getUserByName(String username);
	public int updateUser(User user);
	public int deleteUser(int uid);
	public List<User>getUserList();
	public User getUserByUid(int uid);
}
