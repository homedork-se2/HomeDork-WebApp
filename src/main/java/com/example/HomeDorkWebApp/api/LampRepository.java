package com.example.HomeDorkWebApp.api;

import com.example.HomeDorkWebApp.model.Fan;
import com.example.HomeDorkWebApp.model.Lamp;
import com.example.HomeDorkWebApp.model.State;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.List;

public class LampRepository {
    String baseURL= "https://8c14-83-248-0-117.ngrok.io/hd-api/";


    public List<Lamp> getLamb(String tokenId) {
        List<Lamp> lamp = Unirest.get( baseURL + tokenId + "/lamp")
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

    public void changeValueLamp(String ID, double level) {

       int Status=  Unirest.put(baseURL + ID + "/adjust/" + level).asString().getStatus();
       
        if ( Status==200) {
            System.out.println("Succesful" );
        } else {
            System.out.println("Value did not change :  " + Status );
        }


    }


}
