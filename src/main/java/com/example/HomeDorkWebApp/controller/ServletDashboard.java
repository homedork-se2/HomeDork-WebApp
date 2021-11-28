package com.example.HomeDorkWebApp.controller;

import com.example.HomeDorkWebApp.api.LampRepository;
import com.example.HomeDorkWebApp.service.LampRequestService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(name = "ServletDashboard", value = "/ServletDashboard")
public class ServletDashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LampRequestService lampRequestService = new LampRequestService();
        ArrayList<String> lampIDs = lampRequestService.getLamp("123");
        System.out.println(lampIDs);
        request.setAttribute("ids", lampIDs);
        response.sendRedirect("dashboard.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LampRepository lampRepository = new LampRepository();
        String toggleValue = request.getParameter("toggleValue");
        String toggleId = request.getParameter("toggleId");
        if (toggleValue != null){
            if (toggleValue.equals("true")) {
                lampRepository.turnOnLamp("7IT6aTO2cThiDAOpHshvX9e8z9t1", toggleId);
            }else {
                lampRepository.turnOfLamp("7IT6aTO2cThiDAOpHshvX9e8z9t1", toggleId);
            }
        }



        if (request.getParameter("sliderValue")!= null) {
            System.out.println(request.getParameter("sliderValue") + " " + request.getParameter("sliderId"));
        }
        LampRequestService lampRequestService = new LampRequestService();
     // lampRequestService.changeValueLamp("123",request.getParameter("value"),request.getParameter("id"));

    }
}
