package com.example.HomeDorkWebApp.apiRepo;

import com.example.HomeDorkWebApp.model.Fan;
import com.example.HomeDorkWebApp.model.Lamp;
import kong.unirest.Unirest;

import java.util.List;

/**
 * fetch user uuid
 * create object of fan
 * fetch device fan lamp
 * get user devices
 *
 */


public class DevicesUserRepo{
public String urlCompletation;

    public void getFan(String tokenId ){
       List<Fan> fan = Unirest.get("https://8c14-83-248-0-117.ngrok.io/hd-api/"+tokenId+"/fans")
               .asObject(List.class).getBody();

    }

    public void getLamb(String tokenId){
        List<Lamp> lamp = Unirest.get("https://8c14-83-248-0-117.ngrok.io/hd-api/"+tokenId+"/lamp")
                .asObject(List.class).getBody();

    }

}
