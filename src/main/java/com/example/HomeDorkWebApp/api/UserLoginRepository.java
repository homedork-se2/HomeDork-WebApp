package com.example.HomeDorkWebApp.api;

import com.example.HomeDorkWebApp.model.SignInResponse;
import com.example.HomeDorkWebApp.model.User;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.List;

public class UserLoginRepository {
    private final String apikey = "AIzaSyB2mndyKz8ozmroAGsUiKRdrnB2-azxYyY";
    public String urlCompletion;


    public SignInResponse userLogin(String email, String password){
        urlCompletion = "{\"email\":\""+email+"\",\"password\":\""+password+"\",\"returnSecureToken\":true}\n";

        SignInResponse signInResponse = Unirest.post("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key="+apikey)
                .body(urlCompletion).asObject(SignInResponse.class).getBody();

        System.out.println(signInResponse);
        return signInResponse;

    }

    public void getUserData(SignInResponse signInResponse){
        String urlCompletion = "{\"idToken\":\""+signInResponse.getIdToken()+"\"}\n";
        List<User> users = Unirest.post("https://identitytoolkit.googleapis.com/v1/accounts:lookup?key="+apikey)
                .body(urlCompletion)
                .asObject(new GenericType<List<User>>() {
                }).getBody();

    }
}
