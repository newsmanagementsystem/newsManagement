package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;
import util.DatabaseUtil;

public class UserServiceImpl implements UserService {
	@Override
	//根据用户名检查用户是否存在
	public boolean checkUserNameIsExit(String userName) throws SQLException {
		Connection conn = null;
		int count = 0;
		try {
			conn = DatabaseUtil.getConnection();
			User user = null;
			
			//编写SQL语句
			String sql = "SELECT * FROM usertable WHERE userName = ?";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, userName);
			
			//执行查询
			ResultSet rs = ptmt.executeQuery();
			
			//统计用户数量
			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
		if (count > 0)
			return true;
		return false;
	}
	
	

	@Override
	//用户注册
	public void addUser(User user) throws SQLException {
		Connection conn=null;
		try {
		//连接数据库
        conn = DatabaseUtil.getConnection();
        
        //编写sql语句
        String sql = "INSERT INTO usertable (userName, userSex, userPassword, userEmail, userBirthday)"
                +" values("+"?,?,?,?,?)";
        PreparedStatement ptmt = conn.prepareStatement(sql); 
        ptmt.setString(1, user.getUserName());
        ptmt.setString(2, user.getUserSex());
        ptmt.setString(3, user.getUserPassword());
        ptmt.setString(4, user.getUserEmail());
        //java.util.Date cannot be cast to java.sql.Date
        ptmt.setDate(5, new java.sql.Date(user.getUserBirthday().getTime()));
        //new java.sql.Date(user.getBirth().getTime())
//        ptmt.setInt(6, user.getUserFlag());
        
        //执行SQL语句
        ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
	}

	//查询用户
	@Override
	public User getUserByUserName(String userName) throws SQLException {
		Connection conn = null;
		User user = null;
		try {
			conn = DatabaseUtil.getConnection();
			
			//编写SQL语句
			String sql = "SELECT * FROM usertable WHERE userName = ?";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, userName);
			
			//执行查询
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				user=new User();
				user.setUserName(rs.getString("userName"));
				user.setUserSex(rs.getString("userSex"));
				user.setUserEmail(rs.getString("userEmail"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserBirthday(rs.getDate("userBirthday"));
				user.setUserFlag(rs.getInt("userFlag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
		//返回查询的用户
		return user;

	}
}
