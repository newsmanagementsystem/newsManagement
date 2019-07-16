package com.seven.service.news;

import java.util.List;

import com.seven.entity.News;

public interface newsService {
    //根据themeId查找新闻的数量
    public int getNewsCountBythemeId(int themeId);
    //查询所有新闻
    public List<News> selectAllNews();
    //根据主题查询新闻
    public List<News> findAllNewsByThemeId(int themeId);
}
