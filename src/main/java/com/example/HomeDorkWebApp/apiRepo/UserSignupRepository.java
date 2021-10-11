package com.example.HomeDorkWebApp.apiRepo;

import com.example.HomeDorkWebApp.model.SignInResponse;
import com.example.HomeDorkWebApp.model.SignupResponse;
import kong.unirest.Unirest;

public class UserSignupRepository {
    private final String apikey = "AIzaSyB2mndyKz8ozmroAGsUiKRdrnB2-azxYyY";
    public String urlCompletion;

    public SignupResponse userSignup(String email, String password){
        urlCompletion = "{\"email\":\""+email+"\",\"password\":\""+password+"\",\"returnSecureToken\":true}\n";

        SignupResponse signInResponse = Unirest.post("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key="+apikey)
                .body(urlCompletion).asObject(SignupResponse.class).getBody();


        System.out.println(signInResponse);
        return signInResponse;

    }

}
