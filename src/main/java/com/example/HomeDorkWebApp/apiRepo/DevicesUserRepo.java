package com.example.HomeDorkWebApp.apiRepo;

import com.example.HomeDorkWebApp.model.Fan;
import com.example.HomeDorkWebApp.model.Lamp;
import com.example.HomeDorkWebApp.model.State;
import kong.unirest.Unirest;

import java.util.List;

/**
 * fetch user uuid
 * create object of fan
 * fetch device fan lamp
 * get user devices
 *
 */


public class DevicesUserRepo {
    public String urlCompletation;

    public List<Fan> getFan(String tokenId) {
        List<Fan> fan = Unirest.get("https://8c14-83-248-0-117.ngrok.io/hd-api/" + tokenId + "/fans")
                .asObject(List.class).getBody();
        return fan;
    }

    public List<Lamp> getLamb(String tokenId) {
        List<Lamp> lamp = Unirest.get("https://8c14-83-248-0-117.ngrok.io/hd-api/" + tokenId + "/lamp")
                .asObject(List.class).getBody();
        return lamp;
    }

    public State turnOfLamp(String ID) {
        Unirest.post("https://8c14-83-248-0-117.ngrok.io/hd-api/" + ID + "/turnoff");
        Lamp lamp = Unirest.get("https://8c14-83-248-0-117.ngrok.io/hd-api/" + ID).asObject(Lamp.class).getBody();
        if (lamp.state.equals(State.OFF)) {
            return State.OFF;
        } else {
            return State.ON;
        }
    }


    public State turnOfFan(String ID) {
        Unirest.post("https://8c14-83-248-0-117.ngrok.io/hd-api/" + ID + "/turnOff");
        Fan fan = Unirest.get("https://8c14-83-248-0-117.ngrok.io/hd-api/" + ID).asObject(Fan.class).getBody();
        if (fan.state.equals(State.OFF)) {
            return State.OFF;
        } else {
            return State.ON;
        }
    }

    public State turnOnFan(String ID) {
        Unirest.post("https://8c14-83-248-0-117.ngrok.io/hd-api/" + ID + "/turnOn");
        Fan fan = Unirest.get("https://8c14-83-248-0-117.ngrok.io/hd-api/" + ID).asObject(Fan.class).getBody();
        if (fan.state.equals(State.ON)) {
            return State.ON;
        } else {
            return State.OFF;
        }

    }

    public State turnOnLamp(String ID) {
        Unirest.post("https://8c14-83-248-0-117.ngrok.io/hd-api/" + ID + "/turnOn");
        Lamp lamp = Unirest.get("https://8c14-83-248-0-117.ngrok.io/hd-api/" + ID).asObject(Lamp.class).getBody();
        if (lamp.state.equals(State.ON)) {
            return State.ON;
        } else {
            return State.OFF;
        }

    }

    public double changeValueLamp(String ID, double level) {
        Unirest.post("https://8c14-83-248-0-117.ngrok.io/hd-api/" + ID + "/adjust/" + level);
        Lamp lamp = Unirest.get("https://8c14-83-248-0-117.ngrok.io/hd-api/" + ID).asObject(Lamp.class).getBody();
        double lampValue = lamp.getLevel();
        if (lampValue != level) {
            return lampValue;
        } else {
            System.out.println("Value did not change ");
            return lampValue;
        }


    }

    public double changeValueFan(String ID, double level) {
        Unirest.post("https://8c14-83-248-0-117.ngrok.io/hd-api/" + ID + "/adjust/" + level);
        Fan fan = Unirest.get("https://8c14-83-248-0-117.ngrok.io/hd-api/" + ID).asObject(Fan.class).getBody();
        double fanValue = fan.getLevel();
        if (fanValue == level) {
            return fanValue;
        } else {

            return level;
        }

    }
}

