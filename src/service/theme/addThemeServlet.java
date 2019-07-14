package service.theme;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entity.Theme;

/**
 * Servlet implementation class addThemeServlet
 */
public class addThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addThemeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("gb2312");
		
		//获取添加主题表单的参数
		String themeName = request.getParameter("themename");
		System.out.println("themename" + themeName);
		
		//创建一个Theme对象用于存放主题信息
		Theme theme = new Theme();
		theme.setThemeName(themeName);
		
		//用于保存当前路径
		String contextPath = request.getContextPath();
		
		//创建out对象
		PrintWriter out = response.getWriter();
		
		//创建一个变量用于存放判断的结果
		boolean themeIfExist = false;
		
		//创建业务逻辑层对象
		themeService themeServiceObject = new themeServiceImpl();
		
		//用于返回JSON对象
//		Map<String, String> map = new HashMap<String,String>();
		
		try {
			themeIfExist = themeServiceObject.checkThemeIfExist(themeName);
			if (themeIfExist) {
				System.out.println("主题已存在！");
				out.print("<script type=\"text/javascript\">");
                out.print("alert(\"主题已存在！Exist Theme！\");");
                out.print("location.href=\"" + contextPath
                        + "/listThemeServlet\";");
                out.print("</script>");
			} else {
				themeServiceObject.addTheme(theme);
				System.out.println("主题已保存！");
				out.print("<script type=\"text/javascript\">");
                out.print("alert(\"主题已保存！\");");
                out.print("location.href=\"" + contextPath
                        + "/listThemeServlet\";");
                out.print("</script>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			out.flush();
			out.close();
		}
		
//		Gson gson = new Gson();
//		System.out.println("json:" + gson.toJson(map));
//		response.getWriter().write(gson.toJson(map));
//		response.sendRedirect("admin/themeAdd.jsp");
	}

}
