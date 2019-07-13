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
        //��ȡ��������
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();  
        boolean exist;
        try {
        	exist = userService.checkUserNameIsExit(username);
        	//�ж��û��Ƿ����
            if(exist) {
            	//��ѯ���ݿ��û�
            	user = userService.getUserByUserName(username);
            	//����½���û�����ӵ�Session��
            	request.getSession().setAttribute("login",user.getUserName());
            	System.out.println("����+"+username);
            }else {
            	//�û�������
            	user.setUserName("");
//            	System.out.println("������+"+username);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//        System.out.println(""+new Gson().toJson(user));
        response.getWriter().write(new Gson().toJson(user));
	}

}
