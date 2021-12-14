package com.example.HomeDorkWebApp.controller;

import com.example.HomeDorkWebApp.api.*;
import com.example.HomeDorkWebApp.service.FanRequestService;
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
        AlarmRepository alarmRepository = new AlarmRepository();
        CurtainRepository curtainRepository = new CurtainRepository();
        ThermometerRepository thermometerRepository = new ThermometerRepository();
        WindowRepository windowRepository = new WindowRepository();
        FanRequestService fanRequestService = new FanRequestService();



        ArrayList<String> lampIDs = lampRequestService.getLamp("123");
             /*
            ArrayList<String> alarmIDs = (ArrayList<String>) alarmRepository.getAlarms("123");
            ArrayList<String> curtainIds = (ArrayList<String>) curtainRepository.getCurtains("123");
            ArrayList<String> thermometerIDs = (ArrayList<String>) thermometerRepository.getThermometers("123");
            ArrayList<String> windowIDs = (ArrayList<String>) windowRepository.getWindows("123");
            ArrayList<String> fanIDs = fanRequestService.getFans("123");


            System.out.println(lampIDs);

            request.setAttribute("alarmIds", alarmIDs);
            request.setAttribute("curtainIds", curtainIds);
            request.setAttribute("thermoIds", thermometerIDs);
            request.setAttribute("windowIds", windowIDs);
            request.setAttribute("fanIds", fanIDs);

              */


        request.setAttribute("lampIds", lampIDs);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("hello");
        arrayList.add("helsaddaslo");
        arrayList.add("helasdadasdadalo");
        System.out.println(arrayList);

        request.setAttribute("dateEvents", arrayList);


        getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);

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
        lampRequestService.changeValueLamp("123",request.getParameter("value"),request.getParameter("id"));

    }
}
