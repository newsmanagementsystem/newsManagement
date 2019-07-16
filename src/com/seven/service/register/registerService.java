package com.seven.service.register;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.seven.entity.User;
import com.seven.service.UserService;
import com.seven.service.UserServiceImpl;


public class registerService extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String  date = req.getParameter("date");
        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            UserService userService = new UserServiceImpl();
            User user = new User(userName, sex, passWord, email, date1);
            System.out.println("userName:"+userName);
            boolean userNameIsExit = userService.checkUserNameIsExit(userName);
            Gson gson = new Gson();
            if(userNameIsExit!=true){
                userService.addUser(user);
//                req.getSession().setAttribute("login",user.getUserName());
//                req.getRequestDispatcher("index.jsp").forward(req,resp);
                resp.sendRedirect(req.getContextPath()+"/index.jsp");
            }else{
                resp.sendRedirect("regis.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
