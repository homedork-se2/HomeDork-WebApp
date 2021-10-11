package com.example.HomeDorkWebApp.service;

import com.example.HomeDorkWebApp.apiRepo.UserSignupRepository;
import com.example.HomeDorkWebApp.model.SignInResponse;
import com.example.HomeDorkWebApp.model.SignupResponse;
import com.example.HomeDorkWebApp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserSignupService {

    private UserSignupRepository userSignupRepository;

    public User signUp(String email, String password){
        userSignupRepository = new UserSignupRepository();
        SignupResponse signInResponse = userSignupRepository.userSignup(email, password);
        if (signInResponse.getIdToken() == null){
            return null;
        }else {
            return new User("", signInResponse.getEmail(), signInResponse.getIdToken());
        }

    }

    public void validateSignUp(User user, HttpServletResponse response) throws IOException {
        if (user.getTokenId() == null){

           response.sendRedirect("signup.jsp");
        }else {
                response.sendRedirect("index.jsp");
        }
    }
}
