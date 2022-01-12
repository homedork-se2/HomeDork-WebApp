package com.example.HomeDorkWebApp.api;

import com.example.HomeDorkWebApp.model.Thermometer;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.List;

public class ThermometerRepository {
    ///{userId}/therms
    String baseURL= "http://258e-83-248-0-117.ngrok.io/hd-api/users/";
    String hdServerLamp = "hd-api/users/";
///{userId}/therms (beginning of each alarm)

    public List<String> getThermometers(String tokenId) {
        List<String> ids = new ArrayList<>();
        List<Thermometer> thermometers = Unirest.get( baseURL + tokenId + "/therms")
                .asObject(new GenericType<List<Thermometer>>() {
                }).getBody();
        if (thermometers != null)
        for (int i = 0; i < thermometers.size(); i++){
            ids.add(thermometers.get(i).id);
        }

        return ids;
    }

    public void turnOffThermometer(String ID, String thermId) {
        //https://e22f-194-47-32-227.ngrok.io/hd-api/users/"+ID+"/lamps/"+LampId+"/turnOn
        System.out.println(Unirest.put(baseURL + ID + "/therms/"+thermId+"/turnOff").asString().getStatus());

        // Lamp lamp = Unirest.get(baseURL + ID).asObject(Lamp.class).getBody();

    }



    public void turnOnThermometer(String ID, String thermId) {

        System.out.println(Unirest.put(baseURL + ID + "/therms/"+thermId+"/turnOn").asString().getStatus());


    }

    public void slideValueThermometer(String userId,String thermId, String value) {

        Unirest.put(baseURL +userId +"/therms/"+ thermId + "/adjust/" + value).asString().getStatus();


    }
}
