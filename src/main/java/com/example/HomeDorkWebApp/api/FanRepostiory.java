package com.example.HomeDorkWebApp.api;

import com.example.HomeDorkWebApp.model.Fan;
import com.example.HomeDorkWebApp.model.Lamp;
import com.example.HomeDorkWebApp.model.State;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.List;

public class FanRepostiory {

    String baseURL= "https://8c14-83-248-0-117.ngrok.io/hd-api/";


    public List<Fan> getFan(String tokenId) {
        List<Fan> fan = Unirest.get( baseURL + tokenId + "/lamp")
                .asObject(new GenericType<List<Fan>>() {
                }).getBody();
        return fan;
    }

    public State turnOfFan(String ID) {
        Unirest.post(baseURL + ID + "/turnoff");
        Fan fan = Unirest.get(baseURL + ID).asObject(Fan.class).getBody();
        if (fan.state.equals(State.OFF)) {
            return State.OFF;
        } else {
            return State.ON;
        }
    }



    public Fan turnOnFan(String ID) {
        Unirest.post(baseURL + ID + "/turnOn");
        Fan fan = Unirest.get(baseURL + ID).asObject(Fan.class).getBody();
       return fan;

    }

    public double changeValueFan(String ID, double level) {
        Unirest.post(baseURL + ID + "/adjust/" + level);
        Fan fan = Unirest.get(baseURL + ID).asObject(Fan.class).getBody();
        double fanValue = fan.getLevel();
        if (fanValue != level) {
            return fanValue;
        } else {
            System.out.println("Value did not change ");
            return fanValue;
        }


    }

}
