package com.seven.service.news;

import com.seven.dao.NewsDao;
import com.seven.dao.NewsDaoImpl;


public class newsServiceImpl implements newsService{
    @Override
    public int getNewsCountBythemeId(int themeId) {
        //创建数据访问层对象
        NewsDao newsDaoObject = new NewsDaoImpl();

        //执行根据themeId查询新闻数量的方法并返回
        return newsDaoObject.getNewsCountBythemeId(themeId);
    }
}
