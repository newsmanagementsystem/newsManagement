package com.seven.service.news;

import java.util.List;

import com.seven.dao.NewsDao;
import com.seven.dao.NewsDaoImpl;
import com.seven.entity.News;
import com.seven.entity.PageBean;

public class newsServiceImpl implements newsService {
	@Override
	public int getNewsCountBythemeId(int themeId) {
		// 创建数据访问层对象
		NewsDao newsDaoObject = new NewsDaoImpl();

		// 执行根据themeId查询新闻数量的方法并返回
		return newsDaoObject.getNewsCountBythemeId(themeId);
	}

	@Override
	public List<News> selectAllNews() {
		// 创建数据访问层对象
		NewsDao newsDaoObject = new NewsDaoImpl();

		// 执行查询
		List<News> allNews = newsDaoObject.findAllNews();
		return allNews;
	}

	@Override
	public List<News> findAllNewsByThemeId(int themeId) {
		// 创建数据访问层对象
		NewsDao newsDaoObject = new NewsDaoImpl();

		// 执行查询
		List<News> allNews = newsDaoObject.findAllNewsByThemeId(themeId);
		return allNews;
	}

	@Override
	public News findNewsByTitle(String newsTitle) {
		// 创建数据访问层对象
		NewsDao newsDaoObject = new NewsDaoImpl();

		// 执行查询
		News aNews = newsDaoObject.findNewsByTitle(newsTitle);
		return aNews;
	}

	// service层增加数据
	@Override
	public void addNews(News news) {
		NewsDao newsDaoObject = new NewsDaoImpl();
		newsDaoObject.addNews(news);
	}

	// 安装新闻id查找新闻
	public News findNewsById(int nid) {
		NewsDao newsDaoObject = new NewsDaoImpl();
		return newsDaoObject.findNewsById(nid);
	}

	// update新闻
	@Override
	public int updateNews(News news) {
		NewsDao newsDaoObject = new NewsDaoImpl();
		return newsDaoObject.updateNews(news);
	}

	// 按照id删除新闻
	public int deleteNewsById(int nid) {
		NewsDao newsDaoObject = new NewsDaoImpl();
		return newsDaoObject.deleteNews(nid);
	}

	// 分页
	public PageBean<News> getPageBean(int currentPage, int pageSize) {
		NewsDao newsDaoObject = new NewsDaoImpl();
		// 先得到总的记录数
		int totalCount = newsDaoObject.getNewsCount();
		PageBean<News> pageBean = new PageBean<>(currentPage, pageSize, totalCount);
		pageBean.setList(newsDaoObject.getNewsListSplit(pageBean.getStartRow(), pageBean.getPageSize()));
		return pageBean;
	}

}
