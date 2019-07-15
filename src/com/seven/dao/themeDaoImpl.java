package com.seven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.seven.entity.Theme;
import com.seven.util.DatabaseUtil;

public class themeDaoImpl implements themeDao {
    //添加主题
    @Override
    public void addTheme(Theme theme) {
        //创建数据库连接对象
        Connection connection = null;

        try {
            //获取数据库连接对象
            connection = DatabaseUtil.getConnection();
            //编写SQL语句
            String sql_string = "INSERT INTO themeTable (themeName) VALUES (?)";
            PreparedStatement pmt = connection.prepareStatement(sql_string);
            pmt.setString(1, theme.getThemeName());

            //ִ执行SQL语句
            pmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //检查主题是否存在
    @Override
    public boolean checkThemeIfExist(String themeName) {
        //创建数据库连接对象
        Connection connection = null;
        //用于统计返回的查询结果集的数量
        byte count = 0;
        try {
            //获取数据库连接对象
            connection = DatabaseUtil.getConnection();

            //编写SQL语句
            String sql_string = "SELECT * FROM themetable WHERE themeName = ?";
            PreparedStatement pmt = connection.prepareStatement(sql_string);
            pmt.setString(1, themeName);

            //执行查询
            ResultSet resultSet = pmt.executeQuery();

            //统计主题数量
            while (resultSet.next()) {
                count++;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //根据统计的主题数量判断添加的主题是否存在
        if (count > 0) {
            return true;
        }
        return false;
    }


    //找到所有
    @Override
    public List<Theme> findAllThemes() {
        Connection conn = null;
        List<Theme> list = new ArrayList<Theme>();
        ResultSet rs = null;
        // 获取所有主题
        String sql = "select * from themetable";
        try {
            conn = DatabaseUtil.getConnection();
            PreparedStatement ptmt = conn.prepareStatement(sql);
            rs = ptmt.executeQuery(sql);
            Theme theme = null;
            while (rs.next()) {
                theme = new Theme();
                theme.setThemeID(rs.getInt("themeID"));
                theme.setThemeName(rs.getString("themeName"));
                list.add(theme);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //throw e;
        } finally {
             //关闭
        }
        return list;
    }

    @Override
    public int updateTheme(Theme theme) {
        Connection conn = null;
        String sql = "UPDATE themetable SET themeName = ? WHERE themeID = ?";
        int result = 0;
        try {
            conn = DatabaseUtil.getConnection();
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, theme.getThemeName());
            ptmt.setInt(2, theme.getThemeID());
            result = ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Theme findThemeByName(String name) {
        Connection conn = null;
        String sql = "SELECT * FROM themetable WHERE themeName = ?";
        ResultSet rs = null;
        Theme theme = null;
        try {
            conn = DatabaseUtil.getConnection();
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, name);
            rs = ptmt.executeQuery();
            if (rs.next()) {
                theme = new Theme();
                theme.setThemeID(rs.getInt("themeID"));
                theme.setThemeName(rs.getString("themeName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return theme;
    }

    @Override
    public int deleteTheme(int tid) {
        Connection conn = null;
        String sql = "DELETE FROM themetable WHERE themeID = ?";
        int result = 0;
        try {
            conn = DatabaseUtil.getConnection();
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setInt(1, tid);
            result = ptmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
