package com.example.HomeDorkWebApp.controller;

import com.example.HomeDorkWebApp.api.*;
import com.example.HomeDorkWebApp.model.User;
import com.example.HomeDorkWebApp.service.FanRequestService;
import com.example.HomeDorkWebApp.service.LampRequestService;
import com.example.HomeDorkWebApp.service.UserLoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private User user;
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
        user = userLoginService.loginAuthentication(username, password);
        System.out.println(user.getLocalId());
        if (user != null){
            HttpSession session =  userLoginService.sessionValidate(user, request);
            String sessionId = (String) session.getAttribute("email");
            System.out.println(sessionId +" <-------------------- CODE BRO");
            LampRequestService lampRequestService = new LampRequestService();
            AlarmRepository alarmRepository = new AlarmRepository();
            CurtainRepository curtainRepository = new CurtainRepository();
            ThermometerRepository thermometerRepository = new ThermometerRepository();
            WindowRepository windowRepository = new WindowRepository();
            FanRequestService fanRequestService = new FanRequestService();
            FanRepostiory fanRepostiory = new FanRepostiory();

            ArrayList<String> lampIDs = lampRequestService.getLamp(sessionId);



            ArrayList<String> alarmIDs = (ArrayList<String>) alarmRepository.getAlarms(sessionId);
            ArrayList<String> curtainIds = (ArrayList<String>) curtainRepository.getCurtains(sessionId);
            ArrayList<String> thermometerIDs = (ArrayList<String>) thermometerRepository.getThermometers(sessionId);
            ArrayList<String> windowIDs = (ArrayList<String>) windowRepository.getWindows(sessionId);
            ArrayList<String> fanIDs = (ArrayList<String>) fanRepostiory.getFans(sessionId);



            request.setAttribute("curtainIds", curtainIds);
            request.setAttribute("thermIds", thermometerIDs);
            request.setAttribute("windowIds", windowIDs);
            request.setAttribute("fanIds", fanIDs);
            request.setAttribute("alarmIds", alarmIDs);
            request.setAttribute("lampIds", lampIDs);



            getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);


        }else {
            messages.put("index", "Incorrect password or username... please try again");
            response.sendRedirect("index.jsp");
        }

    }
}
