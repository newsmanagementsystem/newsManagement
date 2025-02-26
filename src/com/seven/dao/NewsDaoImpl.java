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
            pmt.setTimestamp(4, new java.sql.Timestamp(news.getNewsCreatedate().getTime()));
            pmt.setTimestamp(5, new java.sql.Timestamp(news.getNewsModifydate().getTime()));
            pmt.setString(6, news.getNewsSummary());
            pmt.setString(7, news.getNewsContent());
            pmt.setString(8, news.getNewsPicpath());
            //ִ执行SQL语句
            pmt.execute();
            flag=1;
            connection.close();
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
            connection.close();
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
            rs = ptmt.executeQuery();
            News news = null;
            while (rs.next()) {
                news = new News();
                news.setNewsId(rs.getInt("newsId"));
                news.setThemeId(rs.getInt("themeId"));
                news.setNewsAuthor(rs.getString("newsAuthor"));
                news.setNewsTitle(rs.getString("newsTitle"));
                news.setNewsCreatedate(rs.getTimestamp("newsCreatedate"));
                news.setNewsModifydate(rs.getTimestamp("newsModifydate"));
                news.setNewsContent(rs.getString("newsContent"));
                news.setNewsSummary(rs.getString("newsSummary"));
                news.setNewsPicpath(rs.getString("newsPicpath"));
                list.add(news);
            }
            conn.close();
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
            rs = ptmt.executeQuery();
            News news = null;
            while (rs.next()) {
                news = new News();
                news.setNewsId(rs.getInt("newsId"));
                news.setThemeId(rs.getInt("themeId"));
                news.setNewsAuthor(rs.getString("newsAuthor"));
                news.setNewsTitle(rs.getString("newsTitle"));
                news.setNewsCreatedate(rs.getTimestamp("newsCreatedate"));
                news.setNewsModifydate(rs.getTimestamp("newsModifydate"));
                news.setNewsContent(rs.getString("newsContent"));
                news.setNewsSummary(rs.getString("newsSummary"));
                news.setNewsPicpath(rs.getString("newsPicpath"));
                list.add(news);
            }
            conn.close();
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
            ptmt.setTimestamp(3, new java.sql.Timestamp(news.getNewsModifydate().getTime()));
            ptmt.setString(4, news.getNewsSummary());
            ptmt.setString(5, news.getNewsContent());
            ptmt.setString(6, news.getNewsPicpath());
            ptmt.setInt(7, news.getNewsId());
            result = ptmt.executeUpdate();
            conn.close();
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
	                news.setNewsCreatedate(rs.getTimestamp("newsCreatedate"));
	                news.setNewsModifydate(rs.getTimestamp("newsModifydate"));
	                news.setNewsContent(rs.getString("newsContent"));
	                news.setNewsSummary(rs.getString("newsSummary"));
	                news.setNewsPicpath(rs.getString("newsPicpath"));
	            }
	            conn.close();
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
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
	}
	
	@Override
    public int getNewsCountBythemeId(int themeId) {
        //查找sql
        Connection conn = null;
        ResultSet rs = null;
        //根据themeId查询返回的新闻数量
        int count=0;
        try {
            String sql = "SELECT * FROM newstable WHERE themeId = ?";
            //获取连接
            conn = DatabaseUtil.getConnection();
            PreparedStatement pmt = conn.prepareStatement(sql);
            pmt.setInt(1, themeId);
            //执行查询
            rs = pmt.executeQuery();
            //统计新闻数量
            while (rs.next()) {
                count++;
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

	//根据新闻id查找新闻
    @Override
    public News findNewsById(int nid){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pmt = null;
        News news = new News();
        try {
            String sql = "SELECT * FROM newstable WHERE newsId = ?";
            //获取连接
            conn = DatabaseUtil.getConnection();
            pmt = conn.prepareStatement(sql);
            pmt.setInt(1, nid);
            rs = pmt.executeQuery();
            //统计新闻数量
            if(rs == null){
                System.out.println("1111weikong===="+nid);
            }
            rs.next();
            if(rs == null){
                System.out.println("2222weikong");
            }
           news.setNewsId(rs.getInt("newsId"));
           news.setThemeId(rs.getInt("themeId"));
           news.setNewsTitle(rs.getString("newsTitle"));
           news.setNewsAuthor(rs.getString("newsAuthor"));
           news.setNewsPicpath(rs.getString("newsPicpath"));
           news.setNewsSummary(rs.getString("newsSummary"));
           news.setNewsContent(rs.getString("newsContent"));
           /*news.setNewsCreatedate(rs.getString("newsCreatrdate"));
           news.setNewsModifydate(rs.getString("newsModifydate"));*/
           conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            DatabaseUtil.release(conn,pmt,rs);
        }
        return news;
    }
  //查找新闻的总数
    @Override
    public int getNewsCount(){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pmt = null;
        News news = new News();
        int count = 0;
        try {
            String sql = "SELECT count(*) FROM newstable";
            //获取连接
            conn = DatabaseUtil.getConnection();
            pmt = conn.prepareStatement(sql);
            rs = pmt.executeQuery();
            rs.next();
            count = rs.getInt(1);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            DatabaseUtil.release(conn,pmt,rs);
        }

	    return count;
    }


    //分页查找新闻数据
    public ArrayList<News> getNewsListSplit(int startRow,int pageSize){

        Connection conn = null;
        ArrayList<News> list = new ArrayList<News>();
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        String sql = "select * from newstable LIMIT ?,?";
        try {
            conn = DatabaseUtil.getConnection();
            ptmt = conn.prepareStatement(sql);
            ptmt.setInt(1,startRow);
            ptmt.setInt(2,pageSize);
            rs = ptmt.executeQuery();

            while (rs.next()) {
                News news = new News();
                news.setNewsId(rs.getInt("newsId"));
                news.setThemeId(rs.getInt("themeId"));
                news.setNewsAuthor(rs.getString("newsAuthor"));
                news.setNewsTitle(rs.getString("newsTitle"));
                news.setNewsCreatedate(rs.getTimestamp("newsCreatedate"));
                news.setNewsModifydate(rs.getTimestamp("newsModifydate"));
                news.setNewsContent(rs.getString("newsContent"));
                news.setNewsSummary(rs.getString("newsSummary"));
                news.setNewsPicpath(rs.getString("newsPicpath"));
                list.add(news);
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            DatabaseUtil.release(conn,ptmt,rs);
        }
        return list;
    }
}
