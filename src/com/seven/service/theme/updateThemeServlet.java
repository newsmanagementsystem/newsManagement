package com.seven.service.theme;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seven.entity.Theme;

/**
 * Servlet implementation class updateThemeServlet
 */
public class updateThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateThemeServlet() {
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
		
		// 获取用户修改的主题名称和ID
		String themeName = request.getParameter("themeName");
		String themeID = request.getParameter("themeID");

		// 转换ID的类型
		int themeID_int = Integer.valueOf(themeID);

		// 用于保存当前路径
		String contextPath = request.getContextPath();

		// 创建out对象
		PrintWriter out = response.getWriter();
		
		// 创建业务逻辑层对象
		themeService themeServiceObject = new themeServiceImpl();

		// 创建一个主题实体对象
		Theme theme = new Theme();
		theme.setThemeID(themeID_int);
		theme.setThemeName(themeName);

		try {
			int result = themeServiceObject.updateTheme(theme);
			System.out.println("result:" + result);
			if (result == 1) {
				request.setAttribute("success", "修改成功！");
				System.out.println("修改成功！");
				out.print("<script type=\"text/javascript\">");
	            out.print("alert(\"修改成功！success\");");
	            out.print("location.href=\"" + contextPath
	                    + "/listThemeServlet\";");
	            out.print("</script>");
				return;
			}
			else {
				request.setAttribute("error", "修改失败！");
				System.out.println("修改失败！");
				out.print("<script type=\"text/javascript\">");
	            out.print("alert(\"修改失败！fail\");");
	            out.print("location.href=\"" + contextPath
	                    + "/listThemeServlet\";");
	            out.print("</script>");
	            
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			out.flush();
            out.close();
		}
	}

}
