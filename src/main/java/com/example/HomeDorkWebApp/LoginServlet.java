package com.example.HomeDorkWebApp;

import com.example.HomeDorkWebApp.model.User;
import com.example.HomeDorkWebApp.service.UserLoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private  UserLoginService userLoginService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> messages = new HashMap<>();
        request.setAttribute("messages", messages);
        userLoginService = new UserLoginService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+"  "+password);
        User user = userLoginService.loginAuthentication(username, password);
        if (user != null){
            HttpSession session =  userLoginService.sessionValidate(user, request);
            response.sendRedirect("welcome.jsp");
        }else {
            messages.put("index", "Incorrect password or username... please try again");
            response.sendRedirect("index.jsp");
        }
    }
}
