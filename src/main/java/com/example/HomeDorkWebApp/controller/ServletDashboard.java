package com.example.HomeDorkWebApp.controller;

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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("value")+" "+request.getParameter("id"));
        LampRequestService lampRequestService = new LampRequestService();
      lampRequestService.changeValueLamp("123",request.getParameter("value"),request.getParameter("id"));

    }
}
