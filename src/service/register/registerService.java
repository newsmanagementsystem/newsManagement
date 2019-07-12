package service.register;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.UserService;
import service.UserServiceImpl;

/**
 * Servlet implementation class registerService
 */
public class registerService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerService() {
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String date = req.getParameter("date");
        System.out.println(date);
        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            UserService userService = new UserServiceImpl();
            User user = new User(userName, sex, passWord, email,date1);
            boolean userNameIsExit = false;
            userNameIsExit = userService.checkUserNameIsExit("userName");
            if (userNameIsExit) {
                
                req.setAttribute("succ", "error");
                System.out.println("用户名已存在！");
            } else {
            	userService.addUser(user);
                req.setAttribute("succ", "success");
                System.out.println("添加成功！");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("regis.jsp");
	}

}
