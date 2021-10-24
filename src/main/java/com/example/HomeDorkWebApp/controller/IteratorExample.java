package com.example.HomeDorkWebApp.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IteratorExample extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside Servlet");

        String type = request.getParameter("type");

        if(type.equals("getDetails"))
        {

            UserDetails empDetails = new UserDetails(0, 0, type);

            empDetails.getEmployeeDetails();

            request.setAttribute("userList", empDetails.getEmployeeDetails());

            request.getRequestDispatcher("Iterator.jsp").forward(request, response);
        }
    }
}