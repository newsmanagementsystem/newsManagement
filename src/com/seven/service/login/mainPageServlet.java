package com.seven.service.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seven.entity.News;
import com.seven.entity.Theme;
import com.seven.service.news.newsService;
import com.seven.service.news.newsServiceImpl;
import com.seven.service.theme.themeService;
import com.seven.service.theme.themeServiceImpl;

/**
 * Servlet implementation class mainPageServlet
 */
public class mainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public mainPageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("mainpage");
		// 查询主题信息
		themeService themeServiceObject = new themeServiceImpl();

		List<Theme> themeList = themeServiceObject.findAllThemes();
		request.setAttribute("themeList", themeList);

		// 查询新闻信息
		newsService newsServiceObject = new newsServiceImpl();

		List<News> newsList = newsServiceObject.selectAllNews();
//		for (News news : newsList) {
//			System.out.println("newsTitle" + news.getNewsTitle());
//		}
		request.setAttribute("newsList", newsList);

		// 查询主题信息
		List<News> chinaNewsList = newsServiceObject.findAllNewsByThemeId(1);
		request.setAttribute("chinaNewsList", chinaNewsList);
		List<News> intelNewsList = newsServiceObject.findAllNewsByThemeId(2);
		request.setAttribute("intelNewsList", intelNewsList);
		List<News> playNewsList = newsServiceObject.findAllNewsByThemeId(5);
		request.setAttribute("playNewsList", playNewsList);
		
		// 返回页面
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
