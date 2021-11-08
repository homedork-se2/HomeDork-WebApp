package com.example.HomeDorkWebApp.api;

import com.example.HomeDorkWebApp.model.Fan;
import com.example.HomeDorkWebApp.model.Lamp;
import com.example.HomeDorkWebApp.model.State;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.List;

public class LampRepository {
    String baseURL= "http://d971-83-248-0-117.ngrok.io/";
    String hdServerLamp = "hd-api/users/";


    public List<Lamp> getLamb(String tokenId) {
        List<Lamp> lamp = Unirest.get( baseURL + tokenId + "/lamps")
                .asObject(new GenericType<List<Lamp>>() {
                }).getBody();
        return lamp;
    }

    public Lamp turnOfLamp(String ID) {
        Unirest.post(baseURL + ID + "/turnoff");
        Lamp lamp = Unirest.get(baseURL + ID).asObject(Lamp.class).getBody();
        return  lamp;
    }



    public Lamp turnOnLamp(String ID) {
        Unirest.post(baseURL + ID + "/turnOn");
        Lamp lamp = Unirest.get(baseURL + ID).asObject(Lamp.class).getBody();
       return lamp;

    }

    public int changeValueLamp(String userId,String lampId, String level) {

       return Unirest.put(baseURL +userId +"/"+ lampId + "/adjust/" + level).asString().getStatus();


    }


}
