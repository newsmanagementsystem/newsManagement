package service.theme;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		//获取添加主题表单的参数
		String themeName = request.getParameter("themename");
		
		//创建一个Theme对象用于存放主题信息
		Theme theme = new Theme();
		theme.setThemeName(themeName);
		
		//创建一个变量用于存放判断的结果
		boolean themeIfExist = false;
		
		//创建业务逻辑层对象
		themeService themeServiceObject = new themeServiceImpl();
		
		try {
			themeIfExist = themeServiceObject.checkThemeIfExist(themeName);
			if (themeIfExist) {
				request.setAttribute("result", "主题已存在！");
				System.out.println("主题已存在！");
			} else {
				themeServiceObject.addTheme(theme);
				request.setAttribute("result", "主题已保存！");
				System.out.println("主题已保存！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.sendRedirect("admin/themeAdd.jsp");
	}

}
