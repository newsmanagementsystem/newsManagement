package com.seven.controller.news;

import com.seven.service.news.newsService;
import com.seven.service.news.newsServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteNewsServlet
 */
public class DeleteNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteNewsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("gb2312");

		// 获取传递的参数
		int nid = Integer.parseInt(request.getParameter("nid"));
		System.out.println("nid:" + nid);

		// 用于保存当前路径
		String contextPath = request.getContextPath();
		// 创建out对象
		PrintWriter out = response.getWriter();
		// 创建业务逻辑层对象
		newsService newsService = new newsServiceImpl();

		try {
			// 删除指定的主题
			int result = newsService.deleteNewsById(nid);
			System.out.println("result:" + result);
			if (result == 1) {
				request.setAttribute("success", "删除成功！");
				System.out.println("删除成功！");
				out.print("<script type=\"text/javascript\">");
				out.print("alert(\"删除成功！success\");");
				out.print("location.href=\"" + contextPath + "/listNewsServlet\";");
				out.print("</script>");
				System.out.println("成功===============================================");

			} else {
				request.setAttribute("error", "删除失败！");
				System.out.println("删除失败！");
				out.print("<script type=\"text/javascript\">");
				out.print("alert(\"删除失败！success\");");
				out.print("location.href=\"" + contextPath + "/listNewsServlet\";");
				out.print("</script>");
				System.out.println("失败===============================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
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
