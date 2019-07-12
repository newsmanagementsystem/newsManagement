package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 用于封装数据库连接
 */
public class DatabaseUtil {
	
    /**
     * 创建数据库连接
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
        	//初始化服务器上下文
			Context context = new InitialContext();
			//在JNDI容器中检索数据源
			DataSource dSource = (DataSource)context.lookup("java:comp/env/mysqlData");
			conn = dSource.getConnection();;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return conn;// 返回数据库连接
    }

}
