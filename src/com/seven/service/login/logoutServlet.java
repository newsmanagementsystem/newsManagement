package com.seven.service.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logoutServlet
 */
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("退出的Servlet进去了");
		// 设置字符编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("gb2312");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		//获取Session对象
		HttpSession session = request.getSession(true);
		
		//让Session过期
		session.invalidate();
		
		//给出退出提示
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
//		request.getRequestDispatcher("/index.jsp").forward(request, response);

        //清空缓冲区并退出
        out.flush();
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
