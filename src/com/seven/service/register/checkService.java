package com.seven.service.register;

import com.google.gson.Gson;
import com.seven.service.UserService;
import com.seven.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zkx
 * Date: 2019/7/13
 * Time: 11:27
 * Description: No Description
 */
public class checkService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        UserService userService = new UserServiceImpl();
        try {
            boolean userNameIsExit = userService.checkUserNameIsExit(userName);
            Map<String,String> map=new HashMap<>();
            if (userNameIsExit != true) {
                map.put("msg","1");
            } else {
                map.put("msg","2");
            }
            Gson gson = new Gson();
            System.out.println("map:"+ gson.toJson(map));
            resp.getWriter().print(gson.toJson(map));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
