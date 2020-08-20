package com.qf.dao.impl;

import java.util.List;

import com.qf.dao.UserDao;
import com.qf.entity.User;
import com.qf.util.DBUtils;

public class UserDaoImpl implements UserDao {
	DBUtils<User> dbUtil = new DBUtils<>();

	@Override
	public int addUser(User user) {
		String sql = "insert into t_user(id,username,password,activatecode, flag,email,gender,createtime)values(?,?,?,?,?,?,?,?) ";
		int i = dbUtil.updateData(sql, user.getId(), user.getUsername(), user.getPassword(), user.getActivatecode(),
				user.getFlag(), user.getEmail(), user.getGender(), user.getCreatetime());
		System.out.println(i);
		return i;
	}

	@Override
	public User getUserByName(String username) {
		String sql = "select * from t_user where username=?";
		User user = dbUtil.querySingle(sql, User.class, username);
		return user;
	}

	@Override
	public int updateUser(User user) {
		String sql = "update t_user set id=?,username=?,password=?,activatecode=?,flag=?,email=?,gender=?,createtime=?";
		int i = dbUtil.updateData(sql, user.getId(), user.getUsername(), user.getPassword(), user.getActivatecode(),
				user.getFlag(), user.getEmail(), user.getGender(), user.getCreatetime());
		return i;
	}

	@Override
	public int deleteUser(int uid) {
		String sql = "delete from t_user where id=?";
		int i =dbUtil.updateData(sql, uid);
		return i;
	}

	@Override
	public List<User> getUserList() {
		String sql = "select * from t_user";
		List<User> userList = dbUtil.queryList(sql, User.class);
		return userList;
	}

	@Override
	public User getUserByUid(int uid) {
		String sql = "select * from t_user where id=?";
		User user = dbUtil.querySingle(sql, User.class, uid);
		return user;
	}

}
