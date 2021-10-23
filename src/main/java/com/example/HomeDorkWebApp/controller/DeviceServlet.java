package com.example.HomeDorkWebApp.controller;

import com.example.HomeDorkWebApp.model.Fan;
import com.example.HomeDorkWebApp.model.Lamp;
import com.example.HomeDorkWebApp.model.User;
import com.example.HomeDorkWebApp.service.DeviceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeviceServlet", value = "/DeviceServlet")
public class DeviceServlet extends HttpServlet {
    private List<Lamp> lamps;
    private List<Fan> fans;
    private User user;
    private DeviceService deviceService= new DeviceService();
    @Override
    public void init() throws ServletException{
         String localID=  LoginServlet.userFirebase.getLocalId();
        System.out.println( LoginServlet.userFirebase.getLocalId());
        if(LoginServlet.userFirebase.getLocalId()!=null){
            lamps= deviceService.listLamps(localID);
            fans= deviceService.listFans(localID);


        }else{}

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clickedButton= request.getParameter("b1");

        request.setAttribute("val", clickedButton);

        request.getRequestDispatcher("test.jsp").forward(request, response);
    }
}
