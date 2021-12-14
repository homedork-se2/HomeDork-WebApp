package com.example.HomeDorkWebApp.service;

import com.example.HomeDorkWebApp.api.UserLoginRepository;
import com.example.HomeDorkWebApp.model.SignInResponse;
import com.example.HomeDorkWebApp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserLoginService {
    private UserLoginRepository userLoginRepository;


    public User loginAuthentication(String username, String password){
        userLoginRepository = new UserLoginRepository();
        SignInResponse signInResponse = userLoginRepository.userLogin(username, password);
        if (signInResponse.getIdToken() == null){
            return null;
        }
        System.out.println("PRINTING SIGNInRESPONSE: \n"+signInResponse);
        return new User(signInResponse.getDisplayName(), signInResponse.getEmail(), signInResponse.getLocalId());

    }

    public void fillUserInfo(){

    }

    public HttpSession sessionValidate(User user, HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println("PRINTING SESSION DATA: \n"+user.getLocalId());
        session.setAttribute("email", user.getLocalId());
        return session;

    }
}
