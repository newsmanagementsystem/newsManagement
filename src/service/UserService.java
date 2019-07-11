package service;

import java.sql.SQLException;
import java.util.List;

import entity.User;



public interface UserService {
	public User getUserByUserName(String userName) throws SQLException;
	public void addUser(User user) throws SQLException;
	public boolean checkUserNameIsExit(String userName) throws SQLException;
}
