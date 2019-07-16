package com.seven.service.news;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seven.entity.News;

/**
 * Servlet implementation class addNewsServlet
 */
public class addNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addNewsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 设置字符编码
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("gb2312");
			System.out.println("进来了*****************************");
			// 新建一个实体News 慢慢往里加数据数据 最后调用service保存就可可以了
			News news = new News();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			String ceateDate = df.format(new Date());
			Date createDate_Date = df.parse(ceateDate);
			String ntid = request.getParameter("ntid");
			System.out.println(ntid);
			String title = request.getParameter("ntitle");
			String author = request.getParameter("nauthor");
			String summary = request.getParameter("nsummary");
			String content = request.getParameter("ncontent");
			String picPath = request.getParameter("file");
			
			news.setThemeId(Integer.parseInt(ntid));
			news.setNewsTitle(title);
			news.setNewsAuthor(author);
			news.setNewsSummary(summary);
			news.setNewsContent(content);
			news.setNewsPicpath(picPath);
			news.setNewsCreatedate(createDate_Date);
			news.setNewsModifydate(createDate_Date);

			System.out.println(news.toString());

			// 这里调用service方法保存
			newsService newsService = new newsServiceImpl();
			newsService.addNews(news);
			// 这里再做跳转操作
			request.getRequestDispatcher("listNewsServlet").forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}
