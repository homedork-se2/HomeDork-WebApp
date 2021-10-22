package com.example.HomeDorkWebApp.service;

import com.example.HomeDorkWebApp.apiRepo.UserLoginRepository;
import com.example.HomeDorkWebApp.model.SignInResponse;
import com.example.HomeDorkWebApp.model.UserFirebase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserLoginService {
    private UserLoginRepository userLoginRepository;


    public UserFirebase loginAuthentication(String username, String password){
        userLoginRepository = new UserLoginRepository();
        SignInResponse signInResponse = userLoginRepository.userLogin(username, password);
        if (signInResponse.getIdToken() == null){
            return null;
        }
        return new UserFirebase(signInResponse.getDisplayName(), signInResponse.getEmail(), signInResponse.getIdToken());

    }

    public void fillUserInfo(){

    }

    public HttpSession sessionValidate(UserFirebase userFirebase, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("email", userFirebase.getEmail());
        return session;

    }
}
