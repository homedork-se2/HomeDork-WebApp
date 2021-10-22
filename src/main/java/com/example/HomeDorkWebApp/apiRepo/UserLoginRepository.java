package com.example.HomeDorkWebApp.apiRepo;

import com.example.HomeDorkWebApp.model.SignInResponse;
import com.example.HomeDorkWebApp.model.User;
import com.example.HomeDorkWebApp.model.UserFirebase;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.ArrayList;
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
        List<UserFirebase> userFirebases = Unirest.post("https://identitytoolkit.googleapis.com/v1/accounts:lookup?key="+apikey)
                .body(urlCompletion)
                .asObject(new GenericType<List<UserFirebase>>() {
                }).getBody();

    }

    public void addUserToServer(String UUID, String Name){
        User user = Unirest.post("https://8c14-83-248-0-117.ngrok.io/hd-api/users/add/"+UUID+"/"+Name+"/{email}").
                asObject(User.class).getBody();

    }

    public void addUserDevices(String UUID){

    //   ArrayList<Object> = Unirest.get("https://8c14-83-248-0-117.ngrok.io/hd-api/users/add/"+UUID+"/");

    }
}
