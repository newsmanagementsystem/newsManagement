package com.seven.service.news;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seven.entity.News;

/**
 * Servlet implementation class UpdateNewsServlet
 */
public class UpdateNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateNewsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("gb2312");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String nowDate = df.format(new Date());
		Date nowDate_date = null;
		try {
			nowDate_date = df.parse(nowDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		News news = new News();
		news.setNewsId(Integer.parseInt(request.getParameter("nid")));
		news.setThemeId(Integer.parseInt(request.getParameter("ntid")));
		news.setNewsAuthor(request.getParameter("nauthor"));
		news.setNewsTitle(request.getParameter("ntitle"));
		news.setNewsSummary(request.getParameter("nsummary"));
		news.setNewsContent(request.getParameter("ncontent"));
		news.setNewsPicpath(request.getParameter("file"));
		news.setNewsModifydate(nowDate_date);
		// 用于保存当前路径
		String contextPath = request.getContextPath();
		// 创建out对象
		PrintWriter out = response.getWriter();
		// 创建业务逻辑层对象

		newsService newsService = new newsServiceImpl();

		try {
			int result = newsService.updateNews(news);
			System.out.println("result:" + result);
			if (result == 1) {
				request.setAttribute("success", "修改成功！");
				System.out.println("修改成功！");
				out.print("<script type=\"text/javascript\">");
				out.print("alert(\"修改成功！success\");");
				out.print("location.href=\"" + contextPath + "/listNewsServlet\";");
				out.print("</script>");
				return;
			} else {
				request.setAttribute("error", "修改失败！");
				System.out.println("修改失败！");
				out.print("<script type=\"text/javascript\">");
				out.print("alert(\"修改失败！fail\");");
				out.print("location.href=\"" + contextPath + "/listNewsServlet\";");
				out.print("</script>");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

}
