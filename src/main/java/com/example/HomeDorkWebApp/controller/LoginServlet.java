package com.example.HomeDorkWebApp.controller;

import com.example.HomeDorkWebApp.model.UserFirebase;
import com.example.HomeDorkWebApp.service.UserLoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
  /*
    public UserFirebase getUserFirebase() {
        return userFirebase;
    }

    public void setUserFirebase(UserFirebase userFirebase) {
        this.userFirebase = userFirebase;
    }

    public UserLoginService getUserLoginService() {
        return userLoginService;
    }

    public void setUserLoginService(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }


   */
    public static UserFirebase userFirebase;




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
        userFirebase= userLoginService.loginAuthentication(username, password);
        System.out.println(username+"  "+password);

        if (userFirebase != null){
            HttpSession session =  userLoginService.sessionValidate(userFirebase, request);
            response.sendRedirect("welcome.jsp");
        }else {
            messages.put("index", "Incorrect password or username... please try again");
            response.sendRedirect("index.jsp");
        }
    }
}
