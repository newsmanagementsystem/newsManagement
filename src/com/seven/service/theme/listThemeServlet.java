package com.seven.service.theme;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seven.entity.Theme;

/**
 * Servlet implementation class listThemeServlet
 */
public class listThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listThemeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//用于存放所有主题
		List<Theme> themeList = new ArrayList<Theme>();
		
		//创建业务逻辑层对象
		themeService themeServiceObject = new themeServiceImpl();
		
		try {
			themeList = themeServiceObject.findAllThemes();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("themeList", themeList);
		//转发页面
		request.getRequestDispatcher("/admin/themeList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
