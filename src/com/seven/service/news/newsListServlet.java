package com.seven.service.news;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seven.entity.News;

/**
 * Servlet implementation class newsListServlet
 */
public class newsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//测试
		System.out.println("开始列出新闻列表下的新闻了");
		
		//获取传递的参数
		String themeId = request.getParameter("themeID");
		int themeId_int = Integer.valueOf(themeId);
		
		//创建业务逻辑层对象
		newsService newsServiceObject = new newsServiceImpl();
		
		//执行查询
		List<News> newsList = newsServiceObject.findAllNewsByThemeId(themeId_int);
		
		//将数据添加到Session中
		HttpSession session = request.getSession();
		session.setAttribute("newsList", newsList);
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
