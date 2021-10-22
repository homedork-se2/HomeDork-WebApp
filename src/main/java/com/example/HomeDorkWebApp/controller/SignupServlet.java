package com.example.HomeDorkWebApp.controller;

import com.example.HomeDorkWebApp.model.UserFirebase;
import com.example.HomeDorkWebApp.service.UserSignupService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignupServlet", value = "/SignupServlet")
public class SignupServlet extends HttpServlet {
    private UserSignupService signupService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        signupService = new UserSignupService();
        UserFirebase userFirebase = signupService.signUp(email, password);
        signupService.validateSignUp(userFirebase, response);
    }
}
