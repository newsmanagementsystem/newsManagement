package com.seven.service;

import java.sql.SQLException;

import com.seven.entity.User;



public interface UserService {
	public User getUserByUserName(String userName) throws SQLException;
	public void addUser(User user) throws SQLException;
	public boolean checkUserNameIsExit(String userName) throws SQLException;
}
