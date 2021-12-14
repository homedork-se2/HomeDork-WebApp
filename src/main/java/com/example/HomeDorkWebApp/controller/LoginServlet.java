package com.example.HomeDorkWebApp.controller;

import com.example.HomeDorkWebApp.api.AlarmRepository;
import com.example.HomeDorkWebApp.api.CurtainRepository;
import com.example.HomeDorkWebApp.api.ThermometerRepository;
import com.example.HomeDorkWebApp.api.WindowRepository;
import com.example.HomeDorkWebApp.model.Curtain;
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
import java.util.List;
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

            LampRequestService lampRequestService = new LampRequestService();
            AlarmRepository alarmRepository = new AlarmRepository();
            CurtainRepository curtainRepository = new CurtainRepository();
            ThermometerRepository thermometerRepository = new ThermometerRepository();
            WindowRepository windowRepository = new WindowRepository();
            FanRequestService fanRequestService = new FanRequestService();

            ArrayList<String> lampIDs = lampRequestService.getLamp("123");

            /*
             ArrayList<String> alarmIDs = (ArrayList<String>) alarmRepository.getAlarms("123");
            ArrayList<String> alarmIDs = (ArrayList<String>) alarmRepository.getAlarms("123");
            ArrayList<String> curtainIds = (ArrayList<String>) curtainRepository.getCurtains("123");
            ArrayList<String> thermometerIDs = (ArrayList<String>) thermometerRepository.getThermometers("123");
            ArrayList<String> windowIDs = (ArrayList<String>) windowRepository.getWindows("123");
            ArrayList<String> fanIDs = fanRequestService.getFans("123");
            System.out.println(lampIDs);


            request.setAttribute("curtainIds", curtainIds);
            request.setAttribute("thermomds", thermometerIDs);
            request.setAttribute("windowIds", windowIDs);
            request.setAttribute("fanIds", fanIDs);

             */
            request.setAttribute("lampIds", lampIDs);



            getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);


        }else {
            messages.put("index", "Incorrect password or username... please try again");
            response.sendRedirect("index.jsp");
        }

    }
}
