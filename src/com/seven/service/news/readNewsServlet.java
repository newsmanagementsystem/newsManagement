package com.seven.service.news;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seven.entity.News;

/**
 * Servlet implementation class readNewsServlet
 */
public class readNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//测试
		System.out.println("开始读新闻了");
		//获取传递的参数
		String newsTitle = request.getParameter("newsTitle");
		
		//创建业务逻辑层对象
		newsService newsServiceObject = new newsServiceImpl();
		
		//执行查询
		News aNews = newsServiceObject.findNewsByTitle(newsTitle);
		
		//将结果写入到Session中
		HttpSession session = request.getSession();
		session.setAttribute("news", aNews);
		
		response.sendRedirect(request.getContextPath() + "/newsRead.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
