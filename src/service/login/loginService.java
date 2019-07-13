package service.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entity.User;
import service.UserServiceImpl;

/**
 * Servlet implementation class loginService
 */
public class loginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginService() {
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
		UserServiceImpl userService = new UserServiceImpl();
		User user = new User();
        response.setContentType("text/html;charset=UTF-8");
        //获取用户表单参数
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();  
        boolean exist;
        try {
        	exist = userService.checkUserNameIsExit(username);
        	//根据判断结果进行决定是否添加用户
            if(exist) {
            	//查询用户
            	user = userService.getUserByUserName(username);
            	//将用户名写入到Session中
            	request.getSession().setAttribute("login",user.getUserName());
            	System.out.println("登陆成功+"+username);
            }else {
            	//�û�������
            	user.setUserName("");
//            	System.out.println("登陆成功+"+username);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//        System.out.println(""+new Gson().toJson(user));
        response.getWriter().write(new Gson().toJson(user));
	}

}
