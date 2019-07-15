package com.seven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seven.entity.News;
import com.seven.entity.Theme;
import com.seven.util.DatabaseUtil;

public class NewsDaoImpl implements NewsDao {
	
	//添加新闻
	@Override
	public int addNews(News news) {
		// TODO Auto-generated method stub
		//创建数据库连接对象
        Connection connection = null;
        int flag=0;//添加新闻成功标志
        try {
            //获取数据库连接对象
            connection = DatabaseUtil.getConnection();
            //编写SQL语句
            String sql_string = "INSERT INTO newstable "+
            					"(themeId,newsTitle,newsAuthor,newsCreatedate,newsModifydate,newsSummary,newsContent,newsPicpath)"+
            					" VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pmt = connection.prepareStatement(sql_string);
            pmt.setInt(1, news.getThemeId());
            pmt.setString(2, news.getNewsTitle());
            pmt.setString(3, news.getNewsAuthor());
            pmt.setDate(4, news.getNewsCreatedate());
            pmt.setDate(5, news.getNewsModifydate());
            pmt.setString(6, news.getNewsSummary());
            pmt.setString(7, news.getNewsContent());
            pmt.setString(8, news.getNewsPicpath());
            //ִ执行SQL语句
            pmt.execute();
            flag=1;
        } catch (SQLException e) {

        }
        return flag;
	}

	//检查该标题的而新闻是否存在
	@Override
	public boolean checkNewsIfExist(String newsTitle) {
		// TODO Auto-generated method stub
		//创建数据库连接对象
        Connection connection = null;
        //用于统计返回的查询结果集的数量
        byte count = 0;
        try {
            //获取数据库连接对象
            connection = DatabaseUtil.getConnection();

            //编写SQL语句
            String sql_string = "SELECT * FROM newstable WHERE newsTitle = ?";
            PreparedStatement pmt = connection.prepareStatement(sql_string);
            pmt.setString(1, newsTitle);

            //执行查询
            ResultSet resultSet = pmt.executeQuery();

            //统计新闻数量
            while (resultSet.next()) {
                count++;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //根据统计的新闻数量判断添加的新闻是否存在
        if (count > 0) {
            return true;
        }
        return false;
	}

	// 获取所有新闻
	@Override
	public List<News> findAllNews() {
		// TODO Auto-generated method stub
		Connection conn = null;
        List<News> list = new ArrayList<News>();
        ResultSet rs = null;
        String sql = "select * from newstable";
        try {
            conn = DatabaseUtil.getConnection();
            PreparedStatement ptmt = conn.prepareStatement(sql);
            rs = ptmt.executeQuery(sql);
            News news = null;
            while (rs.next()) {
                news = new News();
                news.setNewsId(rs.getInt("newsId"));
                news.setThemeId(rs.getInt("themeId"));
                news.setNewsAuthor(rs.getString("newsAuthor"));
                news.setNewsTitle(rs.getString("newsTitle"));
                news.setNewsCreatedate(rs.getDate("newsCreatedate"));
                news.setNewsModifydate(rs.getDate("newsModifydate"));
                news.setNewsContent(rs.getString("newsContent"));
                news.setNewsSummary(rs.getString("newsSummary"));
                news.setNewsPicpath(rs.getString("newsPicpath"));
                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //throw e;
        } finally {
             //关闭
        }
        return list;
	}
	
	//获取某主题的所有新闻
	@Override
	public List<News> findAllNewsByThemeId(int themeId) {
		// TODO Auto-generated method stub
		Connection conn = null;
        List<News> list = new ArrayList<News>();
        ResultSet rs = null;
        String sql = "select * from newstable WHERE themeId = ?";
   
        try {
            conn = DatabaseUtil.getConnection();
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setInt(1, themeId);
            rs = ptmt.executeQuery(sql);
            News news = null;
            while (rs.next()) {
                news = new News();
                news.setNewsId(rs.getInt("newsId"));
                news.setThemeId(rs.getInt("themeId"));
                news.setNewsAuthor(rs.getString("newsAuthor"));
                news.setNewsTitle(rs.getString("newsTitle"));
                news.setNewsCreatedate(rs.getDate("newsCreatedate"));
                news.setNewsModifydate(rs.getDate("newsModifydate"));
                news.setNewsContent(rs.getString("newsContent"));
                news.setNewsSummary(rs.getString("newsSummary"));
                news.setNewsPicpath(rs.getString("newsPicpath"));
                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //throw e;
        } finally {
             //关闭
        }
        return list;
	}

	//修改新闻
	@Override
	public int updateNews(News news) {
		// TODO Auto-generated method stub
		Connection conn = null;
        String sql = "UPDATE newstable SET "+
        					"themeId=?,newsTitle=?,newsModifydate=?,newsSummary=?,newsContent=?,newsPicpath=? "+
        					"WHERE newsId = ?";
        int result = 0;
        try {
            conn = DatabaseUtil.getConnection();
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setInt(1, news.getThemeId());
            ptmt.setString(2, news.getNewsTitle());
            ptmt.setDate(3, news.getNewsModifydate());
            ptmt.setString(4, news.getNewsSummary());
            ptmt.setString(5, news.getNewsContent());
            ptmt.setString(6, news.getNewsPicpath());
            ptmt.setInt(7, news.getNewsId());
            result = ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
	}
	
	//由新闻标题获取新闻
	@Override
	public News findNewsByTitle(String title) {
		// TODO Auto-generated method stub
		 Connection conn = null;
	        String sql = "SELECT * FROM newstable WHERE newsTitle = ?";
	        ResultSet rs = null;
	        News news = null;
	        try {
	            conn = DatabaseUtil.getConnection();
	            PreparedStatement ptmt = conn.prepareStatement(sql);
	            ptmt.setString(1, title);
	            rs = ptmt.executeQuery();
	            if (rs.next()) {
	                news = new News();
	                news.setNewsId(rs.getInt("newsId"));
	                news.setThemeId(rs.getInt("themeId"));
	                news.setNewsAuthor(rs.getString("newsAuthor"));
	                news.setNewsTitle(rs.getString("newsTitle"));
	                news.setNewsCreatedate(rs.getDate("newsCreatedate"));
	                news.setNewsModifydate(rs.getDate("newsModifydate"));
	                news.setNewsContent(rs.getString("newsContent"));
	                news.setNewsSummary(rs.getString("newsSummary"));
	                news.setNewsPicpath(rs.getString("newsPicpath"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        }
	        return news;
	}
	
	
	//删除新闻
	@Override
	public int deleteNews(int nid) {
		// TODO Auto-generated method stub
		Connection conn = null;
        String sql = "DELETE FROM newstable WHERE newsId = ?";
        int result = 0;
        try {
            conn = DatabaseUtil.getConnection();
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setInt(1, nid);
            result = ptmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
	}

}
