package com.seven.service.news;

import java.util.List;

import com.seven.entity.News;
import com.seven.entity.PageBean;

public interface newsService {
    //根据themeId查找新闻的数量
    public int getNewsCountBythemeId(int themeId);
    //查询所有新闻
    public List<News> selectAllNews();
    //根据主题查询新闻
    public List<News> findAllNewsByThemeId(int themeId);
    //根据标题查找新闻
    public News findNewsByTitle(String newsTitle);
  //service层增加数据
    public void addNews(News news);
    //按照新闻id查找新闻
    public News findNewsById(int nid);
    //按照id删除新闻
    public int deleteNewsById(int nid);
    //update新闻
    public int updateNews(News news);
    //分页
    public PageBean<News> getPageBean(int cuurrentPage,int pageSize);
}
