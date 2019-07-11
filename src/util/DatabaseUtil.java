package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 鏁版嵁搴撹繛鎺ヤ笌鍏抽棴宸ュ叿绫汇��
 */
public class DatabaseUtil {
	
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost:3306/newsdatabase";
    private static final String USER = "root";
    private static final String PASS = "zbs980716";
    
    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 鑾峰彇鏁版嵁搴撹繛鎺ュ璞°��
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        // 鑾峰彇杩炴帴骞舵崟鑾峰紓甯�
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return conn;// 杩斿洖杩炴帴瀵硅薄
    }

    /**
     * 鍏抽棴鏁版嵁搴撹繛鎺ャ��
     * 
     * @param conn
     *            鏁版嵁搴撹繛鎺�
     * @param stmt
     *            Statement瀵硅薄
     * @param rs
     *            缁撴灉闆�
     */
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        // 鑻ョ粨鏋滈泦瀵硅薄涓嶄负绌猴紝鍒欏叧闂�
        try {
            if (rs != null && !rs.isClosed())
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 鑻tatement瀵硅薄涓嶄负绌猴紝鍒欏叧闂�
        try {
            if (stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 鑻ユ暟鎹簱杩炴帴瀵硅薄涓嶄负绌猴紝鍒欏叧闂�
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
