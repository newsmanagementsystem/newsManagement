package com.seven.dao;

import java.util.ArrayList;
import java.util.List;

import com.seven.entity.News;

public interface NewsDao {

	// 添加新闻
	public int addNews(News news);

	// 检查该标题的新闻是否存在
	public boolean checkNewsIfExist(String newsTitle);

	// 获取所有新闻
	public List<News> findAllNews();

	// 查找某主题下的所有新闻
	public List<News> findAllNewsByThemeId(int themeId);

	// 更新新闻
	public int updateNews(News news);

	// 根据新闻标题查找新闻
	public News findNewsByTitle(String title);

	// 根据新闻id查找新闻
	public News findNewsById(int nid);

	// 通过nid删除新闻
	public int deleteNews(int nid);

	// 根据themeId查找新闻的数量
	public int getNewsCountBythemeId(int themeId);

	// 查找新闻的总数
	public int getNewsCount();

	// 分页查找新闻数据
	public ArrayList<News> getNewsListSplit(int startRow, int pageSize);
}
