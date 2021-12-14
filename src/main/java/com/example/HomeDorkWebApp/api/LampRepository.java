package com.example.HomeDorkWebApp.api;

import com.example.HomeDorkWebApp.model.Fan;
import com.example.HomeDorkWebApp.model.Lamp;
import com.example.HomeDorkWebApp.model.State;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.List;

public class LampRepository {
    String baseURL= "http://5653-83-248-0-117.ngrok.io/hd-api/users/";
    String hdServerLamp = "hd-api/users/";


    public List<Lamp> getLamb(String tokenId) {
        List<Lamp> lamp = Unirest.get( baseURL + tokenId + "/lamps")
                .asObject(new GenericType<List<Lamp>>() {
                }).getBody();
        return lamp;
    }

    public void turnOfLamp(String ID, String lampId) {
        //https://e22f-194-47-32-227.ngrok.io/hd-api/users/"+ID+"/lamps/"+LampId+"/turnOn
        System.out.println(Unirest.put(baseURL + ID + "/lamps/"+lampId+"/turnOff").asString().getStatus());

       // Lamp lamp = Unirest.get(baseURL + ID).asObject(Lamp.class).getBody();

    }



    public void turnOnLamp(String ID, String lampId) {

        System.out.println(Unirest.put(baseURL + ID + "/lamps/"+lampId+"/turnOn").asString().getStatus());


    }

    public int changeValueLamp(String userId,String lampId, String level) {

       return Unirest.put(baseURL +userId +"/"+ lampId + "/adjust/" + level).asString().getStatus();


    }


}
