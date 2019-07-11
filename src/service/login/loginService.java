package service.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		User user;
		boolean exist = false;
        request.setCharacterEncoding("UTF-8");
        
        //��ȡ��������,��ȥ���ո�
        String name = request.getParameter("username").trim();
        String pwd = request.getParameter("upwd").trim();
        
        try {
        	exist = userService.checkUserNameIsExit(name);
        	
        	//�ж��û��Ƿ����
            if(exist) {
            	//��ѯ���ݿ��û�
            	user = userService.getUserByUserName(name);
            	
            	//����½���û�����ӵ�Session��
            	request.getSession().setAttribute("login",user.getUserName());
            	
            	//�ж��û��Ƿ��ǹ���Ա������ͨ�û�
            	if(user.getUserFlag()==1 && user.getUserPassword().equals(pwd)) {
            		response.sendRedirect(request.getContextPath()+"/admin/admin.jsp");
            	}else {
            		response.sendRedirect(request.getContextPath()+"/index.jsp");
            	}
            }else {
            	response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
