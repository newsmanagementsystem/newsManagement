package com.seven.service.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seven.entity.News;
import com.seven.entity.Theme;
import com.seven.service.theme.themeService;
import com.seven.service.theme.themeServiceImpl;

/**
 * Servlet implementation class ToNewsEditServlet
 */
public class ToNewsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToNewsEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//把所有主题加载出来
    	List<Theme> themeList = new ArrayList<Theme>();
		themeService themeServiceObject = new themeServiceImpl();
		themeList = themeServiceObject.findAllThemes();
		request.setAttribute("themeList", themeList);

		newsService newsService = new newsServiceImpl();
		int nid = Integer.parseInt(request.getParameter("nid"));
		News news = newsService.findNewsById(nid);
		request.setAttribute("news", news);
		request.getRequestDispatcher("admin/newsModify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
