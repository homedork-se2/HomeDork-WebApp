package com.example.HomeDorkWebApp.service;

import com.example.HomeDorkWebApp.apiRepo.UserSignupRepository;
import com.example.HomeDorkWebApp.model.SignupResponse;
import com.example.HomeDorkWebApp.model.UserFirebase;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserSignupService {

    private UserSignupRepository userSignupRepository;

    public UserFirebase signUp(String email, String password){
        userSignupRepository = new UserSignupRepository();
        SignupResponse signInResponse = userSignupRepository.userSignup(email, password);
        if (signInResponse.getIdToken() == null){
            return null;
        }else {
            return new UserFirebase("", signInResponse.getEmail(), signInResponse.getIdToken());
        }

    }

    public void validateSignUp(UserFirebase userFirebase, HttpServletResponse response) throws IOException {
        if (userFirebase.getTokenId() == null){

           response.sendRedirect("signup.jsp");
        }else {
                response.sendRedirect("index.jsp");
        }
    }
}
