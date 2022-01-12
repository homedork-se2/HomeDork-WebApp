package com.example.HomeDorkWebApp.api;

import com.example.HomeDorkWebApp.model.SignupResponse;
import kong.unirest.Unirest;

public class UserSignupRepository {
    private final String apikey = "AIzaSyB2mndyKz8ozmroAGsUiKRdrnB2-azxYyY";
    private final String hdServerURL = "";              //homedork url
    public String urlCompletion;
    private String url;

    public SignupResponse FBuserSignup(String username, String email, String password){
        urlCompletion = "{\"email\":\""+email+"\",\"password\":\""+password+"\",\"returnSecureToken\":true}\n";

        SignupResponse signInResponse = Unirest.post("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key="+apikey)
                .body(urlCompletion).asObject(SignupResponse.class).getBody();


        System.out.println(signInResponse);

        if (signInResponse != null) {
            signUpHDServer(username, email, signInResponse.getLocalId());
        }else {
            System.out.println("signInResponse is null, data was not sent to server");
        }


        return signInResponse;

    }

    public void signUpHDServer(String username, String email, String id){
        int status = Unirest.post(hdServerURL+"users/add/"+id+"/"+username+"/"+email).asString().getStatus();
        if (status == 200){
            System.out.println("User was pushed to HD server");
        }else {
            System.out.println("user was not pushed to HD server");
        }
    }

}
