package com.example.HomeDorkWebApp.service;

import com.example.HomeDorkWebApp.apiRepo.UserLoginRepository;
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
        return new User(signInResponse.getDisplayName(), signInResponse.getEmail(), signInResponse.getIdToken());

    }

    public void fillUserInfo(){

    }

    public HttpSession sessionValidate(User user, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("email", user.getEmail());
        return session;

    }
}
