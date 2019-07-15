package com.seven.service.news;

import com.google.gson.Gson;
import com.seven.service.UserService;
import com.seven.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class getNewsCountServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int themeID = Integer.parseInt(req.getParameter("themeID"));
        // 创建业务逻辑层对象
        newsService newsServiceObject = new newsServiceImpl();
        // 查询该主题下是否具有新闻
        int newsCount=newsServiceObject.getNewsCountBythemeId(themeID);
        // 该主题下没有相关新闻则返回0
        Gson gson = new Gson();
        Map<String,Integer> map=new HashMap<>();
        map.put("msg",newsCount);
        System.out.println("map:"+ gson.toJson(map));
        resp.getWriter().print(gson.toJson(map));
    }
}
